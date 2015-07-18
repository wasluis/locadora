/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora;

import br.com.locadora.enums.GeneroEnum;
import br.com.locadora.model.Ator;
import br.com.locadora.model.Filme;
import br.com.locadora.util.ConexaoUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Washington
 */
public class FilmeDAO {
   
    
    
    public void update(Filme  filme) throws Exception{
        Connection connection = ConexaoUtil.getConnection();
        StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE filme SET  titulo = ?, genero_enum = ?, classificacao = ?, preco = ? ");
        sql.append(" WHERE id = ? ");
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        preparedStatement.setString(1, filme.getTitulo());
        preparedStatement.setInt(2, filme.getGenero().ordinal());
        preparedStatement.setInt(3, filme.getClassificacao());
        preparedStatement.setDouble(4, filme.getPreco());
        preparedStatement.setLong(5, filme.getId());
        
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
        
    }
    
    public void inserir(Filme filme) throws Exception{
        if(filme.getId() != null){
            this.update(filme);
        }
        else{
            Connection connection = ConexaoUtil.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append(" INSERT INTO filme(id, titulo, genero_enum, classificacao, preco) ");
            sql.append(" VALUES ( NEXTVAL('sq_filme_id'), ?, ?, ?, ?) ");

            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setString(1, filme.getTitulo());
            preparedStatement.setInt(2, filme.getGenero().ordinal());
            preparedStatement.setInt(3, filme.getClassificacao());
            preparedStatement.setDouble(4, filme.getPreco());
            preparedStatement.execute();
        
            preparedStatement.close();
            connection.close();
        }
        
    }
    
    
    public Filme recuperar(Long id) throws Exception{
        
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT id, titulo, genero_enum, classificacao, preco FROM filme where id = ? ");
        
        Connection connection = ConexaoUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Filme filme = null;
        while(resultSet.next()){
            String nome = resultSet.getString("titulo");
            int genero = resultSet.getInt("genero_enum");
            int classificacao = resultSet.getInt("classificacao");
            Double preco = resultSet.getDouble("preco");
            filme = new Filme(id, nome, GeneroEnum.fromOrdinal(genero), classificacao, preco);
        }
        
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return filme;
    }
    
    public boolean excluir(Long id) throws Exception{
        
        StringBuilder sql = new StringBuilder();
        sql.append(" DELETE FROM  filme WHERE id = ? ");
        
        Connection connection = ConexaoUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        preparedStatement.setLong(1, id);
        try{
            preparedStatement.execute();
            return true;
        }catch(Exception e){
            return false;
        }finally{
            preparedStatement.close();
            connection.close();
        }
    }
    
    public List<Filme> buscarFilme(String titulo) throws Exception{
        
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT id, titulo, genero_enum, classificacao, preco FROM filme where titulo like ? ");
        
        Connection connection = ConexaoUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        preparedStatement.setString(1, "%" + titulo + "%");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Filme> filmes = new ArrayList<Filme>();
        while(resultSet.next()){
            String nome = resultSet.getString("titulo");
            int genero = resultSet.getInt("genero_enum");
            int classificacao = resultSet.getInt("classificacao");
            Double preco = resultSet.getDouble("preco");
            Long id = resultSet.getLong("id");
            Filme filme = new Filme(id, nome, GeneroEnum.fromOrdinal(genero), classificacao, preco);
            filmes.add(filme);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return filmes;
    }    
}
