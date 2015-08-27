package br.com.framework.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.framework.dao.ContatoDAOImpl;
import br.com.framework.model.Contato;
import br.com.framework.vo.ContatoVO;


@ManagedBean(name="agendaBean")
@SessionScoped
public class AgendaBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3250033079195721281L;

	private Contato contato = new Contato();
	
	private List<Contato> contatos;
	private ContatoVO contatoVO;
	
	public String prepareInsert(){
		contato = new Contato();
		return "formContato.xhtml";
	}
	
	public String salvar(){
		try{
			getContatoDAO().insert(contato);
		}catch(Exception e){
			e.printStackTrace();
		}
		return pesquisar();
	}
	
	public String pesquisar(){
		try{
			contatos = getContatoDAO().findAll();
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
	
	public ContatoDAOImpl getContatoDAO(){
		ContatoDAOImpl contatoDAO = null;
		try {
			contatoDAO = (ContatoDAOImpl)new InitialContext().lookup("java:module/ContatoDAOImpl");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contatoDAO;
	}

	public ContatoVO getContatoVO() {
		return contatoVO;
	}

	public void setContatoVO(ContatoVO contatoVO) {
		this.contatoVO = contatoVO;
	}


	
	
}
