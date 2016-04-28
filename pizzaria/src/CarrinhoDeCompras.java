
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

	private List<Pizza> pizzas = new ArrayList<>();

	public void adicionaPizza(Pizza pizza) {
		if (pizza.numeroDeIngredientes == 0)
			throw new InvalidParameterException("Pizza precisa de ingredientes!");
		pizzas.add(pizza);
	}

	public int total() {
		return pizzas.stream().mapToInt(pizza -> pizza.getPreco()).sum();
	}

}
