public interface MecanicaDoJogo {

	String recuperaPalavraEmbaralhada();

	boolean adivinha(String resposta);

	boolean podeTentarNovamente();

	int pontuacao();

	boolean terminou();

}
