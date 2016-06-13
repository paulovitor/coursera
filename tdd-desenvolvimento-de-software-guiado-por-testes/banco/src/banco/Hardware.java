package banco;

public interface Hardware {

	String pegarNumeroDaContaCartao() throws FalhaFuncionamento;

	void entregarDinheiro() throws FalhaFuncionamento;

	void lerEnvelope() throws FalhaFuncionamento;

}
