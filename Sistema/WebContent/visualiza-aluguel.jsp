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
    <title>Cadastro de Aluguel</title>
 <link href="css/bootstrap.min.css" rel="stylesheet">
 <link rel="stylesheet" type="text/css" href="css/estilo.css"> 
  </head>
  <body>
  <jsp:include page="includes/menu.jsp"></jsp:include>
 <div class="container-fluid">
 	<div class="row">
 			<h1> Cadastro de Aluguel</h1>
 		 <div class="col-md-3 col-md-offset-3">
 	<form class="form-horizontal" method ="Post" action="AtualizarAluguel">
 		<input type="hidden" name="id" value="${aluguel.id}"/>
		   <div class="form-group">
		    <label for="Id Cliente">Id Cliente</label>
		    <input type="text" class="form-control" id="id_cliente" name="id_cliente" placeholder="ID Cliente"  value="${aluguel.idCliente}"> 
		  </div>
		   <div class="form-group">
		    <label for="Id Funcionario">Id Funcionario</label>
		    <input type="text" class="form-control" id="id_funcionario" name="id_funcionario" placeholder="ID Funcionario"  value="${aluguel.idFuncionario}">
		  </div>
		   <div class="form-group">
		    <label for="Id Automovel">Id Automovel</label>
		    <input type="text" class="form-control" id="id_automovel" name="id_automovel" placeholder="ID Automovel"  value="${aluguel.idAutommovel}">
		  </div>
		   <div class="form-group">
		    <label for="Valor">Valor</label>
		    <input type="text" class="form-control" id="valor" name="valor" placeholder="Valor"  value="${aluguel.valor}">
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