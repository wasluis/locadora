package br.com.framework.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.framework.model.Contato;
import br.com.framework.util.ConexaoUtil;

@Stateless
public class ContatoDAOImpl extends BaseDAOImpl<Contato> {

	
      public Long obterNovoId(Connection connection) throws Exception{
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT NEXTVAL('sq_contato_id') as id ");
        
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql.toString());
        resultSet.next();
        Long id = resultSet.getLong("id");
        
        resultSet.close();
        statement.close();
        
        return id;
    }
      
    public void update(Contato contato) throws Exception {
        Connection connection = ConexaoUtil.getConnection();
        StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE contato SET  nome = ?, sexo = ?, telefone = ?, tipo_telefone = ? ");
        sql.append(" WHERE id = ? ");
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        preparedStatement.setString(1, contato.getNome());
        preparedStatement.setString(2, contato.getSexo().toString());
        preparedStatement.setString(3, contato.getTelefone());
        preparedStatement.setString(4, contato.getTipoTelefone());
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

    public void inserir(Contato contato) throws Exception {
        if (contato.getId() != null) {
            this.update(contato);
        } else {
            Connection connection = ConexaoUtil.getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append(" INSERT INTO contato(id, nome, sexo, telefone, tipo_telefone) ");
            sql.append(" VALUES ( ?, ?, ?, ?, ?) ");

            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
            contato.setId(this.obterNovoId(connection));
            preparedStatement.setLong(1, contato.getId());
            preparedStatement.setString(2, contato.getNome());
            preparedStatement.setString(3, contato.getSexo().toString());
            preparedStatement.setString(4, contato.getTelefone());
            preparedStatement.setString(5, contato.getTipoTelefone());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        }

    }

    public Contato recuperar(Long id) throws Exception {

        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT id, nome, sexo, telefone, tipo_telefone FROM contato where id = ? ");

        Connection connection = ConexaoUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Contato contato = null;
        while (resultSet.next()) {
            String nome = resultSet.getString("titulo");
            Character sexo = resultSet.getString("sexo").charAt(0);
            String telefone = resultSet.getString("telefone");
            String tipoTelefone = resultSet.getString("tipo_telefone");
            contato = new Contato(id, nome, telefone, sexo, tipoTelefone);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
        return contato;
    }

    public boolean excluir(Long id) throws Exception {

        StringBuilder sql = new StringBuilder();
        Connection connection = ConexaoUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        sql = new StringBuilder();
        sql.append(" DELETE FROM  contato WHERE id = ? ");
        preparedStatement = connection.prepareStatement(sql.toString());
        preparedStatement.setLong(1, id);
        preparedStatement.execute();
    
        preparedStatement.close();
        connection.close();
        return true;
    }

    /**
     * Listar todos os contatos
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public List<Contato> getLista() throws SQLException, Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT id, nome, sexo, telefone, tipo_telefone FROM contato ORDER BY nome ");
        List<Contato> contatos = new ArrayList<Contato>();
        Connection connection = ConexaoUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        ResultSet resultSet = preparedStatement.executeQuery();
        try {

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                String tipoTelefone = resultSet.getString("tipo_telefone");
                Character sexo = resultSet.getString("sexo").charAt(0);
                Long id = resultSet.getLong("id");
                Contato  contato = new Contato(id, nome, telefone, sexo, tipoTelefone);
                contatos.add(contato);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }
        return contatos;
    }
    
}
