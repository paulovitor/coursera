public class Item {

    private final String nome;
    private final double valor;
    private Desconto desconto;

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
        if (desconto != null) {
            return nome + " R$" + desconto.darDesconto(valor);
        }
        return nome + " R$" + valor;
    }

    public double precoQuantidade(int qtd) {
        if (desconto != null) {
            return desconto.darDesconto(valor) * qtd;
        } else {
            return valor * qtd;
        }
    }
}
