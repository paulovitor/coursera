import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class BancoDePalavrasTest {

	private BancoDePalavras banco;

	@Before
	public void setUp() {
		banco = new BancoDePalavras();
	}

	@Test
	public void deveRecuperarPalavraAleatoriamente() throws IOException {
		String primeira = banco.recupera();
		String segunda = banco.recupera();

		assertNotNull(primeira);
		assertNotNull(segunda);
		assertNotEquals(primeira, segunda);
	}

}
