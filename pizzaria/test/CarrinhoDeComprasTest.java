import static org.junit.Assert.assertEquals;

import java.security.InvalidParameterException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CarrinhoDeComprasTest {

	private CarrinhoDeCompras carrinhoDeCompras;

	@Before
	public void inicializa() {
		carrinhoDeCompras = new CarrinhoDeCompras();
	}

	@After
	public void finaliza() {
		Pizza.removeIngredientes();
		carrinhoDeCompras = null;
	}

	@Test(expected = InvalidParameterException.class)
	public void naoDeveAdicionarPizzaSemIngredientes() {
		carrinhoDeCompras.adicionaPizza(new Pizza());
	}

	@Test
	public void deveCalcularPrecoDePizzas() {
		Pizza pizza1 = new Pizza();
		pizza1.adicionaIngrediente("Mussarela");
		pizza1.adicionaIngrediente("Tomate");

		Pizza pizza2 = new Pizza();
		pizza2.adicionaIngrediente("Frango");
		pizza2.adicionaIngrediente("Catupiry");
		pizza2.adicionaIngrediente("Mussarela");

		Pizza pizza3 = new Pizza();
		pizza3.adicionaIngrediente("Presunto");
		pizza3.adicionaIngrediente("Mussarela");
		pizza3.adicionaIngrediente("Ovo");
		pizza3.adicionaIngrediente("Tomate");
		pizza3.adicionaIngrediente("Pimentão");
		pizza3.adicionaIngrediente("Oregano");
		pizza3.adicionaIngrediente("Cebola");

		CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
		carrinhoDeCompras.adicionaPizza(pizza1);
		carrinhoDeCompras.adicionaPizza(pizza2);
		carrinhoDeCompras.adicionaPizza(pizza3);

		assertEquals(carrinhoDeCompras.total(), 58);
	}

}
