import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class CamelCaseTest {

	@Test
	public void deveConverterStringSimplesLowerCase() {
		List<String> palavras = CamelCase.converterCamelCase("nome");

		assertStringSimples(palavras, "nome");
	}

	@Test
	public void deveConverterStringSimpleComPrimeiraLetraMaiuscula() {
		List<String> palavras = CamelCase.converterCamelCase("Nome");

		assertStringSimples(palavras, "nome");
	}

	@Test
	public void deveConverterStringComposta() {
		List<String> palavras = CamelCase.converterCamelCase("nomeComposto");

		assertStringComposta(palavras, "nome", "composto");
	}

	@Test
	public void deveConverterStringCompostaComPrimeiroLetraMaiuscula() {
		List<String> palavras = CamelCase.converterCamelCase("NomeComposto");

		assertStringComposta(palavras, "nome", "composto");
	}

	@Test
	public void deveConverterStringSimplesUpperCase() {
		List<String> palavras = CamelCase.converterCamelCase("CPF");

		assertStringSimples(palavras, "CPF");
	}

	@Test
	public void deveConverterStringCompostaComUmaStringUpperCase() {
		List<String> palavras = CamelCase.converterCamelCase("numeroCPF");

		assertStringComposta(palavras, "numero", "CPF");
	}

	@Test
	public void deveConverterStringCompostaDeTresPalavrasComUmaStringUpperCase() {
		List<String> palavras = CamelCase.converterCamelCase("numeroCPFContribuinte");

		assertStringComposta(palavras, "numero", "CPF", "contribuinte");
	}

	@Test
	public void deveConverterStringCompostaDeTresPalavrasComNumero() {
		List<String> palavras = CamelCase.converterCamelCase("recupera10Primeiros");

		assertStringComposta(palavras, "recupera", "10", "primeiros");
	}

	@Test(expected = StringInvalidaException.class)
	public void naoDeveConverterStringQueComecaComNumeros() {
		CamelCase.converterCamelCase("10Primeiros");
	}

	@Test(expected = StringInvalidaException.class)
	public void naoDeveConverterStringComCaracteresEspeciais() {
		CamelCase.converterCamelCase("nome#Composto");
	}

	private void assertStringSimples(List<String> palavras, String palavra) {
		assertNotNull(palavras);
		assertFalse(palavras.isEmpty());
		assertTrue(palavras.size() == 1);
		assertEquals(palavras.get(0), palavra);
	}

	private void assertStringComposta(List<String> palavras, String... strings) {
		assertNotNull(palavras);
		assertFalse(palavras.isEmpty());
		assertTrue(palavras.size() == strings.length);
		assertEquals(palavras.get(0), strings[0]);
		assertEquals(palavras.get(1), strings[1]);
	}

}
