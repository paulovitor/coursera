import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FabricaEmbaralhadores {

	private static FabricaEmbaralhadores instancia;
	
	private Random random = new Random();
	private List<Class<? extends Embaralhador>> embaralhadores;

	private FabricaEmbaralhadores() {
		embaralhadores = Arrays.asList(InverteString.class, PermutaRandomicamente.class, TrocaPorPares.class);
	}

	public static FabricaEmbaralhadores getInstancia() {
		if (instancia == null)
			instancia = new FabricaEmbaralhadores();
		return instancia;
	}

	public Embaralhador getEmbaralhador() {
		Class<? extends Embaralhador> embaralhador = embaralhadores.get(random.nextInt(embaralhadores.size() - 1));
		try {
			return embaralhador.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException("Erro ao criar instância de Embaralhador!");
		}
	}
}
