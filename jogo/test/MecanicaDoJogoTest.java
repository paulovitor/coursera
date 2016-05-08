import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MecanicaDoJogoTest {

	private MecanicaDoJogo mecanica;

	@Test
	public void deveTerminarQuandoAtingirUmNumeroFixoDePalavras() {
		mecanica = new NumeroFixoDePalavras();

		mecanica.recuperaPalavraEmbaralhada();

		for (int index = 0; index < 20; index++) {
			mecanica.adivinha("teste");
		}

		assertTrue(mecanica.terminou());
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
	public void deveTerminarQuandoHouverUmErro() {
		mecanica = new MorteSubita();

		mecanica.recuperaPalavraEmbaralhada();

		mecanica.adivinha("teste");

		assertTrue(mecanica.terminou());
	}

}
