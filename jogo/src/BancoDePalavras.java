import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

public class BancoDePalavras {

	private Random random = new Random();

	public String recupera() {
		Set<Object> palavras = getPalavras();

		int index = getAlgumIndex(palavras.size());

		return (String) palavras.toArray()[index];
	}

	private Set<Object> getPalavras() {
		Properties properties = new Properties();
		InputStream stream = BancoDePalavras.class.getResourceAsStream("/palavras.properties");
		try {
			properties.load(stream);
		} catch (IOException e) {
			throw new RuntimeException("Erro ao recuperar palavra!");
		}
		return properties.keySet();
	}

	private int getAlgumIndex(int tamanho) {
		return random.nextInt(tamanho);
	}

}
