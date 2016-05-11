import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProcessadorArquivo {

	public static Map<String, String> processar(String nomeArquivo) throws LeituraArquivoException {
		Map<String, String> mapa = new HashMap<>();
		File file = new File(nomeArquivo);
		Scanner scanner;
		try {
			scanner = new Scanner(file);
		} catch (IOException e) {
			throw new LeituraArquivoException("Erro ao abrir o arquivo " + e.getMessage());
		}

		if (file.length() == 0) {
			scanner.close();
			throw new LeituraArquivoException("Arquivo vazio");
		}
		while (scanner.hasNextLine()) {
			String linha = scanner.nextLine();
			String[] valores = linha.split("->");
			if (valores.length != 2) {
				scanner.close();
				throw new LeituraArquivoException("Formato de arquivo inválido");
			}
			mapa.put(valores[0], valores[1]);
		}
		scanner.close();
		return mapa;
	}
}
