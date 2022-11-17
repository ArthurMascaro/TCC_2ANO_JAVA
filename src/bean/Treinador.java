package bean;

public class Treinador {

	private int id;
	private String nome;
	private int registroPokedex;
	private String sexo;
	
	public Treinador(String nome, int registroPokedex, String sexo) {
		this.nome = nome;
		this.registroPokedex = registroPokedex;
		this.sexo = sexo;
	}

	public Treinador(int id, String nome, int registroPokedex, String sexo) {
		this.id = id;
		this.nome = nome;
		this.registroPokedex = registroPokedex;
		this.sexo = sexo;
	}

	public Treinador(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getRegistroPokedex() {
		return registroPokedex;
	}

	public void setRegistroPokedex(int registroPokedex) {
		this.registroPokedex = registroPokedex;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
}
