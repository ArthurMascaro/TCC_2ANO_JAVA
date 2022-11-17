package bean;

public class Tipo {
	
	private String nome;
	private String elemento;
	private int geracao;
	
	public Tipo(String nome, String elemento, int geracao) {
		this.nome = nome;
		this.elemento = elemento;
		this.geracao = geracao;
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
}