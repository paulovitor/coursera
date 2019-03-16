import java.util.HashMap;
import java.util.Map;

public class QuebradorPalavras {

    private Map<String, ContadorPalavras> contadores = new HashMap<>();

    public String[] quebrar(String frase) {
        String[] palavras = frase.split(" ");
        for (String palavra : palavras) {
            for (ContadorPalavras contador : contadores.values()) {
                contador.contar(palavra);
            }
        }
        return palavras;
    }

    public void adicionaContador(String nome, ContadorPalavras contador) {
        contadores.put(nome, contador);
    }

    public int getContagem(String nome) {
        return contadores.get(nome).getContagem();
    }
}
