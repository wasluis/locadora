package br.com.framework.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import br.com.framework.model.Chamada;
import br.com.framework.model.Mensagem;
import br.com.framework.vo.ChamadaVO;
import br.com.framework.vo.MensagemVO;

@Stateless
public class ChamadaDAOImpl extends BaseDAOImpl<Chamada> {

	public List<Chamada> buscarChamadas(ChamadaVO chamadaVO) {
			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT m FROM Chamada m INNER JOIN FETCH m.contato c WHERE 1 = 1 ");

//		if(chamadaVO.getContato().getNome() != null && !chamadaVO.getContato().getNome().trim().equals("")){
//			sql.append(" and c.nome like :nome ");
//		}
//		
//		if(chamadaVO.getDataEnvioInicial() != null && chamadaVO.getDataEnvioFinal() != null){
//			sql.append(" and m.dataEnvio BETWEEN :dataEnvioInicial AND :dataEnvioFinal ");
//		}
		
		Query query = getEntityManager().createQuery(sql.toString());
//		if(chamadaVO.getContato().getNome() != null && !chamadaVO.getContato().getNome().trim().equals("")){
//			query.setParameter("nome", "%" +  chamadaVO.getContato().getNome() + "%");
//		}
//		if(chamadaVO.getConteudo() != null && !chamadaVO.getConteudo().trim().equals("")){
//			query.setParameter("conteudo", "%" + chamadaVO.getConteudo().trim() + "%" );
//		}
//		
//		
//		if(chamadaVO.getDataEnvioInicial() != null && chamadaVO.getDataEnvioFinal() != null){
//			query.setParameter("dataEnvioInicial", chamadaVO.getDataEnvioInicial());
//			query.setParameter("dataEnvioFinal", chamadaVO.getDataEnvioFinal());
//		}

		return query.getResultList();

	}
	
}
