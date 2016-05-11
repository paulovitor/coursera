import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		inicia();
		MecanicaDoJogo mecanica = escolheMecanica(in);
		while (!mecanica.terminou()) {
			mostraPalavraEmbaralhada(mecanica);
			responde(in, mecanica);
		}
		termina(in, mecanica);
	}

	private static void inicia() {
		System.out.println("#########################");
		System.out.println("## Jogo de Adivinhação ##");
		System.out.println("#########################");
	}

	private static MecanicaDoJogo escolheMecanica(Scanner in) {
		System.out.println("\n");
		System.out.println("## Escolha o estilo de jogo:");
		System.out.println("1) Número fixo de palavras (Você irá adivinhar 10 palavras com 2 tentativas extra)");
		System.out.println("2) Número de erros (Você irá adivinhar 20 palavras podendo errar 4 vezes com 1 tentativa extra)");
		System.out.println("3) Morte súbita (Caso tenha um erro o jogo acaba)");

		return FabricaMecanicaDoJogo.getMecanicaDoJogo(getOpcao(in));
	}

	private static int getOpcao(Scanner in) {
		int opcao;
		try {
			opcao = Integer.valueOf(validaValorDigitado(in));
			if (!(opcao >= 1 && opcao <= 3)) {
				System.out.println("informe um valor valido:");
				return getOpcao(in);
			}
		} catch (NumberFormatException exception) {
			System.out.println("informe um valor valido:");
			return getOpcao(in);
		}
		return opcao;
	}

	private static String validaValorDigitado(Scanner in) {
		String digitado = in.nextLine();
		if (digitado == null || digitado.equals("")) {
			System.out.println("informe um valor valido:");
			return validaValorDigitado(in);
		}
		return digitado;
	}

	private static void mostraPalavraEmbaralhada(MecanicaDoJogo mecanica) {
		System.out.println("\n");
		System.out.println("## Tente adivinhar qual é a palavra: (" + mecanica.recuperaPalavraEmbaralhada() + ")");
	}

	private static void responde(Scanner in, MecanicaDoJogo mecanica) {
		String resposta = validaValorDigitado(in);
		if (mecanica.adivinha(resposta)) {
			System.out.println("Você acertou!");
		} else if (mecanica.podeTentarNovamente()) {
			System.out.println("mais uma tentativa:");
			responde(in, mecanica);
		}
	}

	private static void termina(Scanner in, MecanicaDoJogo mecanica) {
		System.out.println("\n");
		System.out.println("## Pontuação: " + mecanica.pontuacao());
		System.out.println("\n");
		System.out.println("#################");
		System.out.println("## Fim de jogo ##");
		System.out.println("#################");
		in.close();
	}

}
