package br.com.framework.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.primefaces.context.RequestContext;

import br.com.framework.dao.ChamadaDAOImpl;
import br.com.framework.model.Chamada;
import br.com.framework.model.Contato;

@ManagedBean
@ViewScoped
public class CounterView implements Serializable {

	private Date number = new Date(0);
	private boolean stoped = false;
	private Chamada chamada= null ;
	

	public String getNumber() {
		SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
		return sdf.format(number);
	}

	public void increment() {
		if (!stoped ) {
			number = new Date(number.getTime() + 1000);
		}
	}

	public void stop() {
		stoped = true;
		RequestContext reqCtx = RequestContext.getCurrentInstance();
		reqCtx.execute("poll.stop();");
	}
	
	public ChamadaDAOImpl getChamadaDAO(){
		ChamadaDAOImpl chamadaDAO = null;
		try {
			chamadaDAO = (ChamadaDAOImpl)new InitialContext().lookup("java:module/ChamadaDAOImpl");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return chamadaDAO;
	}
	
	public String salvar(){
		try{
			getChamadaDAO().insert(chamada);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}

}