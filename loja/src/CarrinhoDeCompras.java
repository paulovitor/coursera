
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CarrinhoDeCompras {

	private Map<Produto, Integer> produtos = new HashMap<>();

	public Map<Produto, Integer> getProdutos() {
		return produtos;
	}

	public void adicionaProduto(Produto produto, int quantidade) {
		if (produtos.containsKey(produto)) {
			quantidade += produtos.get(produto);
		}
		produtos.put(produto, quantidade);
	}

	public void removeProduto(Produto produto, int quantidade) {
		if (produtos.containsKey(produto)) {
			Integer quantidadeAntiga = produtos.get(produto);
			if (quantidadeAntiga > quantidade) {
				produtos.put(produto, quantidadeAntiga - quantidade);
			} else {
				produtos.remove(produto);
			}
		}
	}

	public double calculaValorTotal() {
		double total = 0.00;
		for (Entry<Produto, Integer> entry : produtos.entrySet()) {
			total += entry.getKey().getPreco() * entry.getValue();
		}
		return total;
	}
}
