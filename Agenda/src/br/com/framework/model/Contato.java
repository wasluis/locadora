package br.com.framework.model;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name = "contato")
@SequenceGenerator(name = "SEQ_CONTATO", sequenceName = "sq_contato_id", allocationSize = 1)
public class Contato {
	
	@Id
	@GeneratedValue(generator = "SEQ_CONTATO", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String telefone;
	
	@Column
	private Character sexo;
	
	@Column(name = "tipo_telefone")
	private String tipoTelefone;

	@Column(name = "data_nascimento")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataNascimento;

	@OneToMany(fetch=FetchType.LAZY, orphanRemoval = true, cascade=CascadeType.REMOVE, mappedBy = "contato")
	private List<Mensagem> mensagens;
	
//	@OneToMany(fetch=FetchType.LAZY, orphanRemoval = true, cascade=CascadeType.REMOVE)
	@Transient
	private List<Chamada> chamadas;
	
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	public List<Chamada> getChamadas() {
		return chamadas;
	}

	public void setChamadas(List<Chamada> chamadas) {
		this.chamadas = chamadas;
	}
	
	
	
}
