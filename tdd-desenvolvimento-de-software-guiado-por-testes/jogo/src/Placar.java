import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Placar {

	private Armazenamento armazenamento;

	public Placar(Armazenamento armazenamento) {
		this.armazenamento = armazenamento;
	}

	public void registraPontos(String usuario, int pontos, TipoDePonto tipoDePonto) {
		armazenamento.registraPontos(usuario, pontos, tipoDePonto);
	}

	public Map<TipoDePonto, Integer> recuperaPontosPorUsuario(String usuario) {
		return armazenamento.recuperaPontosPorUsuario(usuario);
	}

	public SortedMap<Integer, String> recuperaRanking(TipoDePonto tipoDePonto) {
		SortedMap<Integer, String> ranking = new TreeMap<>(Collections.reverseOrder());
		Set<String> usuarios = armazenamento.recuperaUsuarios();
		usuarios.forEach(usuario -> {
			int pontos = armazenamento.recuperaPontosDoUsuarioPorTipo(usuario, tipoDePonto);
			if (pontos != 0)
				ranking.put(pontos, usuario);
		});
		return ranking;
	}
}
