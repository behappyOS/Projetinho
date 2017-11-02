<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Nova Avaliação</title>
<style>
.estrelas input[type=radio] {
  display: none;
}
.estrelas label i.fa:before {
  content:'\f005';
  color: #FC0;
  font-size:5em;
}
.estrelas input[type=radio]:checked ~ label i.fa:before {
  color: #CCC;
}
</style>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp"/>
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Nova Avaliação #${estabelecimento.idEst }</h3>
         <div class="col-md-12">
                            <p><strong>Estabelecimento</strong>
                            </p>
                            <p>
                                ${estabelecimento.nomeFantasia }
                            </p>
                        </div>
        <!-- Formulario para inclusao de clientes -->
        <p><div class="btn-group btn-group-justified" role="group">
  <div class="btn-group" data-toggle="buttons">      
    <button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#collapse1" aria-expanded="false" aria-controls="collapse1">Acesso Cadeirantes</button>
  </div>
  <div class="btn-group" role="group">
    <button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#collapse2" aria-expanded="false" aria-controls="collapse2">Sanitário Cadeirantes</button>
  </div>
  <div class="btn-group" role="group">
    <button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#collapse3" aria-expanded="false" aria-controls="collapse3">Instruções em Braile</button>
  </div>
    <div class="btn-group" role="group">
    <button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#collapse4" aria-expanded="false" aria-controls="collapse4">Sinalização do Piso</button>
  </div>
</div><p/>
        <form action="controller.do" method="post">
            <!-- area de campos do form -->
            <input type="hidden" name="id" value="${estabelecimento.idEst }" />
            <div class="collapse" id="collapse1">
  				<div class="well">
            <div class="row">
                <div class="form-group col-md-6">
                <h4><label for="nota">Acesso Cadeirantes</label></h4>
                <label for="nota">Nota</label>
                <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
                <div class="estrelas">
  <input type="radio" id="star-empty" name="fb" value="" checked/>
  <label for="star-1"><i class="fa"></i></label>
  <input type="radio" id="star-1" name="fb" value="1"/>
  <label for="star-2"><i class="fa"></i></label>
  <input type="radio" id="star-2" name="fb" value="2"/>
  <label for="star-3"><i class="fa"></i></label>
  <input type="radio" id="star-3" name="fb" value="3"/>
  <label for="star-4"><i class="fa"></i></label>
  <input type="radio" id="star-4" name="fb" value="4"/>
  <label for="star-5"><i class="fa"></i></label>
  <input type="radio" id="star-5" name="fb" value="5"/>
</div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="endereco">Observações</label>
                    </div>
                    <div>
                    <textarea rows="8" class="form-control" rows="5" name="observacao" id="observacao" required maxlength="150" placeholder="Observações ..."></textarea>
                </div>

            </div>
            <hr />

            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="command" value="CriarAvaliacao">Salvar</button>
                    <a href="controller.do?command=ListarAvaliacoesReiniciar" class="btn btn-default">Cancelar</a>
                </div>
            </div>
                        </div>
</div>
        </form>
        
                <form action="controller.do" method="post">
            <!-- area de campos do form -->
            <div class="collapse" id="collapse2">
  				<div class="well">
            <div class="row">
                <div class="form-group col-md-6">
                <h4><label for="nota">Sanitário Cadeirantes</label></h4>
                <label for="nota">Nota</label>
                <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
                <div class="estrelas">
  <input type="radio" id="cmstar-empty" name="fb" value="" checked/>
  <label for="cmstar-1"><i class="fa"></i></label>
  <input type="radio" id="cmstar-1" name="fb" value="1"/>
  <label for="cmstar-2"><i class="fa"></i></label>
  <input type="radio" id="cmstar-2" name="fb" value="2"/>
  <label for="cmstar-3"><i class="fa"></i></label>
  <input type="radio" id="cmstar-3" name="fb" value="3"/>
  <label for="cmstar-4"><i class="fa"></i></label>
  <input type="radio" id="cmstar-4" name="fb" value="4"/>
  <label for="cmstar-5"><i class="fa"></i></label>
  <input type="radio" id="cmstar-5" name="fb" value="5"/>
</div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="endereco">Observações</label>
                    </div>
                    <div>
                    <textarea rows="8" class="form-control" rows="5" name="observacao" id="observacao" required maxlength="150" placeholder="Observações ..."></textarea>
                </div>

            </div>
            <hr />

            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="command" value="CriarAvaliacao">Salvar</button>
                    <a href="controller.do?command=ListarAvaliacoesReiniciar" class="btn btn-default">Cancelar</a>
                </div>
            </div>
                        </div>
</div>
        </form>
        
                <form action="controller.do" method="post">
            <!-- area de campos do form -->
            <div class="collapse" id="collapse3">
  				<div class="well">
            <div class="row">
                <div class="form-group col-md-6">
                <h4><label for="nota">Instruções em Braile</label></h4>
                <label for="nota">Nota</label>
                <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
                <div class="estrelas">
  <input type="radio" id="m_star-empty" name="fb" value="" checked/>
  <label for="m_star-1"><i class="fa"></i></label>
  <input type="radio" id="m_star-1" name="fb" value="1"/>
  <label for="m_star-2"><i class="fa"></i></label>
  <input type="radio" id="m_star-2" name="fb" value="2"/>
  <label for="m_star-3"><i class="fa"></i></label>
  <input type="radio" id="m_star-3" name="fb" value="3"/>
  <label for="m_star-4"><i class="fa"></i></label>
  <input type="radio" id="m_star-4" name="fb" value="4"/>
  <label for="m_star-5"><i class="fa"></i></label>
  <input type="radio" id="m_star-5" name="fb" value="5"/>
</div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="endereco">Observações</label>
                    </div>
                    <div>
                    <textarea rows="8" class="form-control" rows="5" name="observacao" id="observacao" required maxlength="150" placeholder="Observações ..."></textarea>
                </div>

            </div>
            <hr />

            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="command" value="CriarAvaliacao">Salvar</button>
                    <a href="controller.do?command=ListarAvaliacoesReiniciar" class="btn btn-default">Cancelar</a>
                </div>
            </div>
                        </div>
</div>
        </form>
        
                <form action="controller.do" method="post">
            <!-- area de campos do form -->
            <div class="collapse" id="collapse4">
  				<div class="well">
            <div class="row">
                <div class="form-group col-md-6">
                <h4><label for="nota">Sinalização do Piso</label></h4>
                <label for="nota">Nota</label>
                <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
                <div class="estrelas">
  <input type="radio" id="cm_star-empty" name="fb" value="" checked/>
  <label for="cm_star-1"><i class="fa"></i></label>
  <input type="radio" id="cm_star-1" name="fb" value="1"/>
  <label for="cm_star-2"><i class="fa"></i></label>
  <input type="radio" id="cm_star-2" name="fb" value="2"/>
  <label for="cm_star-3"><i class="fa"></i></label>
  <input type="radio" id="cm_star-3" name="fb" value="3"/>
  <label for="cm_star-4"><i class="fa"></i></label>
  <input type="radio" id="cm_star-4" name="fb" value="4"/>
  <label for="cm_star-5"><i class="fa"></i></label>
  <input type="radio" id="cm_star-5" name="fb" value="5"/>
</div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="endereco">Observações</label>
                    </div>
                    <div>
                    <textarea rows="8" class="form-control" rows="5" name="observacao" id="observacao" required maxlength="150" placeholder="Observações ..."></textarea>
                </div>

            </div>
            <hr />

            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="command" value="CriarAvaliacao">Salvar</button>
                    <a href="controller.do?command=ListarAvaliacoesReiniciar" class="btn btn-default">Cancelar</a>
                </div>
            </div>
                        </div>
</div>
        </form>
        
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>