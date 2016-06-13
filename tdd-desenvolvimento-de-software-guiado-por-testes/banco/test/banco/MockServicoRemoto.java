package banco;

import static org.junit.Assert.assertEquals;

public class MockServicoRemoto implements ServicoRemoto {

	private Conta contaEsperada;

	@Override
	public Conta recuperarConta(String numero) {
		return contaEsperada;
	}

	@Override
	public void persistirConta(Conta conta) {
		contaEsperada = conta;
	}

	public void verificaSaldoConta(double valorEsperado) {
		assertEquals(valorEsperado, contaEsperada.getSaldo(), 0.01);
	}

}
