public class ContadorPares implements ContadorPalavras {

    private int qtd;

    @Override
    public void contar(String palavra) {
        if (palavra.length() % 2 == 0)
            qtd++;
    }

    @Override
    public int getContagem() {
        return qtd;
    }
}
