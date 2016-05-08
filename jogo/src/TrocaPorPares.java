
public class TrocaPorPares implements Embaralhador {

	@Override
	public String embaralha(String palavra) {
		String palavraEmbaralhada = "";
		char[] letras = palavra.toCharArray();
		for (int index = 0; index < letras.length; index++) {
			palavraEmbaralhada += ehPar(index) ? letras.length == index + 1 ? letras[index] : letras[index + 1] : letras[index - 1];
		}
		return palavraEmbaralhada;
	}

	private boolean ehPar(int index) {
		return index % 2 == 0;
	}

}
