public class DescontoAbsoluto implements Desconto {

    private int valorDesconto;

    public DescontoAbsoluto(int valorDesconto) {
        super();
        this.valorDesconto = valorDesconto;
    }

    @Override
    public double darDesconto(double valorOriginal) {
        return valorOriginal - valorDesconto;
    }
}
