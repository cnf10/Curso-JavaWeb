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
    
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/estilo.css"> 
    <title>Lista Aluguel</title>

  </head>
  <body>
  <jsp:include page="includes/menu.jsp"></jsp:include>
  <div id="object" class="pullDown">
  </div>
  <div class="container">
    		<div class="row">
    		<div id="object" class="pullUp">
    				<h1> Listar Aluguel</h1>
    	<p style="color: #f00"> ${mensagem}</p>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
	<jsp:useBean id="dao" class="br.com.sistema.model.DAOAluguel"></jsp:useBean>
	<div class="table-responsive">
            <table class="table table-bordered table-striped table-hover ">
            	<thead>
            		<tr>
            		<th>ID</th>
            		<th>ID Cliente</th>
            		<th>ID Funcionario</th>
            		<th>ID Aluguel</th>
            		<th>Valor</th>
            		<th>Editar</th>
            		<th>Excluir</th>
            		</tr>
            	</thead>
			<c:forEach var="a" items="${dao.aluguels}">
			<tbody>
			<tr>
			<td><p>${a.id}</p></td>
			<td><p>${a.idCliente}</p></td>
			<td><p>${a.idFuncionario}</p></td>
			<td><p>${a.idAluguel}</p></td>
			<td><p>${a.valor}</p></td>
			<td><p><a href="VisualizarAluguel?id=${a.id}" class="btn btn-sm btn-info">Editar</a></p></td>
			<td><p><a href="ExcluirAluguel?id=${a.id}"class="btn btn-sm btn-danger">Excluir</a></p></td>	
			</tr>
			</c:forEach>
		 		</tbody>
            </table>
            </div>
        </div>
    </div>
</div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>