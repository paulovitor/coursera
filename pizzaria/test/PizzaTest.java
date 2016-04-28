
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PizzaTest {

	private Pizza pizza;

	@Before
	public void inicializa() {
		pizza = new Pizza();
	}

	@After
	public void finaliza() {
		Pizza.removeIngredientes();
		pizza = null;
	}

	@Test
	public void deveCalcularPrecoDaPizzaComDoisIngredientes() {
		pizza.adicionaIngrediente("Mussarela");
		pizza.adicionaIngrediente("Tomate");

		assertEquals(pizza.getPreco(), 15);
	}

	@Test
	public void deveCalcularPrecoDaPizzaComTresIngredientes() {
		pizza.adicionaIngrediente("Frango");
		pizza.adicionaIngrediente("Catupiry");
		pizza.adicionaIngrediente("Mussarela");

		assertEquals(pizza.getPreco(), 20);
	}

	@Test
	public void deveCalcularPrecoDaPizzaComMaisDeCincoIngredientes() {
		pizza.adicionaIngrediente("Presunto");
		pizza.adicionaIngrediente("Mussarela");
		pizza.adicionaIngrediente("Ovo");
		pizza.adicionaIngrediente("Tomate");
		pizza.adicionaIngrediente("Pimentão");
		pizza.adicionaIngrediente("Oregano");
		pizza.adicionaIngrediente("Cebola");

		assertEquals(pizza.getPreco(), 23);
	}

	@Test
	public void deveContabilizarAdicaoDeIngredientesEmUmaPizza() {
		pizza.adicionaIngrediente("Mussarela");
		pizza.adicionaIngrediente("Tomate");

		assertEquals(pizza.numeroDeIngredientes, 2);
		assertEquals(Pizza.getIngredientes().get("Mussarela").intValue(), 1);
		assertEquals(Pizza.getIngredientes().get("Tomate").intValue(), 1);
	}

	@Test
	public void deveContabilizarAdicaoDeIngredientesEmMaisDeUmaPizza() {
		pizza.adicionaIngrediente("Mussarela");
		pizza.adicionaIngrediente("Tomate");

		Pizza pizza2 = new Pizza();
		pizza2.adicionaIngrediente("Frango");
		pizza2.adicionaIngrediente("Catupiry");
		pizza2.adicionaIngrediente("Mussarela");

		assertEquals(pizza.numeroDeIngredientes, 2);
		assertEquals(pizza2.numeroDeIngredientes, 3);
		assertEquals(Pizza.getIngredientes().get("Mussarela").intValue(), 2);
		assertEquals(Pizza.getIngredientes().get("Tomate").intValue(), 1);
		assertEquals(Pizza.getIngredientes().get("Frango").intValue(), 1);
		assertEquals(Pizza.getIngredientes().get("Catupiry").intValue(), 1);
	}

}
