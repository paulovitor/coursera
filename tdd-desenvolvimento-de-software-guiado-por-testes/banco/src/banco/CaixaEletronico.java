package banco;

public class CaixaEletronico {

	private ServicoRemoto servicoRemoto;
	private String numero;
	private Hardware hardware;

	public CaixaEletronico(ServicoRemoto servicoRemoto, Hardware hardware) {
		this.servicoRemoto = servicoRemoto;
		this.hardware = hardware;
	}

	public String saldo() {
		Conta conta = servicoRemoto.recuperarConta(numero);
		return "O saldo é R$ " + conta.getSaldo();
	}

	public String sacar(Double valor) {
		Conta conta = servicoRemoto.recuperarConta(numero);
		if (conta.getSaldo() < valor)
			return "Saldo insuficiente";
		conta.credita(valor);
		servicoRemoto.persistirConta(conta);
		return "Retire seu dinheiro";
	}

	public String depositar(double valor) {
		Conta conta = servicoRemoto.recuperarConta(numero);
		conta.deposita(valor);
		return "Depósito recebido com sucesso";
	}

	public String login() throws FalhaFuncionamento {
		numero = hardware.pegarNumeroDaContaCartao();
		return "Usuário Autenticado";
	}

}
