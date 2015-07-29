<%-- 
    Document   : header
    Created on : 26/07/2015, 14:48:10
    Author     : diegogomestome
--%>

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
                                <li><a href="/Locadora/adicionaCliente.jsp">Novo</a></li>
                                <li><a href="/Locadora/clienteMvc?logica=ListaClientes">Buscar</a></li>
                               
                            </ul></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Filmes <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="/Locadora/adicionaFilme.jsp">Novo</a></li>
                                <li><a href="/Locadora/lista-filmes.jsp">Buscar</a></li>
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
                        <li> </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>
