package br.com.framework.dao;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import br.com.framework.model.Contato;
import br.com.framework.vo.ContatoVO;

@Stateless
public class ContatoDAOImpl extends BaseDAOImpl<Contato> {
	
	
	@SuppressWarnings("unchecked")
	public List<Contato> buscarContatos(ContatoVO contatoVO) throws Exception{
		
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT c FROM Contato c WHERE 1 = 1 ");
		if(contatoVO.getNome() != null && !contatoVO.getNome().trim().equals("")){
			sql.append(" and c.nome like :nome ");
		}
		
		if(contatoVO.getTelefone() != null && !contatoVO.getTelefone().trim().equals("")){
			sql.append(" and c.telefone = :telefone ");
		}
		
		if(contatoVO.getTipoTelefone() != null && !contatoVO.getTipoTelefone().trim().equals("")){
			sql.append(" and c.tipoTelefone = :tipoTelefone ");
		}
		
		if(contatoVO.getSexo() != null && !contatoVO.getSexo().equals("")){
			sql.append(" and c.sexo = :sexo ");
		}
		
		if(contatoVO.getDataNascimentoInicial() != null && contatoVO.getDataNascimentoFinal() != null){
			sql.append(" and c.dataNascimento BETWEEN :dataNascimentoInicial AND :dataNascimentoFinal ");
		}
		
		Query query = getEntityManager().createQuery(sql.toString());
		if(contatoVO.getNome() != null && !contatoVO.getNome().trim().equals("")){
			query.setParameter("nome", "%" +  contatoVO.getNome() + "%");
		}
		if(contatoVO.getTelefone() != null && !contatoVO.getTelefone().trim().equals("")){
			query.setParameter("telefone", contatoVO.getTelefone());
		}
		
		if(contatoVO.getTipoTelefone() != null && !contatoVO.getTipoTelefone().trim().equals("")){
			query.setParameter("tipoTelefone", contatoVO.getTipoTelefone());
		}
		

		if(contatoVO.getSexo() != null && !contatoVO.getSexo().equals("")){
			query.setParameter("sexo", contatoVO.getSexo());
		}
		
		if(contatoVO.getDataNascimentoInicial() != null && contatoVO.getDataNascimentoFinal() != null){
			query.setParameter("dataNascimentoInicial", contatoVO.getDataNascimentoInicial());
			query.setParameter("dataNascimentoFinal", contatoVO.getDataNascimentoFinal());
		}

		return query.getResultList();
	}

	
	
	@SuppressWarnings("unchecked")
	public List<Contato> buscarContatosMensagem(){
		
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT DISTINCT c FROM Contato c INNER JOIN FETCH c.mensagens m ");
		Query query = getEntityManager().createQuery(sql.toString());
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Contato> buscarContatosChamadas(){
		
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT c FROM Contato c INNER JOIN FETCH c.chamadas ch ");
		Query query = getEntityManager().createQuery(sql.toString());
		return query.getResultList();
	}
}
