public class CalculoPorHora implements Calculo {

    private int valorHora;

    public CalculoPorHora(int valorHora) {
        this.valorHora = valorHora;
    }

    public int calcularTarifa(int qtdHoras) {
        return this.valorHora * qtdHoras;
    }
}
