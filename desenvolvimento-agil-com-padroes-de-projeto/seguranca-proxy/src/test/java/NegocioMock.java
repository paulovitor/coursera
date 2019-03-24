public class NegocioMock implements InterfaceNegocio {

    private boolean foiAcessado;

    @Override
    public void executaTransacao() {
        foiAcessado = true;
    }

    @Override
    public void cancelaTransacao() {
        foiAcessado = true;
    }

    public boolean foiAcessado() {
        return foiAcessado;
    }
}
