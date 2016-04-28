
public class Principal {

	public static void main(String[] args) {
		mostraDiagnostico(new Paciente(60, 1.90));
		mostraDiagnostico(new Paciente(70, 1.80));
		mostraDiagnostico(new Paciente(90, 1.80));
	}

	private static void mostraDiagnostico(Paciente paciente) {
		System.out.println(paciente.diagnostico());
	}

}
