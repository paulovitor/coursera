
public abstract class MecanicaDoJogoBase implements MecanicaDoJogo {

	private BancoDePalavras banco;
	protected Embaralhador embaralhador;
	protected int erros;
	private int interacoes;
	protected int limiteDeInteracoes;
	private String palavra;
	protected int pontuacao;

	public MecanicaDoJogoBase() {
		banco = new BancoDePalavras();
		limiteDeInteracoes = 20;
	}

	@Override
	public String recuperaPalavraEmbaralhada() {
		palavra = banco.recupera();
		return embaralhador.embaralha(palavra);
	}

	@Override
	public boolean adivinha(String resposta) {
		interacoes++;
		boolean acertou = resposta.equals(palavra);
		if (acertou) {
			pontua();
		} else
			erros++;
		return acertou;
	}

	protected void pontua() {
		pontuacao++;
		pontuacao += (pontuacao * (palavra.length() <= 4 ? 0.01 : palavra.length() <= 7 ? 0.02 : 0.03));
	}

	@Override
	public int pontuacao() {
		if (erros == 0)
			pontuacao += 10;
		return pontuacao;
	}

	@Override
	public boolean terminou() {
		return interacoes == limiteDeInteracoes;
	}
}
