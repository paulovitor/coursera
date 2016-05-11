
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProdutoComTamanhoTest extends ProdutoTest {

	@Before
	public void setUp() {
		produto = new ProdutoComTamanho("Blusa", 123, 10.00, 40);
	}

	@After
	public void tearDown() {
		produto = null;
	}

	@Test
	public void deveVerificarQueProdutoEhIgual() {
		Produto produto2 = new ProdutoComTamanho("Blusa regata", 123, 11.00, 40);

		assertTrue(produto.equals(produto2));
	}

	@Test
	public void deveVerificarQueProdutoEhDiferente() {
		Produto produto2 = new ProdutoComTamanho("Calça", 123, 10.00, 42);

		assertFalse(produto.equals(produto2));
	}

}
