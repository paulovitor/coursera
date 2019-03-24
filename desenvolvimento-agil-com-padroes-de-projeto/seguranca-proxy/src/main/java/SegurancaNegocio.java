public class SegurancaNegocio implements InterfaceNegocio {

    private InterfaceNegocio encapsulado;
    private Usuario usuario;

    public SegurancaNegocio(InterfaceNegocio encapsulado, Usuario usuario) {
        this.encapsulado = encapsulado;
        this.usuario = usuario;
    }

    @Override
    public void executaTransacao() {
        if (usuario.verificaPermissao("InterfaceNegocio", "executaTransacao")) {
            encapsulado.executaTransacao();
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public void cancelaTransacao() {
        if (usuario.verificaPermissao("InterfaceNegocio", "cancelaTransacao")) {
            encapsulado.cancelaTransacao();
        } else {
            throw new RuntimeException();
        }
    }
}
