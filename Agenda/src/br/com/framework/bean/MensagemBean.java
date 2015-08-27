package br.com.framework.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.framework.dao.ContatoDAOImpl;
import br.com.framework.dao.MensagemDAOImpl;
import br.com.framework.model.Contato;
import br.com.framework.model.Mensagem;
import br.com.framework.vo.MensagemVO;


@ManagedBean(name="mensagemBean")
@SessionScoped
public class MensagemBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3250033079195721281L;
	
	private List<Mensagem> mensagens;
	private MensagemVO mensagemVO = new MensagemVO();
	
	
	public String pesquisar(){
		try{
			mensagens = getMensagemDAO().buscarMensagens(mensagemVO);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "listMensagem.xhtml";
	}

	
	
	public MensagemDAOImpl getMensagemDAO(){
		MensagemDAOImpl mensagemDAO = null;
		try {
			mensagemDAO = (MensagemDAOImpl)new InitialContext().lookup("java:module/MensagemDAOImpl");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mensagemDAO;
	}

	public List<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	public MensagemVO getMensagemVO() {
		return mensagemVO;
	}

	public void setMensagemVO(MensagemVO mensagemVO) {
		this.mensagemVO = mensagemVO;
	}


	
	
}
