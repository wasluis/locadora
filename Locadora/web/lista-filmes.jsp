<%-- 
    Document   : lista-filmes
    Created on : 28/07/2015, 01:32:05
    Author     : diegogomestome
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Filmes</title>
    </head>
    <body>
        <table class="table table-striped table-hover ">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Nome</th>
                    <th>Login</th>
                    <th>Senha</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>

            <c:forEach var="filme" items="${filmes}">
                <tr class="success">
                    <td></td>
                    <td>
                        ${filme.nome}
                    </td>

                    <td>
                        ${filme.login}
                    </td>

                    <td>
                        ${filme.senha}
                    </td>

                    <td>
                        <a href="/Locadora/usuarioMvc?logica=RemoveUsuario&id=${filme.id}">Remover</a>
                    </td>
                    <td>
                        <a href="/Locadora/atualizaUsuario.jsp&id=${filme.id}&nome=${usuario.nome}&login=${usuario.login}&senha=${usuario.senha}">Editar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>

