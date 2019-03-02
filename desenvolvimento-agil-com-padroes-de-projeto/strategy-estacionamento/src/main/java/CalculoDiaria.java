public class CalculoDiaria implements Calculo {

    private int valorDiaria;

    public CalculoDiaria(int valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public int calcularTarifa(int qtdHoras) {
        return this.valorDiaria * (int) Math.ceil(qtdHoras / 24.0);
    }
}
