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

	private static MecanicaDoJogo escolheMecanica(Scanner in) {
		System.out.println("\n");
		System.out.println("## Escolha o estilo de jogo:");
		System.out.println("1) Número fixo de palavras (Você irá adivinhar 10 palavras podendo tentar 3 vezes)");
		System.out.println("2) Número de erros (Você irá adivinhar até errar 5 vezes)");
		System.out.println("3) Morte súbita (Caso tenha um erro o jogo acaba)");
		int escolha = in.nextInt();
		if (escolha >= 1 || escolha <= 3) {
			return FabricaMecanicaDoJogo.getInstancia().getMecanicaDoJogo(escolha);
		} else {
			System.out.println("faz sua escolha:");
			escolheMecanica(in);
		}
		return null;
	}

	private static void inicia() {
		System.out.println("#########################");
		System.out.println("## Jogo de Adivinhação ##");
		System.out.println("#########################");
	}

	private static void mostraPalavraEmbaralhada(MecanicaDoJogo mecanica) {
		String palavraEmbaralhada = mecanica.recuperaPalavraEmbaralhada();
		System.out.println("\n");
		System.out.println("## Tente adivinhar qual é a palavra: (" + palavraEmbaralhada + ")");
	}

	private static void responde(Scanner in, MecanicaDoJogo mecanica) {
		String resposta = in.nextLine();
		if (mecanica.adivinha(resposta)) {
			System.out.println("Você acertou!");
		} else if (mecanica.podeTentarNovamente()) {
			System.out.println("mais uma tentativa:");
			responde(in, mecanica);
		}
	}

	private static void termina(Scanner in, MecanicaDoJogo mecanica) {
		mecanica.pontuacao();
		in.close();
	}

}
