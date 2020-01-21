w<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/estilo.css"> 
    <title>Lista Cliente</title>

  </head>
  <body>
  <jsp:include page="includes/menu.jsp"></jsp:include>
  <div id="object" class="pullDown">
  </div>
  <div class="container">
    		<div class="row">
    		<div id="object" class="pullUp">
    				<h1> Listar Cliente</h1>
    	<p style="color: #f00"> ${mensagem}</p>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
	<jsp:useBean id="dao" class="br.com.sistema.model.DAOCliente"></jsp:useBean>
	<div class="table-responsive">
            <table class="table table-bordered table-striped table-hover ">
            	<thead>
            		<tr>
            		<th>ID</th>
            		<th>Nome</th>
            		<th>CPF</th>
            		<th>Endereco</th>
            		<th>Telefone</th>
            		<th>Editar</th>
            		<th>Excluir</th>
            		</tr>
            	</thead>
			<c:forEach var="c" items="${dao.clientes}">
			<tbody>
			<tr>
			<td><p>${c.id}</p></td>
			<td><p>${c.nomeCliente}</p></td>
			<td><p>${c.cpf}</p></td>
			<td><p>${c.telefone}</p></td>
			<td><p>${c.endereco}</p></td>
			<td><p><a href="VisualizarCliente?id=${c.id}" class="btn btn-sm btn-info">Editar</a></p></td>
			<td><p><a href="ExcluirCliente?id=${c.id}"class="btn btn-sm btn-danger">Excluir</a></p></td>	
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