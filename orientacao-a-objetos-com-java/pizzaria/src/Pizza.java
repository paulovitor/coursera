
import java.util.HashMap;
import java.util.Map;

public class Pizza {

	public int numeroDeIngredientes = 0;

	private static Map<String, Integer> ingredientes = new HashMap<>();

	public void adicionaIngrediente(String ingrediente) {
		numeroDeIngredientes++;
		contabilizaIngrediente(ingrediente);
	}

	public int getPreco() {
		return numeroDeIngredientes <= 2 ? 15 : numeroDeIngredientes <= 5 ? 20 : 23;
	}

	private static void contabilizaIngrediente(String ingrediente) {
		int quantidade = 1;
		if (ingredientes.containsKey(ingrediente))
			quantidade = ingredientes.get(ingrediente) + 1;
		ingredientes.put(ingrediente, quantidade);
	}

	public static void imprimiIngredientes() {
		ingredientes.forEach((ingrediente, quantidade) -> {
			System.out.println(ingrediente + ": " + quantidade);
		});
	}

	public static void removeIngredientes() {
		ingredientes.clear();
	}

	public static Map<String, Integer> getIngredientes() {
		return ingredientes;
	}

}
