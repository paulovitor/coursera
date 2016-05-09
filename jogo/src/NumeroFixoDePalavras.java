
public class NumeroFixoDePalavras extends MecanicaDoJogoBase {

	public NumeroFixoDePalavras() {
		super();
		embaralhador = FabricaEmbaralhadores.getInstancia().getEmbaralhador();
		limiteDeInteracoes = 10;
	}

	@Override
	public boolean podeTentarNovamente() {
		return erros <= 2;
	}

	@Override
	public int pontuacao() {
		pontuacao += embaralhador.getDificuldade();
		return super.pontuacao();
	}

}
