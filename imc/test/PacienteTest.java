import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PacienteTest {

	@Test
	public void deveCalcularIMCDePacienteComBaixoPesoMuitoGrave() {
		Paciente paciente = new Paciente(40, 1.80);

		double imc = paciente.calcularIMC();

		assertTrue(Double.compare(imc, 16) < 0);
		assertEquals(12.34, imc, 0.01);
		assertEquals(Paciente.BAIXO_PESO_MUITO_GRAVE, paciente.diagnostico());
	}

	@Test
	public void deveCalcularIMCDePacienteComBaixoPesoGrave() {
		Paciente paciente = new Paciente(55, 1.80);

		double imc = paciente.calcularIMC();

		assertTrue(Double.compare(imc, 16) > 0);
		assertTrue(Double.compare(imc, 16.99) < 0);
		assertEquals(16.97, imc, 0.01);
		assertEquals(Paciente.BAIXO_PESO_GRAVE, paciente.diagnostico());
	}

	@Test
	public void deveCalcularIMCDePacienteComBaixoPeso() {
		Paciente paciente = new Paciente(59, 1.80);

		double imc = paciente.calcularIMC();

		assertTrue(Double.compare(imc, 16.99) > 0);
		assertTrue(Double.compare(imc, 18.49) < 0);
		assertEquals(18.20, imc, 0.01);
		assertEquals(Paciente.BAIXO_PESO, paciente.diagnostico());
	}

	@Test
	public void deveCalcularIMCDePacienteComPesoNormal() {
		Paciente paciente = new Paciente(70, 1.80);

		double imc = paciente.calcularIMC();

		assertTrue(Double.compare(imc, 18.49) > 0);
		assertTrue(Double.compare(imc, 24.99) < 0);
		assertEquals(21.60, imc, 0.01);
		assertEquals(Paciente.PESO_NORMAL, paciente.diagnostico());
	}

	@Test
	public void deveCalcularIMCDePacienteComSobrepeso() {
		Paciente paciente = new Paciente(85, 1.80);

		double imc = paciente.calcularIMC();

		assertTrue(Double.compare(imc, 24.99) > 0);
		assertTrue(Double.compare(imc, 29.99) < 0);
		assertEquals(26.23, imc, 0.01);
		assertEquals(Paciente.SOBREPESO, paciente.diagnostico());
	}

	@Test
	public void deveCalcularIMCDePacienteComObesidadeDeGrauI() {
		Paciente paciente = new Paciente(100, 1.80);

		double imc = paciente.calcularIMC();

		assertTrue(Double.compare(imc, 29.99) > 0);
		assertTrue(Double.compare(imc, 34.99) < 0);
		assertEquals(30.86, imc, 0.01);
		assertEquals(Paciente.OBESIDADE_GRAU_I, paciente.diagnostico());
	}

	@Test
	public void deveCalcularIMCDePacienteComObesidadeDeGrauII() {
		Paciente paciente = new Paciente(115, 1.80);

		double imc = paciente.calcularIMC();

		assertTrue(Double.compare(imc, 34.99) > 0);
		assertTrue(Double.compare(imc, 39.99) < 0);
		assertEquals(35.49, imc, 0.01);
		assertEquals(Paciente.OBESIDADE_GRAU_II, paciente.diagnostico());
	}

	@Test
	public void deveCalcularIMCDePacienteComObesidadeDeGrauIII() {
		Paciente paciente = new Paciente(140, 1.80);

		double imc = paciente.calcularIMC();

		assertTrue(Double.compare(imc, 39.99) > 0);
		assertEquals(43.20, imc, 0.01);
		assertEquals(Paciente.OBESIDADE_GRAU_III, paciente.diagnostico());
	}

}
