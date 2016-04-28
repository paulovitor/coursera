
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CarrinhoDeComprasTest {

	private CarrinhoDeCompras carrinhoDeCompras;

	@Before
	public void setUp() {
		carrinhoDeCompras = new CarrinhoDeCompras();
	}

	@After
	public void tearDown() {
		carrinhoDeCompras = null;
	}

	@Test
	public void deveAdicionarProdutosIguais() {
		Produto produto = new Produto("Meia", 123, 5.00);
		Produto produto2 = new Produto("Meiao", 123, 6.00);

		carrinhoDeCompras.adicionaProduto(produto, 2);
		carrinhoDeCompras.adicionaProduto(produto2, 1);

		assertTrue(carrinhoDeCompras.getProdutos().size() == 1);
		assertEquals(new Integer(3), carrinhoDeCompras.getProdutos().get(produto));
	}

	@Test
	public void deveAdicionarProdutosDiferentes() {
		Produto produto = new Produto("Meia", 123, 5.00);
		Produto produto2 = new Produto("Calça", 456, 40.00);

		carrinhoDeCompras.adicionaProduto(produto, 2);
		carrinhoDeCompras.adicionaProduto(produto2, 1);

		assertTrue(carrinhoDeCompras.getProdutos().size() == 2);
		assertEquals(new Integer(2), carrinhoDeCompras.getProdutos().get(produto));
		assertEquals(new Integer(1), carrinhoDeCompras.getProdutos().get(produto2));
	}

	@Test
	public void deveAdicionarProdutosComTamanhoIguais() {
		Produto produto = new ProdutoComTamanho("Meia", 123, 5.00, 40);
		Produto produto2 = new ProdutoComTamanho("Meiao", 123, 6.00, 40);

		carrinhoDeCompras.adicionaProduto(produto, 2);
		carrinhoDeCompras.adicionaProduto(produto2, 1);

		assertTrue(carrinhoDeCompras.getProdutos().size() == 1);
		assertEquals(new Integer(3), carrinhoDeCompras.getProdutos().get(produto));
	}

	@Test
	public void deveAdicionarProdutosComTamanhoDiferentes() {
		Produto produto = new ProdutoComTamanho("Meia", 123, 5.00, 40);
		Produto produto2 = new ProdutoComTamanho("Calça", 123, 6.00, 42);

		carrinhoDeCompras.adicionaProduto(produto, 2);
		carrinhoDeCompras.adicionaProduto(produto2, 1);

		assertTrue(carrinhoDeCompras.getProdutos().size() == 2);
		assertEquals(new Integer(2), carrinhoDeCompras.getProdutos().get(produto));
		assertEquals(new Integer(1), carrinhoDeCompras.getProdutos().get(produto2));
	}

	@Test
	public void deveRemoverQuantidadeMenorQueJaExisteDeProdutos() {
		Produto produto = new Produto("Meia", 123, 5.00);
		Produto produto2 = new ProdutoComTamanho("Calça", 123, 6.00, 42);

		carrinhoDeCompras.adicionaProduto(produto, 2);
		carrinhoDeCompras.adicionaProduto(produto2, 1);

		carrinhoDeCompras.removeProduto(produto, 1);
		carrinhoDeCompras.removeProduto(produto2, 1);

		assertTrue(carrinhoDeCompras.getProdutos().size() == 1);
		assertEquals(new Integer(1), carrinhoDeCompras.getProdutos().get(produto));
	}

	@Test
	public void deveRemoverQuantidadeMaiorQueJaExisteDeProdutos() {
		Produto produto = new Produto("Meia", 123, 5.00);
		Produto produto2 = new ProdutoComTamanho("Calça", 123, 6.00, 42);

		carrinhoDeCompras.adicionaProduto(produto, 2);
		carrinhoDeCompras.adicionaProduto(produto2, 3);

		carrinhoDeCompras.removeProduto(produto, 2);
		carrinhoDeCompras.removeProduto(produto2, 5);

		assertTrue(carrinhoDeCompras.getProdutos().size() == 0);
	}

	@Test
	public void deveCalcularValorTotal() {
		Produto produto = new Produto("Meia", 123, 5.00);
		Produto produto2 = new ProdutoComTamanho("Calça", 123, 6.00, 42);

		carrinhoDeCompras.adicionaProduto(produto, 2);
		carrinhoDeCompras.adicionaProduto(produto2, 4);

		assertEquals(34.00, carrinhoDeCompras.calculaValorTotal(), 0.01);
	}

}
