
public interface Hardware {

	String pegarNumeroDaContaCartao() throws FalhaNoLogin;

	void entregarDinheiro() throws FalhaAoEntregarDinheiro;

	void lerEnvelope() throws FalhaAoLerEnvelope;
}
