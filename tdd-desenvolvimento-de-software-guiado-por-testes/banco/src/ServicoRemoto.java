
public interface ServicoRemoto {

	Conta recuperarConta(String numero);

	void persistirConta(Conta conta);
}
