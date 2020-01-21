 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">

      <!-- Static navbar -->
      <nav class="navbar navbar-inverse">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            
            <a class="navbar-brand" href="#">Sistema CW</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li><a href="cadastro-aluguel.jsp">Cadastrar Aluguel</a></li>
              <li><a href="lista-aluguel.jsp">Listar Aluguel</a></li>
              <li><a href="cadastro-automovel.jsp">Cadastrar Automovel</a></li>
              <li><a href="lista-automovel.jsp">Listar Automovel</a></li>
              <li><a href="cadastro-cliente.jsp">Cadastrar Cliente</a></li>
              <li><a href="lista-cliente.jsp">Listar Cliente</a></li>
          	 <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          Funcionario
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
		       		<a href="cadastro-funcionario.jsp">Cadastrar Funcionario</a>
              		<a href="lista-funcionario.jsp">Listar Funcionario</a>
		        </div>
		      </li>
            </ul>
         <div id="navbar"  class="navbar-text navbar-right">
         ${usuario.nome} | <a href="Logoff">Sair</a>
         
         </div>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>

    </div> 