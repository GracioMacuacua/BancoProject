package contabancaria;

/**
 *
 * @author Grácio Macuácua
 */
public class Relatorio {
    
    public void gerarRelatorio(ContaCorrente cc) {
    	cc.mostrarDados();
    }

    public void gerarRelatorio(ContaPoupanca cp) {
    	cp.mostrarDados();
    }
        
}
