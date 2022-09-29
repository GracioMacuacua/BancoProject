package contabancaria;

/**
 *
 * @author Grácio Macuácua
 */
public class ContaCorrente extends ContaBancaria implements Imprimivel {

    double taxaDeOperacao = 0.1;
    
    public ContaCorrente(int numeroDeConta, double saldo) {
        this.numeroDeConta = numeroDeConta;
        this.saldo = saldo;
    }
    
    /**
     * 
     * @return o número de conta
     */
    public int getNumeroDeConta() {
        return numeroDeConta;
    }
    
    /**
     * 
     * @return o saldo actual da conta
     */
    public double getSaldo() {
        return saldo;
    }
    
    /**
     * Faz o saque de um valor solicitado da conta do utilizador
     * @param valor valor a retirar da conta 
     */
    @Override
    public void sacar(double valor) {

        
        saldo-=valor + saldo*taxaDeOperacao;
    }

    /**
     * Faz o depósito de um valor na conta do utilizador
     * @param valor valor a ser depositado na conta
     */
    @Override
    public void depositar(double valor) {
        
        saldo += valor-saldo*taxaDeOperacao;
    }

    /**
     * Imprime os dados da conta do utilizador
     */
    @Override
    public void mostrarDados() {
        System.out.println("Número de conta: " + numeroDeConta + "\nSaldo: " + saldo);
    }

    /**
     * Transfere um valor da conta actual para uma conta de destino
     * @param valor O valor a ser transferido
     * @param contaBancaria A conta que deve receber o valor a transferir
     * 
     */
    @Override
    public void transferir(double valor, ContaBancaria contaBancaria) {        
            sacar(valor);
            contaBancaria.depositar(valor);
    }
    
}
