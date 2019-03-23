public class TrechoAereoComConexao extends TrechoAereoComEscala {

    private final int tarifaConexao;

    public TrechoAereoComConexao(TrechoAereo t1, TrechoAereo t2, int tarifaConexao) {
        super(t1, t2);
        this.tarifaConexao = tarifaConexao;
    }

    @Override
    public int getCusto() {
        return super.getCusto() + tarifaConexao;
    }
}
