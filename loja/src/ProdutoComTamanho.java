
public class ProdutoComTamanho extends Produto {

	private int tamanho;

	public ProdutoComTamanho(String nome, int codigo, double preco, int tamanho) {
		super(nome, codigo, preco);
		this.tamanho = tamanho;
	}

	public int getTamanho() {
		return tamanho;
	}

	@Override
	public int hashCode() {
		return getCodigo() + tamanho;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && obj instanceof ProdutoComTamanho
				&& tamanho == ((ProdutoComTamanho) obj).getTamanho();
	}

}
