import java.util.Map;
import java.util.Set;

public interface Armazenamento {

	void registraPontos(String usuario, int pontos, TipoDePonto tipoDePonto);

	Map<TipoDePonto, Integer> recuperaPontosPorUsuario(String usuario);

	Set<String> recuperaUsuarios();

	int recuperaPontosDoUsuarioPorTipo(String usuario, TipoDePonto tipoDePonto);
}
