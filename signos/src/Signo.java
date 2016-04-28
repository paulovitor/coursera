import static java.time.Month.APRIL;
import static java.time.Month.AUGUST;
import static java.time.Month.DECEMBER;
import static java.time.Month.FEBRUARY;
import static java.time.Month.JANUARY;
import static java.time.Month.JULY;
import static java.time.Month.JUNE;
import static java.time.Month.MARCH;
import static java.time.Month.MAY;
import static java.time.Month.NOVEMBER;
import static java.time.Month.OCTOBER;
import static java.time.Month.SEPTEMBER;

import java.time.Month;

public enum Signo {

	ARIES("Áries: 21 de março - 20 de abril"),
	TOURO("Touro: 21 de abril - 20 de maio"),
	GEMEOS("Gêmeos: 21 de maio - 20 de junho"),
	CANCER("Câncer: 21 de junho - 21 de julho"),
	LEAO("Leão: 22 de julho - 22 de agosto"),
	VIRGEM("Virgem: 23 de agosto - 22 de setembro"),
	LIBRA("Libra: 23 de setembro - 22 de outubro"),
	ESCORPIAO("Escorpião: 23 de outubro - 21 de novembro"),
	SAGITARIO("Sagitário: 22 de novembro - 21 de dezembro"),
	CAPRICORNIO("Capricórnio: 22 de dezembro - 20 de janeiro"),
	AQUARIO("Aquário: 21 de Janeiro - 19 de fevereiro"),
	PEIXES("Peixes: 20 de fevereiro - 20 de março");

	private String descricao;

	Signo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Signo get(int dia, Month month) {
		if ((dia >= 21 && month == MARCH) || (dia <= 20 && month == APRIL))
			return ARIES;
		if ((dia >= 21 && month == APRIL) || (dia <= 20 && month == MAY))
			return TOURO;
		if ((dia >= 21 && month == MAY) || (dia <= 20 && month == JUNE))
			return GEMEOS;
		if ((dia >= 21 && month == JUNE) || (dia <= 21 && month == JULY))
			return CANCER;
		if ((dia >= 22 && month == JULY) || (dia <= 22 && month == AUGUST))
			return LEAO;
		if ((dia >= 23 && month == AUGUST) || (dia <= 22 && month == SEPTEMBER))
			return VIRGEM;
		if ((dia >= 23 && month == SEPTEMBER) || (dia <= 22 && month == OCTOBER))
			return LIBRA;
		if ((dia >= 23 && month == OCTOBER) || (dia <= 21 && month == NOVEMBER))
			return ESCORPIAO;
		if ((dia >= 22 && month == NOVEMBER) || (dia <= 21 && month == DECEMBER))
			return SAGITARIO;
		if ((dia >= 22 && month == DECEMBER) || (dia <= 20 && month == JANUARY))
			return CAPRICORNIO;
		if ((dia >= 21 && month == JANUARY) || (dia <= 19 && month == FEBRUARY))
			return AQUARIO;
		return PEIXES;
	}
}
