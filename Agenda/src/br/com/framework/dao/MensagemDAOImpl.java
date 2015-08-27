package br.com.framework.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import br.com.framework.dao.impl.MensagemDAO;
import br.com.framework.model.Mensagem;
import br.com.framework.vo.MensagemVO;

@Stateless
public class MensagemDAOImpl extends BaseDAOImpl<Mensagem>  {


	@SuppressWarnings("unchecked")
	public List<Mensagem> buscarMensagens(MensagemVO mensagemVO) throws Exception{
		
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT m FROM Mensagem m INNER JOIN FETCH m.contato c WHERE 1 = 1 ");

		if(mensagemVO.getContato().getNome() != null && !mensagemVO.getContato().getNome().trim().equals("")){
			sql.append(" and c.nome like :nome ");
		}
		
		if(mensagemVO.getConteudo() != null && !mensagemVO.getConteudo().trim().equals("")){
			sql.append(" and m.conteudo like :conteudo ");
		}
		
		if(mensagemVO.getDataEnvioInicial() != null && mensagemVO.getDataEnvioFinal() != null){
			sql.append(" and m.dataEnvio BETWEEN :dataEnvioInicial AND :dataEnvioFinal ");
		}
		
		Query query = getEntityManager().createQuery(sql.toString());
		if(mensagemVO.getContato().getNome() != null && !mensagemVO.getContato().getNome().trim().equals("")){
			query.setParameter("nome", "%" +  mensagemVO.getContato().getNome() + "%");
		}
		if(mensagemVO.getConteudo() != null && !mensagemVO.getConteudo().trim().equals("")){
			query.setParameter("conteudo", "%" + mensagemVO.getConteudo().trim() + "%" );
		}
		
		
		if(mensagemVO.getDataEnvioInicial() != null && mensagemVO.getDataEnvioFinal() != null){
			query.setParameter("dataEnvioInicial", mensagemVO.getDataEnvioInicial());
			query.setParameter("dataEnvioFinal", mensagemVO.getDataEnvioFinal());
		}

		return query.getResultList();
	}

	
}
