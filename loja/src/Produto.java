
public class Produto {

	private String nome;
	private int codigo;
	private double preco;

	public Produto(String nome, int codigo, double preco) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public double getPreco() {
		return preco;
	}

	@Override
	public int hashCode() {
		return codigo;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) || (obj instanceof Produto && codigo == ((Produto) obj).getCodigo());
	}

}
