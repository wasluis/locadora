/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.logicas;

import br.com.locadora.DAO.FilmeDAO;
import br.com.locadora.DAO.UsuarioDAO;
import br.com.locadora.enums.GeneroEnum;
import br.com.locadora.model.Filme;
import br.com.locadora.model.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diegogomestome
 */
public class AdicionaFilmeLogica implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res)
            throws Exception {


        String titulo = req.getParameter("titulo");
        int classificacao= Integer.parseInt(req.getParameter("classificacao"));
        int genero= Integer.parseInt(req.getParameter("genero").substring(0, 2).trim());
        Double preco = new Double(req.getParameter("preco"));

        Filme filme = new Filme( new Long(0),  titulo, GeneroEnum.fromOrdinal(genero), classificacao,  preco); 

        FilmeDAO dao = new FilmeDAO();
        dao.inserir(filme);

        System.out.println("Adicionando filme... ");

        return "filmeMvc?logica=ListaFilmes";
    }

}