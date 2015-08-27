package br.com.framework.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.framework.dao.ChamadaDAOImpl;
import br.com.framework.model.Chamada;
import br.com.framework.vo.ChamadaVO;


@ManagedBean(name="chamadaBean")
@ViewScoped
public class ChamadaBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3250033079195721281L;
	
	private List<Chamada> chamadas;
	private ChamadaVO chamadaVO = new ChamadaVO();

	private static final String LIST = "listChamada.xhtml";
	
	public String prepareList(){
		chamadaVO = new ChamadaVO();
		return 	LIST;
	}

	
	public String pesquisar(){
		try{
			chamadas = getChamadaDAO().buscarChamadas(chamadaVO);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	
	
	public ChamadaDAOImpl getChamadaDAO(){
		ChamadaDAOImpl chamadaDAO = null;
		try {
			chamadaDAO = (ChamadaDAOImpl)new InitialContext().lookup("java:module/ChamadaDAOImpl");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chamadaDAO;
	}


	public List<Chamada> getChamadas() {
		return chamadas;
	}


	public void setChamadas(List<Chamada> chamadas) {
		this.chamadas = chamadas;
	}


	public ChamadaVO getChamadaVO() {
		return chamadaVO;
	}

	public void setChamadaVO(ChamadaVO chamadaVO) {
		this.chamadaVO = chamadaVO;
	}


	
	
}
