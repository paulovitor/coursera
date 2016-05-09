
public class NumeroDeErros extends MecanicaDoJogoBase {

	@Override
	public String recuperaPalavraEmbaralhada() {
		embaralhador = FabricaEmbaralhadores.getInstancia().getEmbaralhador();
		return super.recuperaPalavraEmbaralhada();
	}

	@Override
	protected void pontua() {
		super.pontua();
		pontuacao += embaralhador.getDificuldade();
	}

	@Override
	public boolean podeTentarNovamente() {
		return erros <= 1;
	}

	@Override
	public boolean terminou() {
		return super.terminou() || erros == 5;
	}

}
