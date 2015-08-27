package br.com.framework.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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
	private ContatoVO contatoVO = new ContatoVO();

	private List<Contato> contatosSelecionados = new ArrayList<Contato>();
	
	private static final String LIST = "listContato.xhtml";
	
	public String prepareList(){
		contatoVO = new ContatoVO();
		return 	LIST;
	}
	
	public String prepareInsert(){
		contato = new Contato();
		return "formContato.xhtml";
	}
	
	public String salvar(){
		try{
			if(contato.getId() != null){
				getContatoDAO().update(contato);
			}
			else{
				getContatoDAO().insert(contato);
			}
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação realizada com sucesso", ""));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		contatosSelecionados = new ArrayList<Contato>();
		return pesquisar();
	}
	
	public String prepareEdit(){
		if(contatosSelecionados.size() == 0){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Necessário selecionar contatos", "" ));
			return null;
		}
		if(contatosSelecionados.size() > 1){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Somente um contato pode ser editado", ""));
			return null;
		}
		else{
			contato = contatosSelecionados.get(0);
			return "formContato.xhtml";
		}
	}
	
	public String remove(){
		if(contatosSelecionados.size() == 0){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Necessário selecionar contatos", "" ));
			return null;
		}
		else{
			for(Contato contato : contatosSelecionados){
				getContatoDAO().remove(contato);
			}
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação realizada com sucesso", ""));

		}
		return pesquisar();
	}
	
	public String pesquisar(){
		try{
			contatos = getContatoDAO().buscarContatos(contatoVO);
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

	public List<Contato> getContatosSelecionados() {
		return contatosSelecionados;
	}

	public void setContatosSelecionados(List<Contato> contatosSelecionados) {
		this.contatosSelecionados = contatosSelecionados;
	}


	
	
}
