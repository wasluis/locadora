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
	private Long id;
	
	@Column
	private String duracao;
	
	@Column
	private Long contatoId;

	public Chamada(String duracao, Long contatoId) {
		super();
		this.duracao = duracao;
		this.contatoId = contatoId;
	}
	
	public Chamada(){
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public Long getContatoId() {
		return contatoId;
	}

	public void setContatoId(Long contatoId) {
		this.contatoId = contatoId;
	}
}
