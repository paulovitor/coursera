public class Relogio {

	public static long tempoFixo;

	public static long agora() {
		return tempoFixo == 0 ? System.currentTimeMillis() : tempoFixo;
	}
}
