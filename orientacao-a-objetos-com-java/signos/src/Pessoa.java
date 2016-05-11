import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.TimeZone;

public class Pessoa {

	private LocalDate dataDeNascimento;

	public Pessoa(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public long getIdade() {
		LocalDate hoje = LocalDateTime
				.ofInstant(Instant.ofEpochMilli(Relogio.agora()), TimeZone.getDefault().toZoneId()).toLocalDate();
		return hoje.getYear() - dataDeNascimento.getYear();
	}

	public Signo getSigno() {
		return Signo.get(dataDeNascimento.getDayOfMonth(), dataDeNascimento.getMonth());
	}

}
