<%-- 
    Document   : adicionaUsuario
    Created on : 26/07/2015, 10:24:57
    Author     : diegogomestome
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <title>Novo Cliente</title>
    </head>
    <body>
        <div class="navbar-wrapper">
           <c:import url="header.jsp"/>
            <div class="row">
                <div class="col-lg-4">

                </div>
                <div class="col-lg-4">
                    <div class="well bs-component">
                        <form class="form-horizontal" action="clienteMvc">
                            <input type="hidden" name="logica" value="AdicionaCliente">
                            <fieldset>
                                <legend>Novo Cliente</legend>
                                <div class="form-group">
                                    <label for="inputPassword" class="col-lg-2 control-label">Nome</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="nome" class="form-control" id="inputPassword" placeholder="Nome">                    
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputCPF" class="col-lg-2 control-label">Cpf</label>
                                    <div class="col-lg-10">
                                        <input type="text" name="log" class="form-control" id="inputEmail" placeholder="Login">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputPassword" class="col-lg-2 control-label">Idade</label>
                                    <div class="col-lg-10">
                                        <input type="text"  name="senha" class="form-control" id="inputPassword" placeholder="Senha">                    
                                    </div>
                                </div>



                                <div class="form-group">
                                    <div class="col-lg-10 col-lg-offset-2">
                                        <button type="reset" class="btn btn-default">Cancelar</button>
                                        <button type="submit" class="btn btn-primary">Adicionar</button>
                                    </div>
                                </div>
                            </fieldset>
                        </form>
                    </div>
                </div>
                <div class="col-lg-4">

                </div>
            </div>
        </div>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
