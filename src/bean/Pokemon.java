package bean;

public class Pokemon {
	private int id;
	private int numeroPokedex;
	private String nome;
	private String elemento;
	private int geracao;
	private int experiencia;
	private double situacao;
	private int hp;
	private Treinador treinador;
	private Treinador treinadorCapturador;
	
	public Pokemon(int numeroPokedex, String nome, String elemento, int geracao, int experiencia, double situacao,
			int hp, Treinador treinador, Treinador treinadorCapturador) {
		this.numeroPokedex = numeroPokedex;
		this.nome = nome;
		this.elemento = elemento;
		this.geracao = geracao;
		this.experiencia = experiencia;
		this.situacao = situacao;
		this.hp = hp;
		this.treinador = treinador;
		this.treinadorCapturador = treinadorCapturador;
	}

	public Pokemon(int id, int numeroPokedex, String nome, String elemento, int geracao, int experiencia,
			double situacao, int hp, Treinador treinador, Treinador treinadorCapturador) {
		this.id = id;
		this.numeroPokedex = numeroPokedex;
		this.nome = nome;
		this.elemento = elemento;
		this.geracao = geracao;
		this.experiencia = experiencia;
		this.situacao = situacao;
		this.hp = hp;
		this.treinador = treinador;
		this.treinadorCapturador = treinadorCapturador;
	}

	public Pokemon(int id, int numeroPokedex) {
		this.id = id;
		this.numeroPokedex = numeroPokedex;
	}

	public Pokemon(String nome, String elemento, int geracao, int experiencia, double situacao, int hp,
			Treinador treinador) {
		this.nome = nome;
		this.elemento = elemento;
		this.geracao = geracao;
		this.experiencia = experiencia;
		this.situacao = situacao;
		this.hp = hp;
		this.treinador = treinador;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroPokedex() {
		return numeroPokedex;
	}

	public void setNumeroPokedex(int numeroPokedex) {
		this.numeroPokedex = numeroPokedex;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	public int getGeracao() {
		return geracao;
	}

	public void setGeracao(int geracao) {
		this.geracao = geracao;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public double getSituacao() {
		return situacao;
	}

	public void setSituacao(double situacao) {
		this.situacao = situacao;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public Treinador getTreinador() {
		return treinador;
	}

	public void setTreinador(Treinador treinador) {
		this.treinador = treinador;
	}

	public Treinador getTreinadorCapturador() {
		return treinadorCapturador;
	}

	public void setTreinadorCapturador(Treinador treinadorCapturador) {
		this.treinadorCapturador = treinadorCapturador;
	}
	
	
}
