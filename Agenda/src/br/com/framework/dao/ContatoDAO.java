package br.com.framework.dao;

import java.util.List;

import br.com.framework.model.Contato;
import br.com.framework.vo.ContatoVO;

public interface ContatoDAO extends BaseDAO<Contato>{
	
	List<Contato> buscarContatos(ContatoVO contatoVO) throws Exception;

}
