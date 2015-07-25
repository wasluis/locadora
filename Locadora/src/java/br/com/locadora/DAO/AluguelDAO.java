/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.DAO;


import br.com.locadora.exception.AluguelPendenteException;
import br.com.locadora.exception.ClassificacaoIndicativaException;
import br.com.locadora.exception.QuantidadeFilimesException;
import br.com.locadora.model.Aluguel;
import br.com.locadora.model.Cliente;
import br.com.locadora.model.Filme;
import br.com.locadora.model.Usuario;
import br.com.locadora.util.ConexaoUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Washington
 */
public class AluguelDAO {

    FilmeDAO filmeDAO = new FilmeDAO();
    
    public Long obterNovoId(Connection connection) throws Exception{
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT NEXTVAL('sq_aluguel_id') as id ");
        
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql.toString());
        resultSet.next();
        Long id = resultSet.getLong("id");
        
        resultSet.close();
        statement.close();
        
        return id;
    }
    
    public Aluguel alugar(Cliente cliente, Usuario usuario, List<Filme> filmes) 
            throws AluguelPendenteException, QuantidadeFilimesException, ClassificacaoIndicativaException, Exception{
        
        //Verificando quantidade de filmes
        if(filmes.size() > 3){
            throw new QuantidadeFilimesException();
        }
        
        if(this.buscarAluguelPendente(cliente) != null){
            throw new AluguelPendenteException();
        }
        
        //Salvando o aluguel para depois salvar os filmes para esse aluguel
        Double valor = 0D;
        for(Filme filme : filmes){
            //Verificando idade do cliente. Passa o filme para a exceção para que saiba qual está fora da idade
            if(filme.getClassificacao() > cliente.getIdade()){
                throw new ClassificacaoIndicativaException(filme);
            }
            valor += filme.getPreco();
        }
        StringBuilder sql = new StringBuilder();
        sql.append(" INSERT INTO aluguel(id, data_aluguel, cliente_id, valor, operador_id) ");
        sql.append(" VALUES (?, ?, ?, ?, ?)");
        
        Connection connection = ConexaoUtil.getConnection();
        Long idAluguel = this.obterNovoId(connection);
        Date dataAluguel = new Date();
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        preparedStatement.setLong(1, idAluguel);
        preparedStatement.setTimestamp(2, new Timestamp(dataAluguel.getTime()));
        preparedStatement.setLong(3, cliente.getId());
        preparedStatement.setDouble(4, valor);
        preparedStatement.setLong(5, usuario.getId());
        preparedStatement.execute();
        
        sql.setLength(0);
        
        sql.append(" INSERT INTO aluguel_filme (aluguel_id, filme_id) VALUES (?, ?)");
        preparedStatement = connection.prepareStatement(sql.toString());
        for(Filme filme : filmes){
            preparedStatement.setLong(1, idAluguel);
            preparedStatement.setLong(2, filme.getId());
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        preparedStatement.close();
        connection.close();
        
        Aluguel aluguelSalvo = new Aluguel(idAluguel, dataAluguel,filmes, cliente, valor, usuario);
        return aluguelSalvo;
    }

    private Aluguel buscarAluguelPendente(Cliente cliente) throws Exception{
    
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT a.id idAluguel, data_aluguel, valor, u.id idOperador, u.nome  FROM aluguel a inner join usuario u ON u.id = a.operador_id ") ;
                sql.append(" where cliente_id = ? AND data_devolucao is null ");
        
        Connection connection = ConexaoUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        preparedStatement.setLong(1, cliente.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        
        Aluguel aluguel = null;
        while(resultSet.next()){
            aluguel.setId(resultSet.getLong("idAluguel"));
            aluguel.setDataAluguel(resultSet.getDate("data_aluguel"));
            aluguel.setDataDevolucao(resultSet.getDate("data_devolucao"));
            aluguel.setValor(resultSet.getDouble("valor"));
            aluguel.setOperador(new Usuario());
            aluguel.getOperador().setId(resultSet.getLong("idOperador"));
            aluguel.getOperador().setNome(resultSet.getString("nome"));
            
            aluguel.setFilmes(filmeDAO.buscarFilmesPorAluguel(aluguel.getId()));
            
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return aluguel;
    }        
    
    
    
    
}
