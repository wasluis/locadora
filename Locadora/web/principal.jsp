<%-- 
    Document   : principal.jsp
    Created on : 25/07/2015, 20:40:26
    Author     : diegogomestome
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link href="css/bootstrap.min.css" rel="stylesheet">
            <title>Logado</title>
    </head>
    <body>

        <div class="navbar-wrapper">
            <div class="container">
                <div class="row">
                    <nav class="navbar navbar-default navbar-fixed-top">
                        <div class="container-fluid">
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                                <a class="navbar-brand" href="#">Movie-UECE</a>
                            </div>

                            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                                <ul class="nav navbar-nav">
                                    <li class="active"><a href="principal.jsp">Inicio <span class="sr-only">(current)</span></a></li>
                                    <li> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Clientes <span class="caret"></span></a>
                                        <ul class="dropdown-menu" role="menu">
                                            <li><a href="/Locadora/adicionaUsuario.jsp">Novo</a></li>
                                            <li><a href="#">Buscar</a></li>
                                            <li><a href="#">Editar</a></li>
                                            <li class="divider"></li>
                                            <li><a href="#">Separated link</a></li>
                                            <li class="divider"></li>
                                            <li><a href="#">One more separated link</a></li>
                                        </ul></li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Filmes <span class="caret"></span></a>
                                        <ul class="dropdown-menu" role="menu">
                                            <li><a href="#">Adicionar</a></li>
                                            <li><a href="#">Buscar</a></li>
                                            <li><a href="#">Editar</a></li>
                                            <li class="divider"></li>
                                            <li><a href="#">Separated link</a></li>
                                            <li class="divider"></li>
                                            <li><a href="#">One more separated link</a></li>
                                        </ul>
                                    </li>
                                </ul>
                                <form class="navbar-form navbar-left" role="search">
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Filme">
                                    </div>
                                    <button type="submit" class="btn btn-default">Buscar</button>
                                </form>
                                <ul class="nav navbar-nav navbar-right">
                                    <li> <c:choose>
                                            <c:when test="${ user eq null }">
                                                <jsp:forward page="erroLogin.jsp" />
                                            </c:when>
                                            <c:otherwise>
                                                <a>Bem-vindo ${ user.nome }</a>
                                            </c:otherwise>
                                        </c:choose></li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </div>
            </div>
            <div class="page-header">
                <div class="row">
                    <div class="col-lg-12">

                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-2">

                    </div>
                    <div class="col-lg-8">



                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <!-- Indicators -->
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>

                            <!-- Wrapper for slides -->
                            <div class="carousel-inner" role="listbox">
                                <div class="item active">
                                    <img src="img/harry_potter.jpeg" alt="...">

                                        <div class="carousel-caption">
                                            ...
                                        </div>
                                </div>
                                <div class="item">

                                    <img src="img/emchamas_lawrance.jpg" alt="...">

                                        <div class="carousel-caption">
                                            ...
                                        </div>
                                </div>
                                <div class="item">

                                    <img src="img/olobo_leonardo.jpg" alt="...">

                                        <div class="carousel-caption">
                                            ...
                                        </div>
                                </div>

                            </div>

                            <!-- Controls -->
                            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-2">

                    </div>
                </div>
            </div> <!-- Carousel -->

        </div>

        <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
