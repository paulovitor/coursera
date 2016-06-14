
public class MockHardwareComFalhaFuncionamento implements Hardware {

	@Override
	public String pegarNumeroDaContaCartao() throws FalhaNoLogin {
		throw new FalhaNoLogin("Falha ao fazer login");
	}

	@Override
	public void entregarDinheiro() throws FalhaAoEntregarDinheiro {
		throw new FalhaAoEntregarDinheiro("Falha ao entregar dinheiro");
	}

	@Override
	public void lerEnvelope() throws FalhaAoLerEnvelope {
		throw new FalhaAoLerEnvelope("Falha ao ler envelope");
	}
}
