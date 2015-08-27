package br.com.framework.bean;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import br.com.framework.dao.ContatoDAOImpl;
import br.com.framework.model.Contato;

@ManagedBean(name="rankingBean")
@SessionScoped
public class RankingBean {
	
	private BarChartModel grafMensagens = new BarChartModel();

	private BarChartModel grafChamadas = new BarChartModel();
	
	private BarChartModel grafDuracaoChamadas = new BarChartModel();
	
	
	private static final String LIST = "listRanking.xhtml";
	
	public String prepareList(){

		return 	LIST;
	}

	
	
	@SuppressWarnings("unchecked")
	public String pesquisar(){
		grafMensagens = new BarChartModel();
		grafChamadas = new BarChartModel();
		
		List<Contato> contatosMensagem = getContatoDAO().buscarContatosMensagem();
		Collections.sort(contatosMensagem, ordenarContatoPorQuantMensagem());
		
		this.criarGraficoMensagens();
		this.preencherGraficoMensagens(contatosMensagem);
		
//		List<Contato> contatosChamada = getContatoDAO().buscarContatosChamadas();
//		Collections.sort(contatosChamada, ordenarContatoPorQuantChamada());
//		this.criarGraficoChamdas();
//		this.preencherGraficoChamadas(contatosChamada);
		return "listRanking.xhtml";
	}
	
	private void preencherGraficoMensagens(List<Contato> contatosMensagem) {
		 for(Contato contato : contatosMensagem){
	        ChartSeries contatoSerie = new ChartSeries();
	        contatoSerie.setLabel(contato.getNome());
	        contatoSerie.set(contato.getNome(), contato.getMensagens().size());
	        grafMensagens.addSeries(contatoSerie);
		 }
	}
	
	
	private void preencherGraficoChamadas(List<Contato> contatosChamadas) {
		 for(Contato contato : contatosChamadas){
	        ChartSeries contatoSerie = new ChartSeries();
	        contatoSerie.setLabel(contato.getNome());
	        contatoSerie.set(contato.getNome(), contato.getChamadas().size());
	        grafChamadas.addSeries(contatoSerie);
		 }
	}

	private void criarGraficoMensagens(){
        
        grafMensagens.setTitle("Ranking Mensagens");
        grafMensagens.setLegendPosition("ne");
         
        Axis xAxis = grafMensagens.getAxis(AxisType.X);
        xAxis.setLabel("Contatos");
         
        Axis yAxis = grafMensagens.getAxis(AxisType.Y);
        yAxis.setLabel("Mensagens");
        yAxis.setMin(0);
        yAxis.setMax(50);
	}
	

	private void criarGraficoChamdas(){
        
        grafChamadas.setTitle("Ranking Chamadas");
        grafChamadas.setLegendPosition("ne");
         
        Axis xAxis = grafChamadas.getAxis(AxisType.X);
        xAxis.setLabel("Contatos");
         
        Axis yAxis = grafChamadas.getAxis(AxisType.Y);
        yAxis.setLabel("Chamadas");
        yAxis.setMin(0);
        yAxis.setMax(200);
	}
	

	
	@SuppressWarnings("rawtypes")
	private Comparator ordenarContatoPorQuantMensagem() {
		return new Comparator(){
			public int compare(Object a, Object b){  
			        int resultado = -1;  
			        Integer attributo = ((Contato) a).getMensagens() == null ? 0 : ((Contato) a).getMensagens().size();  
			        resultado = ((Integer) attributo).compareTo(((Contato) b).getMensagens() == null ? 0 : ((Contato) b).getMensagens().size());  
			        return resultado;  
			}
		};
	}
	
	@SuppressWarnings("rawtypes")
	private  Comparator ordenarContatoPorQuantChamada() {
		return new Comparator(){
			public int compare(Object a, Object b){  
			        int resultado = -1;  
			        Integer attributo = ((Contato) a).getChamadas() == null ? 0 : ((Contato) a).getChamadas().size();  
			        resultado = ((Integer) attributo).compareTo(((Contato) b).getChamadas() == null ? 0 : ((Contato) b).getChamadas().size());  
			        return resultado;  
			}
		};
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



	public BarChartModel getGrafMensagens() {
		return grafMensagens;
	}



	public void setGrafMensagens(BarChartModel grafMensagens) {
		this.grafMensagens = grafMensagens;
	}



	public BarChartModel getGrafChamadas() {
		return grafChamadas;
	}



	public void setGrafChamadas(BarChartModel grafChamadas) {
		this.grafChamadas = grafChamadas;
	}



	public BarChartModel getGrafDuracaoChamadas() {
		return grafDuracaoChamadas;
	}



	public void setGrafDuracaoChamadas(BarChartModel grafDuracaoChamadas) {
		this.grafDuracaoChamadas = grafDuracaoChamadas;
	}

	
	
}
