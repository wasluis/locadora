package br.com.framework.dao;


import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.framework.model.Contato;
import br.com.framework.vo.ContatoVO;

@Stateless
public class ContatoDAOImpl extends BaseDAOImpl<Contato> {
	
	
	@SuppressWarnings("unchecked")
	public List<Contato> buscarContatos(ContatoVO contatoVO) throws Exception{
		
		Criteria criteria = getSession().createCriteria(Contato.class, "c");
		
		if(contatoVO.getNome() != null && !contatoVO.getNome().trim().equals("")){
			criteria.add(Restrictions.eq("c.nome", contatoVO.getNome()));
		}
		
		if(contatoVO.getTelefone() != null && !contatoVO.getTelefone().trim().equals("")){
			criteria.add(Restrictions.eq("c.telefone", contatoVO.getTelefone()));
		}
		
		if(contatoVO.getTipoTelefone() != null && !contatoVO.getTipoTelefone().trim().equals("")){
			criteria.add(Restrictions.eq("c.tipoTelefone", contatoVO.getTipoTelefone()));
		}
		
		if(contatoVO.getSexo() != null && !contatoVO.getSexo().equals("")){
			criteria.add(Restrictions.eq("c.sexo", contatoVO.getSexo()));
		}
		
		if(contatoVO.getDataNascimentoInicial() != null && contatoVO.getDataNascimentoFinal() != null){
			criteria.add(Restrictions.between("c.dataNascimento", contatoVO.getDataNascimentoInicial(), contatoVO.getDataNascimentoFinal()));
		}
		
		return criteria.list();
		
		
	}
	
}
