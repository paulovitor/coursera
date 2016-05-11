import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FabricaEmbaralhadores {

	private static Random random = new Random();
	private static List<Class<? extends Embaralhador>> embaralhadores = Arrays.asList(InverteString.class,
			PermutaRandomicamente.class, TrocaPorPares.class);

	private FabricaEmbaralhadores() {
	}

	public static Embaralhador getEmbaralhador() {
		Class<? extends Embaralhador> embaralhador = embaralhadores.get(random.nextInt(embaralhadores.size() - 1));
		try {
			return embaralhador.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException("Erro ao criar instância de Embaralhador!");
		}
	}
}
