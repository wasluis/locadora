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

            <c:import url="header.jsp"/>
          


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
                        <button class="btn btn-info center-block" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                            Realizar Aluguel
                        </button>
                        <div class="collapse" id="collapseExample">
                            <div class="well">
                                ...
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2">

                    </div>
                </div>
            </div>
            <%-- <c:import url="carrosel.jsp"/> Carousel --%>

        </div>

        <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
