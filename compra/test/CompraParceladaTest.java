import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CompraParceladaTest {

	private static final double TAXA_JUROS = 0.05;

	@Test
	public void deveCalcularTotalDeCompraParceladaEmUmaVez() {
		assertTotal(10.00, 1);
	}

	@Test
	public void deveCalcularTotalDeCompraParceladaEmDuasVezes() {
		assertTotal(10.00, 2);
	}

	@Test
	public void deveCalcularTotalDeCompraParceladaEmCincoVezes() {
		assertTotal(10.00, 5);
	}

	@Test
	public void deveCalcularTotalDeCompraParceladaEmDezVezes() {
		assertTotal(10.00, 10);
	}

	private void assertTotal(double valor, int parcelas) {
		Compra compra = new CompraParcelada(valor, parcelas, TAXA_JUROS);

		assertEquals(valor * Math.pow((1 + TAXA_JUROS), parcelas), compra.total(), 0.001);
	}

}
