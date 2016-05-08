import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class EmbaralhadorTest {

	private Embaralhador embaralhador;

	@Test
	public void deveEmbaralharPalavraInvertendoString() {
		embaralhador = new InverteString();
		String palavra = "amor";

		String palavraEmbaralhada = embaralhador.embaralha(palavra);

		assertPalavraEmbaralhada(palavra, palavraEmbaralhada);
		assertEquals("roma", palavraEmbaralhada);
	}

	@Test
	public void deveEmbaralharPalavraPermutandoRandomicamente() {
		embaralhador = new PermutaRandomicamente();
		String palavra = "cachorro";

		String palavraEmbaralhada = embaralhador.embaralha(palavra);

		assertPalavraEmbaralhada(palavra, palavraEmbaralhada);
	}

	@Test
	public void deveEmbaralharPalavraComTamanhoImparTrocandoPorPares() {
		embaralhador = new TrocaPorPares();
		String palavra = "humildade";

		String palavraEmbaralhada = embaralhador.embaralha(palavra);

		assertPalavraEmbaralhada(palavra, palavraEmbaralhada);
		assertEquals("uhimdldae", palavraEmbaralhada);
	}

	@Test
	public void deveEmbaralharPalavraComTamanhoParTrocandoPorPares() {
		embaralhador = new TrocaPorPares();
		String palavra = "urso";

		String palavraEmbaralhada = embaralhador.embaralha(palavra);

		assertPalavraEmbaralhada(palavra, palavraEmbaralhada);
		assertEquals("ruos", palavraEmbaralhada);
	}

	private void assertPalavraEmbaralhada(String palavra, String palavraEmbaralhada) {
		assertNotNull(palavraEmbaralhada);
		assertEquals(palavra.length(), palavraEmbaralhada.length());
		assertNotEquals(palavra, palavraEmbaralhada);
	}
}
