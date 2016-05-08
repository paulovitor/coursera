public interface MecanicaDoJogo {

	String recuperaPalavraEmbaralhada();

	boolean adivinha(String nextLine);

	boolean podeTentarNovamente();

	void pontuacao();

	boolean terminou();

}
