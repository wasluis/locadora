<%-- 
    Document   : lista-usuarios
    Created on : 26/07/2015, 10:33:59
    Author     : diegogomestome
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Usuarios</title>
    </head>
    <body>
        <table>
            <c:forEach var="usuario" items="${usuarios}">
                <tr>
                    <td>
                        ${usuario.nome}
                    </td>

                    <td>
                        ${usuario.login}
                    </td>

                    <td>
                        ${usuario.senha}
                    </td>

                    <td>
                        <a href="mvc?logica=RemoveContato&id=${usuario.id}">Remover</a>
                    </td>
                </tr>
            </c:forEach></table>
    </body>
</html>
