
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CaixaEletronicoTest {

	private CaixaEletronico caixaEletronico;
	private MockServicoRemoto servicoRemoto;

	@Before
	public void inicializar() {
		servicoRemoto = new MockServicoRemoto();
		servicoRemoto.persistirConta(new Conta("123", 10.0));
		caixaEletronico = new CaixaEletronico(servicoRemoto, new MockHardware());
	}

	@Test
	public void deveRecuperarSaldoDaContaCorrente() {
		assertEquals("O saldo é R$ 10,00", caixaEletronico.saldo());
		servicoRemoto.verificaSaldoConta(10.0);
	}

	@Test
	public void deveSacarValorDaContaCorrente() {
		assertEquals("Retire seu dinheiro", caixaEletronico.sacar(10.0));
		servicoRemoto.verificaSaldoConta(0.0);
	}

	@Test
	public void naoDeveSacarValorMaiorQueOSaldoDaContaCorrente() {
		assertEquals("Saldo insuficiente", caixaEletronico.sacar(20.0));
		servicoRemoto.verificaSaldoConta(10.0);
	}

	@Test
	public void naoDeveSacarDevidoAUmaFalhaDeFuncionamento() {
		caixaEletronico = new CaixaEletronico(servicoRemoto, new MockHardwareComFalhaFuncionamento());
		assertEquals("Erro na contagem do dinheiro", caixaEletronico.sacar(5.0));
	}

	@Test
	public void deveDepositarValorNaContaCorrente() {
		assertEquals("Depósito recebido com sucesso", caixaEletronico.depositar(10.0));
		servicoRemoto.verificaSaldoConta(20.0);
	}

	@Test
	public void naoDeveDepositarDevidoAUmaFalhaDeFuncionamento() {
		caixaEletronico = new CaixaEletronico(servicoRemoto, new MockHardwareComFalhaFuncionamento());
		assertEquals("Erro ao ler envelope", caixaEletronico.depositar(10.0));
	}

	@Test
	public void deveFazerLogin() {
		assertEquals("Usuário Autenticado", caixaEletronico.login());
	}

	@Test
	public void naoDeveFazerLoginDevidoAUmaFalhaDeFuncionamento() {
		caixaEletronico = new CaixaEletronico(servicoRemoto, new MockHardwareComFalhaFuncionamento());
		assertEquals("Não foi possível autenticar o usuário", caixaEletronico.login());
	}
}
