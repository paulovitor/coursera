
public class NumeroFixoDePalavras extends MecanicaDoJogoBase {

	public NumeroFixoDePalavras() {
		super();
		embaralhador = FabricaEmbaralhadores.getEmbaralhador();
		limiteDeInteracoes = 10;
	}

	@Override
	public boolean podeTentarNovamente() {
		return erros <= 2;
	}

	@Override
	public int pontuacao() {
		if (pontuacao > 0)
			pontuacao += embaralhador.getDificuldade();
		return super.pontuacao();
	}

}
