
public class Conta {

	private String numero;
	private double saldo;

	public Conta(String numero, double saldo) {
		this.numero = numero;
		this.saldo = saldo;
	}

	public String getNumero() {
		return numero;
	}

	public Double getSaldo() {
		return this.saldo;
	}

	public void credita(double valor) {
		saldo = saldo - valor;
	}

	public void deposita(double valor) {
		saldo = saldo + valor;
	}
}
