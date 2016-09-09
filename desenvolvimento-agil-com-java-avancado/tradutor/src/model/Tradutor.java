package model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Tradutor {

	private String palavra;

	public Tradutor(String palavra) {
		this.palavra = palavra;
	}

	public String traduz() {
		Properties properties = new Properties();
		InputStream stream = Tradutor.class.getResourceAsStream("palavras.properties");
		try {
			properties.load(stream);
		} catch (IOException e) {
			throw new RuntimeException("Erro ao recuperar palavra!");
		}
		return properties.containsKey(palavra) ? properties.getProperty(palavra) : palavra;
	}
}
