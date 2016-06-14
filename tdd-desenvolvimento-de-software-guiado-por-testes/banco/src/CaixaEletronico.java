import java.text.NumberFormat;
import java.util.Locale;

public class CaixaEletronico {

	private ServicoRemoto servicoRemoto;
	private Hardware hardware;
	private String numero;

	public CaixaEletronico(ServicoRemoto servicoRemoto, Hardware hardware) {
		this.servicoRemoto = servicoRemoto;
		this.hardware = hardware;
	}

	public String saldo() {
		Conta conta = servicoRemoto.recuperarConta(numero);
		NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		return "O saldo é " + format.format(conta.getSaldo());
	}

	public String sacar(double valor) {
		Conta conta = servicoRemoto.recuperarConta(numero);
		if (conta.getSaldo() < valor)
			return "Saldo insuficiente";
		conta.credita(valor);
		servicoRemoto.persistirConta(conta);
		try {
			hardware.entregarDinheiro();
		} catch (FalhaAoEntregarDinheiro exception) {
			return "Erro na contagem do dinheiro";
		}
		return "Retire seu dinheiro";
	}

	public String depositar(double valor) {
		Conta conta = servicoRemoto.recuperarConta(numero);
		try {
			hardware.lerEnvelope();
		} catch (FalhaAoLerEnvelope exception) {
			return "Erro ao ler envelope";
		}
		conta.deposita(valor);
		servicoRemoto.persistirConta(conta);
		return "Depósito recebido com sucesso";
	}

	public String login() {
		try {
			numero = hardware.pegarNumeroDaContaCartao();
		} catch (FalhaNoLogin exception) {
			return "Não foi possível autenticar o usuário";
		}
		return "Usuário Autenticado";
	}
}
