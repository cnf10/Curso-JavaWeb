<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login </title>
 <link href="css/bootstrap.min.css" rel="stylesheet">
 <link rel="stylesheet" type="text/css" href="css/style.css"> 
 <link rel="stylesheet" href="css/animations.css">
  </head>
  <body>
 <div class="container-fluid">
 	<div id="object" class="pullDown">
 	<div class="row">
 		 <div class="col-md-3 col-md-offset-3">
 		 <div class="jumbotron">
 		 <h2> Login</h2>
 	<form class="form-horizontal" method ="Post" action="Logar">
		   <div class="form-group">
		    <label for="Usuario">Usuario</label>
		    <input type="text" class="form-control" id="usuario" name="usuario" placeholder="Usuario">
		  </div>
		   <div class="form-group">
		    <label for="Senha">Senha</label>
		    <input type="text" class="form-control" id="senha" name="senha" placeholder="Senha">
		  </div>
	<div class="row">
 	 <button type="submit" class="btn btn-success">Entrar</button>
 	</div>
  	</form>
  				</div>
  			</div>
		</div>
	</div>
</div>
${mensagem}
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
 <script src="js/bootstrap.min.js"></script>
  </body>
</html>