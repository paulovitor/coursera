public class GeradorNome {

    private Tratamento tratamento = new NullTratamento();

    public String gerarNome(String nomeBase) {
        return tratamento.tratar() + getTratamento() + nomeBase;
    }

    protected String getTratamento() {
        return "";
    }

    public Tratamento getTratamentoStrategy() {
        return tratamento;
    }

    public void setTratamento(Tratamento tratamento) {
        this.tratamento = tratamento;
    }
}
