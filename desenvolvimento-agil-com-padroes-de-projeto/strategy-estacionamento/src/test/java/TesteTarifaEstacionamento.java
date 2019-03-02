import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TesteTarifaEstacionamento {

    @Test
    public void tarifaFixaPorHora() {
        TarifaEstacionamento tarifa = new TarifaEstacionamento(3, new CalculoPorHora(4));
        int valor = tarifa.valor();
        assertEquals(12, valor);
    }

    @Test
    public void tarifaComValorInicialDepoisFixaPorHora() {
        TarifaEstacionamento tarifa = new TarifaEstacionamento(5, new CalculoHoraValorInicial(5, 3, 2));
        int valor = tarifa.valor();
        assertEquals(9, valor);
    }

    @Test
    public void tarifaComValorInicialDentroDoLimite() {
        TarifaEstacionamento tarifa = new TarifaEstacionamento(2, new CalculoHoraValorInicial(5, 3, 2));
        int valor = tarifa.valor();
        assertEquals(5, valor);
    }

    @Test
    public void tarifaDiaria() {
        TarifaEstacionamento tarifa = new TarifaEstacionamento(50, new CalculoDiaria(20));
        int valor = tarifa.valor();
        assertEquals(60, valor);
    }

    @Test
    public void tarifaDiariaMenorQueUmDia() {
        TarifaEstacionamento tarifa = new TarifaEstacionamento(10, new CalculoDiaria(20));
        int valor = tarifa.valor();
        assertEquals(20, valor);
    }
}
