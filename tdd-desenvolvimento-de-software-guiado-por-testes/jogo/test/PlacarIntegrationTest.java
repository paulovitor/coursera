import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlacarIntegrationTest {

	private Armazenamento armazenamento;
	private Placar placar;

	@Before
	public void inicializa() {
		armazenamento = new ArmazenamentoXML();
		placar = new Placar(armazenamento);
	}

	@After
	public void finaliza() {
		armazenamento = null;
	}

	@Test
	public void deveRegistrarPontosDoTipoDePontoEstrelaParaUsuario() {
		placar.registraPontos("Paulo", 10, TipoDePonto.ESTRELA);

		Map<TipoDePonto, Integer> pontos = placar.recuperaPontosPorUsuario("Paulo");
		assertTrue(pontos.size() == 1);
		assertEquals(10, pontos.get(TipoDePonto.ESTRELA), 0.00001);
	}

	@Test
	public void deveRegistrarPontosDeMaisDeUmTipoDePontoParaUsuario() {
		placar.registraPontos("Paulo", 20, TipoDePonto.MOEDA);
		placar.registraPontos("Paulo", 25, TipoDePonto.ESTRELA);

		Map<TipoDePonto, Integer> pontos = placar.recuperaPontosPorUsuario("Paulo");
		assertTrue(pontos.size() == 2);
		assertEquals(20, pontos.get(TipoDePonto.MOEDA), 0.00001);
		assertEquals(25, pontos.get(TipoDePonto.ESTRELA), 0.00001);
	}

	@Test
	public void naoDeveRecuperaUmTipoDePontoNaoRegistrado() {
		placar.registraPontos("Paulo", 20, TipoDePonto.MOEDA);
		placar.registraPontos("Paulo", 25, TipoDePonto.ESTRELA);

		Map<TipoDePonto, Integer> pontos = placar.recuperaPontosPorUsuario("Paulo");
		assertFalse(pontos.containsKey(TipoDePonto.ENERGIA));
	}

	@Test
	public void deveRecuperarRankingDeUmTipoDePonto() {
		placar.registraPontos("Josue", 15, TipoDePonto.MOEDA);
		placar.registraPontos("Moises", 10, TipoDePonto.MOEDA);
		placar.registraPontos("Maria", 20, TipoDePonto.ENERGIA);

		SortedMap<Integer, String> ranking = placar.recuperaRanking(TipoDePonto.MOEDA);
		assertTrue(ranking.size() == 2);
	}

	@Test
	public void deveRecuperarRankingDeUmTipoDePontoOrdenadoPeloUsuarioComMaiorPontuacao() {
		placar.registraPontos("Josue", 15, TipoDePonto.MOEDA);
		placar.registraPontos("José", 20, TipoDePonto.MOEDA);
		placar.registraPontos("Moises", 10, TipoDePonto.MOEDA);
		placar.registraPontos("Maria", 20, TipoDePonto.ENERGIA);

		SortedMap<Integer, String> ranking = placar.recuperaRanking(TipoDePonto.MOEDA);
		Iterator<Entry<Integer, String>> iterator = ranking.entrySet().iterator();

		assertKeyValue(iterator.next(), 20, "José");
		assertKeyValue(iterator.next(), 15, "Josue");
		assertKeyValue(iterator.next(), 10, "Moises");
	}

	private void assertKeyValue(Entry<Integer, String> entry, int valor, String usuario) {
		assertEquals(valor, entry.getKey(), 0.00001);
		assertEquals(usuario, entry.getValue());
	}
}
