import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Map;

import org.junit.Test;

public class ProcessadorArquivoTest {

	@Test
	public void deveProcessarArquivoValido() throws LeituraArquivoException {
		Map<String, String> mapa = ProcessadorArquivo.processar("informacoes.txt");

		assertNotNull(mapa);
		assertTrue(mapa.size() > 0);
	}

	@Test
	public void naoDeveProcessarArquivoInexistente() {
		try {
			ProcessadorArquivo.processar("inexistente.txt");
			fail();
		} catch (LeituraArquivoException e) {
			assertEquals("Erro ao abrir o arquivo inexistente.txt (No such file or directory)", e.getMessage());
		}
	}

	@Test
	public void naoDeveProcessarArquivoVazio() {
		try {
			ProcessadorArquivo.processar("vazio.txt");
			fail();
		} catch (LeituraArquivoException e) {
			assertEquals("Arquivo vazio", e.getMessage());
		}
	}

	@Test
	public void naoDeveProcessarArquivoInvalido() {
		try {
			ProcessadorArquivo.processar("invalido.txt");
			fail();
		} catch (LeituraArquivoException e) {
			assertEquals("Formato de arquivo inválido", e.getMessage());
		}
	}

}
