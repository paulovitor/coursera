import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AutoridadeTest {

	private Autoridade autoridade;

	@Test
	public void deveFormatarNomeNoFormatoInformal() {
		autoridade = new Autoridade("José", "Miguel", new Informal());

		assertEquals("José", autoridade.getTratamento());
	}

	@Test
	public void deveFormatarNomeMasculinoNoFormatoRespeitoso() {
		autoridade = new Autoridade("José", "Miguel", new Respeitoso(Respeitoso.MASCULINO));

		assertEquals("Sr. Miguel", autoridade.getTratamento());
	}

	@Test
	public void deveFormatarNomeFemininoNoFormatoRespeitoso() {
		autoridade = new Autoridade("Maria", "Cristina", new Respeitoso(Respeitoso.FEMININO));

		assertEquals("Sra. Cristina", autoridade.getTratamento());
	}
	
	@Test
	public void deveFormatarNomeComTitulo() {
		autoridade = new Autoridade("Paulo", "Rafael", new ComTitulo("Magnífico"));
		
		assertEquals("Magnífico Paulo Rafael", autoridade.getTratamento());
	}

}
