import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class PessoaTest {

	private Pessoa pessoa;

	@Before
	public void setUp() {
		Relogio.tempoFixo = 1461793632649L;
	}

	@Test
	public void deveRecuperarIdadeDeUmaPessoaDoSignoAries() throws ParseException {
		pessoa = new Pessoa(LocalDate.of(1993, 4, 1));

		assertEquals(pessoa.getDataDeNascimento().toString(), 23, pessoa.getIdade());
		assertEquals(Signo.ARIES.getDescricao(), Signo.ARIES, pessoa.getSigno());
	}

	@Test
	public void deveRecuperarIdadeDeUmaPessoaDoSignoTouro() throws ParseException {
		pessoa = new Pessoa(LocalDate.of(1992, 4, 24));

		assertEquals(pessoa.getDataDeNascimento().toString(), 24, pessoa.getIdade());
		assertEquals(Signo.TOURO.getDescricao(), Signo.TOURO, pessoa.getSigno());
	}

	@Test
	public void deveRecuperarIdadeDeUmaPessoaDoSignoGemeos() throws ParseException {
		pessoa = new Pessoa(LocalDate.of(1990, 5, 30));

		assertEquals(pessoa.getDataDeNascimento().toString(), 26, pessoa.getIdade());
		assertEquals(Signo.GEMEOS.getDescricao(), Signo.GEMEOS, pessoa.getSigno());
	}

	@Test
	public void deveRecuperarIdadeDeUmaPessoaDoSignoCancer() throws ParseException {
		pessoa = new Pessoa(LocalDate.of(1982, 6, 28));

		assertEquals(pessoa.getDataDeNascimento().toString(), 34, pessoa.getIdade());
		assertEquals(Signo.CANCER.getDescricao(), Signo.CANCER, pessoa.getSigno());
	}

	@Test
	public void deveRecuperarIdadeDeUmaPessoaDoSignoLeao() throws ParseException {
		pessoa = new Pessoa(LocalDate.of(1975, 7, 29));

		assertEquals(pessoa.getDataDeNascimento().toString(), 41, pessoa.getIdade());
		assertEquals(Signo.LEAO.getDescricao(), Signo.LEAO, pessoa.getSigno());
	}

	@Test
	public void deveRecuperarIdadeDeUmaPessoaDoSignoVirgem() throws ParseException {
		pessoa = new Pessoa(LocalDate.of(1985, 9, 8));

		assertEquals(pessoa.getDataDeNascimento().toString(), 31, pessoa.getIdade());
		assertEquals(Signo.VIRGEM.getDescricao(), Signo.VIRGEM, pessoa.getSigno());
	}

	@Test
	public void deveRecuperarIdadeDeUmaPessoaDoSignoLibra() throws ParseException {
		pessoa = new Pessoa(LocalDate.of(1990, 10, 22));

		assertEquals(pessoa.getDataDeNascimento().toString(), 26, pessoa.getIdade());
		assertEquals(Signo.LIBRA.getDescricao(), Signo.LIBRA, pessoa.getSigno());
	}

	@Test
	public void deveRecuperarIdadeDeUmaPessoaDoSignoEscorpiao() throws ParseException {
		pessoa = new Pessoa(LocalDate.of(1978, 10, 25));

		assertEquals(pessoa.getDataDeNascimento().toString(), 38, pessoa.getIdade());
		assertEquals(Signo.ESCORPIAO.getDescricao(), Signo.ESCORPIAO, pessoa.getSigno());
	}

	@Test
	public void deveRecuperarIdadeDeUmaPessoaDoSignoSagitario() throws ParseException {
		pessoa = new Pessoa(LocalDate.of(1986, 12, 7));

		assertEquals(pessoa.getDataDeNascimento().toString(), 30, pessoa.getIdade());
		assertEquals(Signo.SAGITARIO.getDescricao(), Signo.SAGITARIO, pessoa.getSigno());
	}

	@Test
	public void deveRecuperarIdadeDeUmaPessoaDoSignoCapricornio() throws ParseException {
		pessoa = new Pessoa(LocalDate.of(1957, 1, 20));

		assertEquals(pessoa.getDataDeNascimento().toString(), 59, pessoa.getIdade());
		assertEquals(Signo.CAPRICORNIO.getDescricao(), Signo.CAPRICORNIO, pessoa.getSigno());
	}

	@Test
	public void deveRecuperarIdadeDeUmaPessoaDoSignoAquario() throws ParseException {
		pessoa = new Pessoa(LocalDate.of(1980, 2, 1));

		assertEquals(pessoa.getDataDeNascimento().toString(), 36, pessoa.getIdade());
		assertEquals(Signo.AQUARIO.getDescricao(), Signo.AQUARIO, pessoa.getSigno());
	}

	@Test
	public void deveRecuperarIdadeDeUmaPessoaDoSignoPeixes() throws ParseException {
		pessoa = new Pessoa(LocalDate.of(1981, 3, 14));

		assertEquals(pessoa.getDataDeNascimento().toString(), 35, pessoa.getIdade());
		assertEquals(Signo.PEIXES.getDescricao(), Signo.PEIXES, pessoa.getSigno());
	}

}
