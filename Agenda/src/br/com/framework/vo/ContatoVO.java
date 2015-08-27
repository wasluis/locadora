package br.com.framework.vo;

import java.util.Date;

public class ContatoVO {
	
	private String nome;
	
	private String telefone;
	
	private Character sexo;
	
	private String tipoTelefone;

	private Date dataNascimentoInicial;
	
	private Date dataNascimentoFinal;
	
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

	public Date getDataNascimentoInicial() {
		return dataNascimentoInicial;
	}

	public void setDataNascimentoInicial(Date dataNascimentoInicial) {
		this.dataNascimentoInicial = dataNascimentoInicial;
	}

	public Date getDataNascimentoFinal() {
		return dataNascimentoFinal;
	}

	public void setDataNascimentoFinal(Date dataNascimentoFinal) {
		this.dataNascimentoFinal = dataNascimentoFinal;
	}
	
	
}
