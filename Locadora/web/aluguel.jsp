<%-- 
    Document   : adicionaUsuario
    Created on : 26/07/2015, 10:24:57
    Author     : diegogomestome
--%>
<script>
    var count = 1;
    $(document).ready(function () {
        $("#btn1").click(function () {
            count++;
            if (count < 4)
                    $("#film").append(" <div class=\"col - lg - 10\"><select name=\"filme\" class=\"form - control\" id=\"sel1\"><c:forEach var=\"filme\" items=\"\${filmes}\"><option>\${filme.titulo}</option></c:foreach></select></div>");
        });
    });
</script>



<div class="modal fade" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Aluguel</h4>
            </div>
            <div class="modal-body">




                <div class="well bs-component">
                    <form class="form-horizontal" action="aluguelMvc">
                        <input type="hidden" name="logica" value="AdicionaAluguel">
                        <fieldset>
                            <legend>Novo Aluguel</legend>

                            <div class="form-group">
                                <label for="inputPassword" class="col-lg-2 control-label">Selecione o Cliente</label>
                                <div class="col-lg-10">


                                    <select name="cliente" class="form-control" id="sel1">
                                        <c:forEach var="cliente" items="${clientes}">
                                            <option>${cliente.nome}</option>
                                        </c:foreach>
                                    </select>
                                </div>
                            </div>


                            <div class="form-group" id="film">
                                <label for="inputPassword" class="col-lg-2 control-label">Selecione o Filme</label>
                                <div class="col-lg-10">


                                    <select name="filme" class="form-control" id="sel1">
                                        <c:forEach var="filme" items="${filmes}">
                                            <option>${filme.titulo}</option>
                                        </c:foreach>
                                    </select>

                                </div>
                                <div class="col-lg-10">
                                    <button type="button" class="btn-info"id="btn1">Adicionar Filme</button>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputPreco" class="col-lg-2 control-label">Preço</label>
                                <div class="col-lg-10">
                                    <input type="text" name="preco" class="form-control" id="inputPassword" placeholder="Preço">                    
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputTitulo" class="col-lg-2 control-label">Data do Aluguel</label>
                                <div class="bfh-datepicker col-lg-10">
                                    <input type="text" value="12-02-2012">
                                    <span class="add-on"><i class="icon-th"></i></span>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-lg-12 col-lg-offset-6">
                                    <button type="reset" class="btn btn-danger">Cancelar</button>
                                    <button type="submit" class="btn btn-info">Efetivar Aluguel</button>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
            <div class="modal-footer">

            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
