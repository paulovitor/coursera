
public class InverteString implements Embaralhador {

	@Override
	public String embaralha(String palavra) {
		String palavraEmbaralhada = "";
		char[] letras = palavra.toCharArray();
		for (int index = letras.length - 1; index >= 0; index--) {
			palavraEmbaralhada += letras[index];
		}
		return palavraEmbaralhada;
	}

	@Override
	public int getDificuldade() {
		return 1;
	}

}
