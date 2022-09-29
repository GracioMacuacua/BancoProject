package contabancaria;

import java.util.Scanner;

/**
 *
 * @author Grácio Macuácua
 */
public class Executavel {
    
    
    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente(105236455, 100);
        
        ContaPoupanca cp = new ContaPoupanca(244884154, 200);
        
        /*Relatorio rel = new Relatorio();
        rel.gerarRelatorio(cc);
        
        rel.gerarRelatorio(cp);
        
        cc.sacar(50);
        cp.sacar(40);
        
        rel.gerarRelatorio(cc);
        
        rel.gerarRelatorio(cp);
        
        cc.transferir(10, cp);
        
        rel.gerarRelatorio(cc);
        rel.gerarRelatorio(cp);*/
        
        Banco b= new Banco();
        b.inserir(cp);
        b.inserir(cc);
        b.mostrarDados();
    }
}
