public class TarifaEstacionamento {

    private final int qtdHoras;
    private final Calculo calculo;

    public TarifaEstacionamento(int qtdHoras, Calculo calculo) {
        this.qtdHoras = qtdHoras;
        this.calculo = calculo;
    }

    public int valor() {
        return this.calculo.calcularTarifa(this.qtdHoras);
    }
}
