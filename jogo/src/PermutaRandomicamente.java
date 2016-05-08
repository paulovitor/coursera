import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermutaRandomicamente implements Embaralhador {

	@Override
	public String embaralha(String palavra) {
		StringBuffer palavraEmbaralhada = new StringBuffer(palavra.length());
		List<String> letras = Arrays.asList(palavra.split(""));
		Collections.shuffle(letras);
		for (String letra : letras) {
			palavraEmbaralhada.append(letra);
		}
		return palavraEmbaralhada.toString();
	}

}
