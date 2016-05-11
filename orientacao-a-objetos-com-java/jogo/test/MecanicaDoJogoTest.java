import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MecanicaDoJogoTest {

	private MecanicaDoJogo mecanica;

	@Test
	public void deveTerminarQuandoAtingirUmNumeroFixoDePalavras() {
		mecanica = new NumeroFixoDePalavras();

		mecanica.recuperaPalavraEmbaralhada();

		for (int index = 0; index < 10; index++) {
			mecanica.adivinha("teste");
		}

		assertTrue(mecanica.terminou());
	}

	@Test
	public void devePermitirTentarNovamenteDuasVezes() {
		mecanica = new NumeroFixoDePalavras();

		mecanica.recuperaPalavraEmbaralhada();

		mecanica.adivinha("teste");

		assertTrue(mecanica.podeTentarNovamente());

		mecanica.adivinha("teste");

		assertTrue(mecanica.podeTentarNovamente());

		mecanica.adivinha("teste");

		assertFalse(mecanica.podeTentarNovamente());
	}

	@Test
	public void deveTerminarQuandoAtingirUmNumeroDeErros() {
		mecanica = new NumeroDeErros();

		mecanica.recuperaPalavraEmbaralhada();

		for (int index = 0; index < 5; index++) {
			mecanica.adivinha("teste");
		}

		assertTrue(mecanica.terminou());
	}

	@Test
	public void devePermitirTentarNovamenteUmaVez() {
		mecanica = new NumeroDeErros();

		mecanica.recuperaPalavraEmbaralhada();

		mecanica.adivinha("teste");

		assertTrue(mecanica.podeTentarNovamente());

		mecanica.adivinha("teste");

		assertFalse(mecanica.podeTentarNovamente());
	}

	@Test
	public void deveTerminarQuandoHouverUmErro() {
		mecanica = new MorteSubita();

		mecanica.recuperaPalavraEmbaralhada();

		mecanica.adivinha("teste");

		assertTrue(mecanica.terminou());
	}

	@Test
	public void naoDevePermitirTentarNovamenteAposUmErro() {
		mecanica = new MorteSubita();

		mecanica.recuperaPalavraEmbaralhada();

		mecanica.adivinha("teste");

		assertFalse(mecanica.podeTentarNovamente());
	}

}
