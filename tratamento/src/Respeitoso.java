
public class Respeitoso implements FormatadorNome {

	public static final String MASCULINO = "masculino";
	public static final String FEMININO = "feminino";

	private String sexo;

	public Respeitoso(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public String formatarNome(String nome, String sobrenome) {
		return (sexo == MASCULINO ? "Sr. " : "Sra. ") + sobrenome;
	}

}
