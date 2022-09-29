package contabancaria;

/**
 *
 * @author Grácio Macuácua
 */
public abstract class ContaBancaria {
    protected int numeroDeConta;
    protected double saldo;

    public int getNumeroDeConta() {
        return numeroDeConta;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public abstract void sacar(double valor);
    public abstract void depositar(double valor);
    public abstract void transferir(double valor, ContaBancaria contaBancaria);
}
