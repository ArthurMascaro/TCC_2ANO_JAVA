package bean;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class Treina {
	
	private Treinador treinador;
	private Pokemon pokemon;
	private Timestamp data_hora;
	
	public Treina(Treinador treinador, Pokemon pokemon, Timestamp data_hora) {
		this.treinador = treinador;
		this.pokemon = pokemon;
		this.data_hora = data_hora;
	}
	
	public Treina() {
	}

	public Treina(Treinador treinador, Pokemon pokemon) {
		this.treinador = treinador;
		this.pokemon = pokemon;
	}

	public Treinador getTreinador() {
		return treinador;
	}

	public void setTreinador(Treinador treinador) {
		this.treinador = treinador;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

	public Timestamp getData_hora() {
		return data_hora;
	}

	public void setData_hora(Timestamp data_hora) {
		this.data_hora = data_hora;
	}
	
	public String formatar_data_string() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dataS = formatter.format(this.data_hora);
		return dataS;
	}
	
	
	// https://www.guj.com.br/t/como-passar-a-data-no-formato-datetime/225809/4 (link do formatador)
}
