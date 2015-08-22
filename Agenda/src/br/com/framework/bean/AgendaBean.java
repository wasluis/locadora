package br.com.framework.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.framework.dao.ContatoDAO;
import br.com.framework.model.Contato;


@ManagedBean
@SessionScoped
public class AgendaBean {

	private Contato contato = new Contato();
	
	private List<Contato> contatos;
	
	private ContatoDAO contatoDAO = new ContatoDAO();

	public String prepareInsert(){
		contato = new Contato();
		return "formContato.xhtml";
	}
	
	public String salvar(){
		try{
			contatoDAO.inserir(contato);
		}catch(Exception e){
			e.printStackTrace();
		}
		return pesquisar();
	}
	
	public String pesquisar(){
		try{
			contatos = contatoDAO.getLista();
		}catch(Exception e){
			e.printStackTrace();
		}
		return "listContato.xhtml";
	}
	
	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	
	
		
}
