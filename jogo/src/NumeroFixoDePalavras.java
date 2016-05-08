
public class NumeroFixoDePalavras implements MecanicaDoJogo {

	private static final int LIMITE_INTERACOES = 10;
	private static final int MAXIMO_TENTATIVAS = 3;

	private int pontuacao;
	private BancoDePalavras banco;
	private Embaralhador embaralhador;
	private int interacoes;
	private String palavra;
	private int erros;

	public NumeroFixoDePalavras() {
		banco = new BancoDePalavras();
		embaralhador = FabricaEmbaralhadores.getInstancia().getEmbaralhador();
	}

	@Override
	public String recuperaPalavraEmbaralhada() {
		palavra = banco.recupera();
		return embaralhador.embaralha(palavra);
	}

	@Override
	public boolean adivinha(String resposta) {
		boolean acertou = resposta.equals(palavra);
		if (acertou) {
			pontua();
		} else
			erros++;
		interacoes++;
		return acertou;
	}

	private void pontua() {
		pontuacao++;
		pontuacao += pontuacao + (1 * (palavra.length() <= 4 ? 0.1 : palavra.length() <= 7 ? 0.2 : 0.3));
	}

	@Override
	public boolean podeTentarNovamente() {
		return erros <= MAXIMO_TENTATIVAS;
	}

	@Override
	public void pontuacao() {
		if (erros == 0)
			pontuacao += 10;
		
		System.out.println("\n");
		System.out.println("###############");
		System.out.println("## Pontuação: " + pontuacao);
		System.out.println("## Erros: " + erros);
		System.out.println("###############");
		System.out.println("\n");
	}

	@Override
	public boolean terminou() {
		return interacoes == LIMITE_INTERACOES;
	}

}
