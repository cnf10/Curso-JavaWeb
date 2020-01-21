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
    <title>Lista Aluno</title>

  </head>
  <body>
  <jsp:include page="includes/menu.jsp"></jsp:include>
  <div id="object" class="pullDown">
  </div>
  <div class="container">
    		<div class="row">
    		<div id="object" class="pullUp">
    				<h1> Listar Funcionario</h1>
    	<p style="color: #f00"> ${mensagem}</p>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
	<jsp:useBean id="dao" class="br.com.sistema.model.DAOFuncionario"></jsp:useBean>
	<div class="table-responsive">
            <table class="table table-bordered table-striped table-hover ">
            	<thead>
            		<tr>
            		<th>ID</th>
            		<th>Nome</th>
            		<th>Matricula</th>
            		<th>Telefone</th>
            		<th>Endereco</th>
            		<th>Cargo</th>
            		<th>Editar</th>
            		<th>Excluir</th>
            		</tr>
			<c:forEach var="f" items="${dao.funcionarios}">
			<tbody>
			<tr>
			<td><p>${f.id}</p></td>
			<td><p>${f.nomeFuncionario}</p></td>
			<td><p>${f.matricula}</p></td>
			<td><p>${f.telefone}</p></td>
			<td><p>${f.endereco}</p></td>
			<td><p>${f.cargo}</p></td>
			<td><p><a href="VisualizarFuncionario?id=${f.id}" class="btn btn-sm btn-info">Editar</a></p></td>
			<td><p><a href="ExcluirFuncionario?id=${f.id}"class="btn btn-sm btn-danger">Excluir</a></p></td>	
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