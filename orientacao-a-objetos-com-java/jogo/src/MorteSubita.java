
public class MorteSubita extends MecanicaDoJogoBase {

	@Override
	public String recuperaPalavraEmbaralhada() {
		embaralhador = FabricaEmbaralhadores.getEmbaralhador();
		return super.recuperaPalavraEmbaralhada();
	}

	@Override
	protected void pontua() {
		super.pontua();
		pontuacao += embaralhador.getDificuldade();
	}

	@Override
	public boolean podeTentarNovamente() {
		return false;
	}

	@Override
	public boolean terminou() {
		return super.terminou() || erros == 1;
	}

}
