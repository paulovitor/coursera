public class GeradorNomeProxyLocal extends GeradorNome {

    private GeradorNome gerador;
    private String local;

    public GeradorNomeProxyLocal(GeradorNome gerador, String local) {
        this.gerador = gerador;
        this.local = local;
    }

    @Override
    public String gerarNome(String nomeBase) {
        return gerador.gerarNome(nomeBase) + " de " + local;
    }

    @Override
    public String getTratamento() {
        return gerador.getTratamento();
    }

    @Override
    public Tratamento getTratamentoStrategy() {
        return gerador.getTratamentoStrategy();
    }

    @Override
    public void setTratamento(Tratamento tratamento) {
        gerador.setTratamento(tratamento);
    }
}
