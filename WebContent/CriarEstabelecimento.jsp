<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cadastrar Estabelecimento</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp"/>
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Cadastrar Estabelecimento</h3>
        <!-- Formulario para inclusao de clientes -->
        <form action="controller.do" method="post">
            <!-- area de campos do form -->
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="nome">Estabelecimento</label>
                    <input type="text" class="form-control" name="nome" id="nome" required maxlength="100" placeholder="Novo Estabelecimento">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="endereco">Endereço</label>
                    <input type="text" class="form-control" name="endereco" id="endereco" required maxlength="60" placeholder="Endereço do Estabelecimento">
                </div>

            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="endereco">Categoria</label>
                    <p>
                	<select name="categoria">
					<option value="bar">Bar/Restaurantes</option>
					<option value="cine">Cinema</option>
					<option value="parque">Parque</option>
					</select>
					<p/>
                </div>

			</div>
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="command" value="CriarEstabelecimento">Salvar</button>
                    <a href="controller.do?command=ListarEstabelecimentosReiniciar" class="btn btn-default">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>