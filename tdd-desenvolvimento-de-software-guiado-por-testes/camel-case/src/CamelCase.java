import java.util.ArrayList;
import java.util.List;

public class CamelCase {

	private static final String CAMEL_CASE_PATTERN = "(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])";
	private static final String CONTAINS_NUMBER_PATTERN = ".*\\d.*";
	private static final String NUMBER_PATTERN = "(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)";
	private static final String SPECIAL_PATTERN = ".*[!@#$%^&*()_].*";

	public static List<String> converterCamelCase(String original) {
		validaString(original);
		List<String> palavras = new ArrayList<>();
		for (String palavra : original.split(CAMEL_CASE_PATTERN)) {
			if (stringContemNumero(palavra)) {
				for (String palavraComNumero : palavra.split(NUMBER_PATTERN))
					palavras.add(isUpperCase(palavraComNumero) ? palavraComNumero : palavraComNumero.toLowerCase());
			} else
				palavras.add(isUpperCase(palavra) ? palavra : palavra.toLowerCase());
		}
		return palavras;
	}

	private static void validaString(String string) {
		if (Character.isDigit(string.charAt(0)))
			throw new StringInvalidaException("Não deve começar com números!");
		if (string.matches(SPECIAL_PATTERN))
			throw new StringInvalidaException("Caracteres especiais não são permitidos, somente letras e números!");
	}

	private static boolean stringContemNumero(String palavra) {
		return palavra.matches(CONTAINS_NUMBER_PATTERN);
	}

	private static boolean isUpperCase(String string) {
		for (char character : string.toCharArray())
			if (!Character.isUpperCase(character))
				return false;
		return true;
	}

}
