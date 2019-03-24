import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

public class TesteProxySeguranca {

    @Test
    public void testeAutorizaAcesso() {
        Usuario guerra = new Usuario("Guerra");
        guerra.autorizaAcesso("InterfaceNegocio", "executaTransacao");
        NegocioMock mock = new NegocioMock();
        InterfaceNegocio n = new SegurancaNegocio(mock, guerra);
        n.executaTransacao();

        assertTrue(mock.foiAcessado());
    }

    @Test
    public void testeNaoAutorizaAcesso() {
        Usuario guerra = new Usuario("Guerra");
        guerra.autorizaAcesso("InterfaceNegocio", "executaTransacao");
        NegocioMock mock = new NegocioMock();
        InterfaceNegocio n = new SegurancaNegocio(mock, guerra);
        try {
            n.cancelaTransacao();
            fail();
        } catch (Exception e) {
            assertFalse(mock.foiAcessado());
        }
    }
}
