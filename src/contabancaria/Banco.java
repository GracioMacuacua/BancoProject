package contabancaria;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import pck.Relatorio;

/**
 *
 * @author Grácio Macuácua
 */
public class Banco implements Imprimivel {
    
    private final ArrayList<ContaBancaria> contas = new ArrayList<>();
    
    /**    
     * 
     * @param conta Conta a ser inserida no ArrayList
     */
    public void inserir(ContaBancaria conta) {
        contas.add(conta);
        JOptionPane.showMessageDialog(null, "Conta guardada com sucesso");
    }
    
    /**
     * 
     * @param conta Conta a ser removida do ArrayList
     */
    public void remover(ContaBancaria conta) {
        contas.remove(conta);
    }
    
    /**
     * Faz a busca por uma conta
     * @param numeroDeConta número de conta a buscar
     * @return A conta que se busca ou null
     */
    public ContaBancaria procurarConta(int numeroDeConta) {
        for(int i = 0; i < contas.size(); i++){
            if(contas.get(i).numeroDeConta == numeroDeConta){                
                return contas.get(i);
            }
        }
        
        return null;
    }

    /**
     * Exibe os dados de todas as contas criadas
     */
    @Override
    public void mostrarDados() {
        ContaCorrente cc;
        ContaPoupanca cp;
        for(int i = 0; i < contas.size(); i++) {
            if(contas.get(i).getClass() == ContaCorrente.class){
                cc = (ContaCorrente) contas.get(i);
                cc.mostrarDados();
            } else {
                cp = (ContaPoupanca) contas.get(i);
                cp.mostrarDados();
            }
            Relatorio.model.addRow(new Object[]{contas.get(i).numeroDeConta, contas.get(i).saldo});
        }
    }
    
}
