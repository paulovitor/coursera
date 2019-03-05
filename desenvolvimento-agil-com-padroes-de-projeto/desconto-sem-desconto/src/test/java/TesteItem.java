import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TesteItem {

    @Test
    public void testSemDesconto() {
        Item i = new Item("tenis", 150.0);
        assertEquals(300.0, i.precoQuantidade(2), 0.001);
        assertEquals("tenis R$150.0", i.toString());
    }

    @Test
    public void testSemDescontoPercentual() {
        Item i = new Item("tenis", 150.0, new DescontoPercentual(10));
        assertEquals(270.0, i.precoQuantidade(2), 0.001);
        assertEquals("tenis R$135.0", i.toString());
    }

    @Test
    public void testSemDescontoAbsoluto() {
        Item i = new Item("tenis", 150.0, new DescontoAbsoluto(10));
        assertEquals(280.0, i.precoQuantidade(2), 0.001);
        assertEquals("tenis R$140.0", i.toString());
    }
}
