
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProdutoTest {

	protected Produto produto;

	@Before
	public void setUp() {
		produto = new Produto("Blusa", 12, 10.00);
	}

	@After
	public void tearDown() {
		produto = null;
	}

	@Test
	public void deveVerificarQueProdutoEhIgual() {
		Produto produto2 = new Produto("Blusa regata", 12, 11.00);

		assertTrue(produto.equals(produto2));
	}

	@Test
	public void deveVerificarQueProdutoEhDiferente() {
		Produto produto2 = new Produto("Calça", 21, 10.00);

		assertFalse(produto.equals(produto2));
	}

}
