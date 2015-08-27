package br.com.framework.dao.impl;

import java.util.List;

import br.com.framework.dao.BaseDAO;
import br.com.framework.model.Mensagem;
import br.com.framework.vo.MensagemVO;

public interface MensagemDAO extends BaseDAO<Mensagem>{

	List<Mensagem> buscarMensagens(MensagemVO mensagemVO) throws Exception;
	
}
