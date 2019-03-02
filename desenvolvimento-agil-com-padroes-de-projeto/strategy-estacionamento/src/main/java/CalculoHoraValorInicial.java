public class CalculoHoraValorInicial implements Calculo {

    private final int valorInicial;
    private final int limiteHorasInicial;
    private final int valorHoraExcedente;

    public CalculoHoraValorInicial(int valorInicial, int limiteHorasInicial, int valorHoraExcedente) {
        this.valorInicial = valorInicial;
        this.limiteHorasInicial = limiteHorasInicial;
        this.valorHoraExcedente = valorHoraExcedente;
    }

    public int calcularTarifa(int qtdHoras) {
        int valor = this.valorInicial;
        if (qtdHoras > this.limiteHorasInicial)
            valor += (qtdHoras - this.limiteHorasInicial) * this.valorHoraExcedente;
        return valor;
    }
}
