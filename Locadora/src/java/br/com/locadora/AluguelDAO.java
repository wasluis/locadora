/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora;

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
    
    public Aluguel alugar(Cliente cliente, Usuario usuario, List<Filme> filmes) throws Exception{
        
        //Salvando o aluguel para depois salvar os filmes para esse aluguel
        Double valor = 0D;
        for(Filme filme : filmes){
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
        
        Aluguel aluguelSalvo = new Aluguel();
        aluguelSalvo.setId(idAluguel);
        aluguelSalvo.setCliente(cliente);
        aluguelSalvo.setDataAluguel(dataAluguel);
        aluguelSalvo.setFilmes(filmes);
        aluguelSalvo.setOperador(usuario);
        aluguelSalvo.setValor(valor);
        return aluguelSalvo;
    }
}
