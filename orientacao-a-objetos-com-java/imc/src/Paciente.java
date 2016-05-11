
public class Paciente {

	public static final String BAIXO_PESO_MUITO_GRAVE = "Baixo peso muito grave = IMC abaixo de 16 kg/m²";
	public static final String BAIXO_PESO_GRAVE = "Baixo peso grave = IMC entre 16 e 16,99 kg/m²";
	public static final String BAIXO_PESO = "Baixo peso = IMC entre 17 e 18,49 kg/m²";
	public static final String PESO_NORMAL = "Peso normal = IMC entre 18,50 e 24,99 kg/m²";
	public static final String SOBREPESO = "Sobrepeso = IMC entre 25 e 29,99 kg/m²";
	public static final String OBESIDADE_GRAU_I = "Obesidade grau I = IMC entre 30 e 34,99 kg/m²";
	public static final String OBESIDADE_GRAU_II = "Obesidade grau II = IMC entre 35 e 39,99 kg/m²";
	public static final String OBESIDADE_GRAU_III = "Obesidade grau III (obesidade mórbida)";
	
	private double peso;
	private double altura;

	public Paciente(double peso, double altura) {
		this.peso = peso;
		this.altura = altura;
	}

	public String diagnostico() {
		double imc = calcularIMC();

		if (Double.compare(imc, 16) < 0) {
			return BAIXO_PESO_MUITO_GRAVE;
		} else if (Double.compare(imc, 16.99) < 0) {
			return BAIXO_PESO_GRAVE;
		} else if (Double.compare(imc, 18.49) < 0) {
			return BAIXO_PESO;
		} else if (Double.compare(imc, 24.99) < 0) {
			return PESO_NORMAL;
		} else if (Double.compare(imc, 29.99) < 0) {
			return SOBREPESO;
		} else if (Double.compare(imc, 34.99) < 0) {
			return OBESIDADE_GRAU_I;
		} else if (Double.compare(imc, 39.99) < 0) {
			return OBESIDADE_GRAU_II;
		}
		return OBESIDADE_GRAU_III;
	}

	public double calcularIMC() {
		return peso / (altura * altura);
	}
}
