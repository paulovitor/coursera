public class Item {

    private final String nome;
    private final double valor;
    private Desconto desconto = new SemDesconto();

    public Item(String nome, double valor, Desconto desconto) {
        this.nome = nome;
        this.valor = valor;
        this.desconto = desconto;
    }

    public Item(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return nome + " R$" + desconto.darDesconto(valor);
    }

    public double precoQuantidade(int qtd) {
        return desconto.darDesconto(valor) * qtd;
    }
}
