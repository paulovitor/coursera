import java.util.Arrays;
import java.util.List;

public class FabricaMecanicaDoJogo {

	private static List<Class<? extends MecanicaDoJogo>> mecanicas = Arrays.asList(NumeroFixoDePalavras.class,
			NumeroDeErros.class, MorteSubita.class);

	private FabricaMecanicaDoJogo() {
	}

	public static MecanicaDoJogo getMecanicaDoJogo(int escolha) {
		Class<? extends MecanicaDoJogo> mecanica = mecanicas.get(escolha - 1);
		try {
			return mecanica.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException("Erro ao criar instância de MecanicaDoJogo!");
		}
	}

}
