package br.com.framework.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "chamada")
@SequenceGenerator(name = "SEQ_CHAMADA", sequenceName = "sq_chamada_id", allocationSize = 1)
public class Chamada {
	@Id
	@GeneratedValue(generator = "SEQ_CHAMADA", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column
	private String duracao;
	
	@Column
	private int contatoId;
	
	private Contato contato;

	public Chamada(String duracao, int contatoId) {
		super();
		this.duracao = duracao;
		this.contatoId = contatoId;
	}
	
	public Chamada(){
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public int getContatoId() {
		return contatoId;
	}

	public void setContatoId(int contatoId) {
		this.contatoId = contatoId;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	
}
