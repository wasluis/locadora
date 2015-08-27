package br.com.framework.vo;

import java.util.Date;

import br.com.framework.model.Contato;

public class MensagemVO {
	
	private String conteudo;
	
	private Date dataEnvioInicial;
	
	private Date dataEnvioFinal;
	
	private Contato contato;

	public MensagemVO(){
		super();
		contato = new Contato();
	}
	
	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Date getDataEnvioInicial() {
		return dataEnvioInicial;
	}

	public void setDataEnvioInicial(Date dataEnvioInicial) {
		this.dataEnvioInicial = dataEnvioInicial;
	}

	public Date getDataEnvioFinal() {
		return dataEnvioFinal;
	}

	public void setDataEnvioFinal(Date dataEnvioFinal) {
		this.dataEnvioFinal = dataEnvioFinal;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	
}
