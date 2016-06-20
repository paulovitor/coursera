import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MockArmazenamento implements Armazenamento {

	private Map<String, Map<TipoDePonto, Integer>> pontosPorUsuarioEsperados = new HashMap<>();

	private Set<String> usuariosEsperados = new HashSet<String>();
	private Set<TipoDePonto> tiposEsperados = new HashSet<TipoDePonto>();
	private List<Integer> pontosEsperados = new ArrayList<Integer>();

	private int index;

	@Override
	public void registraPontos(String usuario, int pontos, TipoDePonto tipoDePonto) {
		pontosPorUsuarioEsperados.put(usuario, Collections.singletonMap(tipoDePonto, pontos));

		usuariosEsperados.add(usuario);
		tiposEsperados.add(tipoDePonto);
		pontosEsperados.add(pontos);
	}

	@Override
	public Map<TipoDePonto, Integer> recuperaPontosPorUsuario(String usuario) {
		return pontosPorUsuarioEsperados.get(usuario);
	}

	@Override
	public Set<String> recuperaUsuarios() {
		return usuariosEsperados;
	}

	@Override
	public int recuperaPontosDoUsuarioPorTipo(String usuario, TipoDePonto tipoDePonto) {
		return pontosEsperados.get(index < pontosEsperados.size() ? index++ : index);
	}

	public void deveRecuperarPontosPorUsuarios(Map<String, Map<TipoDePonto, Integer>> pontosPorUsuario) {
		pontosPorUsuarioEsperados = pontosPorUsuario;
	}

	public void deveRecuperarUsuarios(Set<String> usuarios) {
		usuariosEsperados = usuarios;
	}

	public void deveRecuperarTipos(Set<TipoDePonto> tipos) {
		tiposEsperados = tipos;
	}

	public void deveRecuperarPontos(List<Integer> pontos) {
		pontosEsperados = pontos;
	}

	public void verificaPontosRegistrados(String usuario, int pontos, TipoDePonto tipoDePonto) {
		assertTrue(usuariosEsperados.contains(usuario));
		assertTrue(pontosPorUsuarioEsperados.containsKey(usuario));

		assertTrue(tiposEsperados.contains(tipoDePonto));
		assertTrue(pontosPorUsuarioEsperados.get(usuario).containsKey(tipoDePonto));

		assertTrue(pontosEsperados.contains(pontos));
		assertEquals(pontosPorUsuarioEsperados.get(usuario).get(tipoDePonto), pontos, 0.00001);
	}
}
