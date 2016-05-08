import java.util.Arrays;
import java.util.List;

public class FabricaMecanicaDoJogo {

	private static FabricaMecanicaDoJogo intancia;

	private List<Class<? extends MecanicaDoJogo>> mecanicas;

	private FabricaMecanicaDoJogo() {
		mecanicas = Arrays.asList(NumeroFixoDePalavras.class, NumeroDeErros.class, MorteSubita.class);
	}

	public static FabricaMecanicaDoJogo getInstancia() {
		if (intancia == null)
			intancia = new FabricaMecanicaDoJogo();
		return intancia;
	}

	public MecanicaDoJogo getMecanicaDoJogo(int escolha) {
		Class<? extends MecanicaDoJogo> mecanica = mecanicas.get(escolha - 1);
		try {
			return mecanica.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException("Erro ao criar instância de MecanicaDoJogo!");
		}
	}

}
