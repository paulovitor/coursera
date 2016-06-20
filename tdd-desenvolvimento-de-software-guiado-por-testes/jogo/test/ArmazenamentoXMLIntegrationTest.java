import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ArmazenamentoXMLIntegrationTest {

	private Armazenamento armazenamento;
	private XStream stream = new XStream(new DomDriver());

	@Before
	public void inicializa() {
		armazenamento = new ArmazenamentoXML();

		armazenamento.registraPontos("Josue", 15, TipoDePonto.MOEDA);
		armazenamento.registraPontos("Moises", 10, TipoDePonto.MOEDA);
		armazenamento.registraPontos("Maria", 20, TipoDePonto.ENERGIA);
	}

	@After
	public void finaliza() throws FileNotFoundException {
		armazenamento = null;
		limpaArquivo();
	}

	@Test
	public void deveRegistraPontosEmArquivoXML() throws FileNotFoundException {
		Map<String, Map<TipoDePonto, Integer>> map = leArquivo();
		assertTrue(map.size() == 3);
	}

	@Test
	public void deveRegistraMaisDeUmaVezOsPontosDeUmUsuarioEmArquivoXML() throws FileNotFoundException {
		armazenamento.registraPontos("Maria", 20, TipoDePonto.ENERGIA);

		Map<String, Map<TipoDePonto, Integer>> map = leArquivo();
		assertTrue(map.size() == 3);

		assertEquals(40, armazenamento.recuperaPontosDoUsuarioPorTipo("Maria", TipoDePonto.ENERGIA));
	}

	@Test
	public void deveRecuperaPontosPorUsuario() {
		armazenamento.registraPontos("Maria", 10, TipoDePonto.MOEDA);

		Map<TipoDePonto, Integer> pontosPorUsuario = armazenamento.recuperaPontosPorUsuario("Maria");
		assertTrue(pontosPorUsuario.size() == 2);
	}
	
	@Test
	public void naoDeveRecuperaPontosPorUsuarioInexistente() {
		assertNull(armazenamento.recuperaPontosPorUsuario("José"));
	}

	@Test
	public void deveRecuperaUsuariosDoArquivoXML() {
		assertTrue(armazenamento.recuperaUsuarios().size() == 3);
	}

	@Test
	public void naoDeveRecuperaUsuariosDoArquivoXML() throws FileNotFoundException {
		finaliza();
		armazenamento = new ArmazenamentoXML();

		assertTrue(armazenamento.recuperaUsuarios().size() == 0);
	}

	@Test
	public void deveRecuperaZeroPontosPorUsuarioInexistenteDoArquivoXML() {
		assertEquals(0, armazenamento.recuperaPontosDoUsuarioPorTipo("José", TipoDePonto.MOEDA));
	}

	@Test
	public void deveRecuperaZeroPontosPorUsuarioETipoDePontoInexistenteDoArquivoXML() {
		assertEquals(0, armazenamento.recuperaPontosDoUsuarioPorTipo("José", TipoDePonto.ESTRELA));
	}

	@Test
	public void deveRecuperaPontosPorUsuarioDoArquivoXML() {
		assertEquals(15, armazenamento.recuperaPontosDoUsuarioPorTipo("Josue", TipoDePonto.MOEDA));
	}

	@SuppressWarnings("unchecked")
	private Map<String, Map<TipoDePonto, Integer>> leArquivo() throws FileNotFoundException {
		FileReader fileReader = new FileReader("file.xml");
		Map<String, Map<TipoDePonto, Integer>> map = (Map<String, Map<TipoDePonto, Integer>>) stream
				.fromXML(fileReader);
		return map;
	}

	private void limpaArquivo() throws FileNotFoundException {
		PrintWriter printWriter = new PrintWriter(new File("file.xml"));
		printWriter.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		printWriter.flush();
		printWriter.close();
	}
}
