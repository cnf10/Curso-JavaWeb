<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:if test="${usuario.nome == null}">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Visualizar Cliente</title>
 <link href="css/bootstrap.min.css" rel="stylesheet">
 <link rel="stylesheet" type="text/css" href="css/estilo.css"> 
  </head>
  <body>
  <jsp:include page="includes/menu.jsp"></jsp:include>
 <div class="container-fluid">
 	<div class="row">
 			<h1> Visualizar  Cliente</h1>
 		 <div class="col-md-3 col-md-offset-3">
 	<form class="form-horizontal" method ="Post" action="AtualizarCliente">
 		<input type="hidden" name="id" value="${cliente.id}"/>
		   <div class="form-group">
		    <label for="Nome do Cliente">Nome do Cliente</label>
		    <input type="text" class="form-control" id="nome_cliente" name="nome_cliente" placeholder="Nome do Cliente"  value="${cliente.nomeCliente}">
		  </div>
		   <div class="form-group">
		    <label for="CPF">CPF</label>
		    <input type="text" class="form-control" id="cpf" name="cpf" placeholder="CPF" value="${cliente.cpf}">
		  </div>
		   <div class="form-group">
		    <label for="Endereco">Endereco</label>
		    <input type="text" class="form-control" id="endereco" name="endereco" placeholder="Endereco"  value="${cliente.endereco}">
		  </div>
		   <div class="form-group">
		    <label for="Telefone">Telefone</label>
		    <input type="text" class="form-control" id="telefone" name="telefone" placeholder="Telefone"  value="${cliente.telefone}">
		  </div>
	<div class="row">
 	 <button type="submit" class="btn btn-success">Atualizar</button>
 	</div>
  	</form>
  			</div>
		</div>
	</div>
<button type="button" class="close" data-dismiss="alert" aria-label="Close">
  <span aria-hidden="true">${mensagem}</span>
</button>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
 <script src="js/bootstrap.min.js"></script>
  </body>
</html>