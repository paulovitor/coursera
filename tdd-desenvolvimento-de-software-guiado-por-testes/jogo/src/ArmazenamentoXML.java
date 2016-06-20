import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ArmazenamentoXML implements Armazenamento {

	private XStream stream = new XStream(new DomDriver());

	private Map<String, Map<TipoDePonto, Integer>> pontosPorUsuario = new HashMap<>();

	@Override
	public void registraPontos(String usuario, int pontos, TipoDePonto tipoDePonto) {
		atualizaPontos(usuario, pontos, tipoDePonto);
		gravaEmArquivo();
	}

	@Override
	public Map<TipoDePonto, Integer> recuperaPontosPorUsuario(String usuario) {
		return pontosPorUsuario.get(usuario);
	}

	@Override
	public Set<String> recuperaUsuarios() {
		return pontosPorUsuario.keySet();
	}

	@Override
	public int recuperaPontosDoUsuarioPorTipo(String usuario, TipoDePonto tipoDePonto) {
		if (pontosPorUsuario.containsKey(usuario)) {
			Map<TipoDePonto, Integer> map = pontosPorUsuario.get(usuario);
			if (map.containsKey(tipoDePonto))
				return map.get(tipoDePonto);
		}
		return 0;
	}

	private void atualizaPontos(String usuario, int pontos, TipoDePonto tipoDePonto) {
		if (pontosPorUsuario.containsKey(usuario)) {
			if (pontosPorUsuario.get(usuario).containsKey(tipoDePonto))
				pontos += pontosPorUsuario.get(usuario).get(tipoDePonto);
			pontosPorUsuario.get(usuario).put(tipoDePonto, pontos);
		} else {
			Map<TipoDePonto, Integer> map = new HashMap<>();
			map.put(tipoDePonto, pontos);
			pontosPorUsuario.put(usuario, map);
		}
	}

	private void gravaEmArquivo() {
		try {
			PrintWriter printWriter = new PrintWriter(new File("file.xml"));
			printWriter.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			printWriter.println(stream.toXML(pontosPorUsuario));
			printWriter.flush();
			printWriter.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Erro ao gravar arquivo!");
		}
	}
}
