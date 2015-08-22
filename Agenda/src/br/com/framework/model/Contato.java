package br.com.framework.model;

public class Contato {

	private Long id;
	
	private String nome;
	
	private String telefone;
	
	private Character sexo;
	
	private String tipoTelefone;

	

	public Contato(Long id, String nome, String telefone, Character sexo,
			String tipoTelefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.sexo = sexo;
		this.tipoTelefone = tipoTelefone;
	}

	public Contato() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
	
	
	
	
	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public String getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(String tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
