

public class MockHardwareComFalhaFuncionamento implements Hardware {

	@Override
	public String pegarNumeroDaContaCartao() throws FalhaFuncionamento {
		throw new FalhaFuncionamento("Falha ao fazer login");
	}

	@Override
	public void entregarDinheiro() throws FalhaFuncionamento {
		throw new FalhaFuncionamento("Falha ao entregar dinheiro");
	}

	@Override
	public void lerEnvelope() throws FalhaFuncionamento {
		throw new FalhaFuncionamento("Falha ao ler envelope");
	}
}
