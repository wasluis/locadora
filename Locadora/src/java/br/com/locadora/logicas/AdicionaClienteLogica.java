/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.logicas;

import br.com.locadora.DAO.ClienteDAO;
import br.com.locadora.DAO.UsuarioDAO;
import br.com.locadora.model.Cliente;
import br.com.locadora.model.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diegogomestome
 */
public class AdicionaClienteLogica implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res)
            throws Exception {


        String nome = req.getParameter("nome");
        String cpf = req.getParameter("cpf");
        int idade = Integer.parseInt(req.getParameter("idade"));
        Long id = null;
        if(req.getParameter("id") != null){
            id = Long.parseLong(req.getParameter("id"));
        }
       Cliente cliente = new Cliente(id ,nome,cpf,idade);

        ClienteDAO dao = new ClienteDAO();
        dao.inserir(cliente);

        System.out.println("Adicionando cliente... ");

        return "clienteMvc?logica=ListaClientes";
    }

}