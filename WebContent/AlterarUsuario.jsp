<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Alterar Usuario</title>

            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style.css" rel="stylesheet">
        </head>

        <body>
                <!-- Barra superior com os menus de navegação -->
				<c:import url="Menu.jsp"/>
                <!-- Container Principal -->
                <div id="main" class="container">
                    <h3 class="page-header">Alterar Usuario #${usuario.idUsuario }</h3>
                    <!-- Formulario para alteração de clientes -->
                    <form action="controller.do" method="post">
                        <!-- area de campos do form -->
                        <input type="hidden" name="id" value="${usuario.idUsuario }" />
                        <div class="row">
                <div class="form-group col-md-6">
                    <label for="login">Nome Completo</label>
                    <input type="text" class="form-control" name="nome" id="nome" required maxlength="60" placeholder="Nome Completo">
                </div>

            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="login">Login</label>
                    <input type="text" class="form-control" name="login" id="login" required maxlength="60" placeholder="Login Obrigátorio">
                </div>

            </div>
                                    <div class="row">
                <div class="form-group col-md-6">
                    <label for="senha">Senha</label>
                    <input type="password" class="form-control" name="senha" id="senha" required maxlength="60" placeholder="Senha Obrigátoria">
                </div>

            </div>
                                                <div class="row">
                <div class="form-group col-md-6">
                    <label for="senha">E-mail</label>
                    <input type="email" class="form-control" name="email" id="email" required maxlength="60" placeholder="E-mail Obrigátorio">
                </div>

            </div>
                                                <div class="row">
                <div class="form-group col-md-6">
                    <label for="senha">Celular</label>
                    <input type="tel" class="form-control" name="celular" id="celular" maxlength="60" pattern="(?:\(\d{2}\)|\d{2})[- ]?\d{5}[- ]?\d{4}" placeholder="Celular Opcional, com ddd no formato (99) 99999-9999">
                </div>

            </div>
            
                        <hr />
                        <div id="actions" class="row">
                            <div class="col-md-12">
                                <button type="submit" class="btn btn-primary" name="command" value="AlterarUsuario">Salvar</button>
                                <a href="index.jsp" class="btn btn-default">Cancelar</a>
                            </div>
                        </div>
                    </form>
                </div>
                <script src="js/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
        </body>

        </html>