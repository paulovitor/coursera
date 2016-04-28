
public class Principal {

	public static void main(String[] args) {
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

		System.out.println("Valor total de todas as pizzas: R$ " + carrinhoDeCompras.total());
		System.out.println("Total de ingredientes:");
		Pizza.imprimiIngredientes();
	}
}
