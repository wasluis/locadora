package br.com.framework.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "mensagem")
@SequenceGenerator(name = "SEQ_MENSAGEM", sequenceName = "sq_mensagem_id", allocationSize = 1)
public class Mensagem {
	
	@Id
	@GeneratedValue(generator = "SEQ_MENSAGEM", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	private String conteudo;
	
	@Column (name = "data_envio")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEnvio;
	
	@ManyToOne (optional = false)
	@JoinColumn(name = "contato_id", referencedColumnName = "id")
	private Contato contato;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Date getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	
	
}
