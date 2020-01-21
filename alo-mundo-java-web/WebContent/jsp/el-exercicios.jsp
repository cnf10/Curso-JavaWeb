<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.edu.alomundo.modelo.Pessoa"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exerc�cios Scriptlets</title>
</head>
<body>

	<%! int cont; %>

	<%
		List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
	
		Pessoa pessoa = new Pessoa();
		pessoa.setIdade(13);
		pessoa.setNasc(new Date());
		pessoa.setNome("Manuel");
		pessoa.setPeso(56.5);
		listaPessoas.add(pessoa);
		
		pessoa = new Pessoa();
		pessoa.setIdade(18);
		pessoa.setNasc(new Date());
		pessoa.setNome("Joana");
		pessoa.setPeso(49.6);
		listaPessoas.add(pessoa);
		
		pessoa = new Pessoa();
		pessoa.setIdade(45);
		pessoa.setNasc(new Date());
		pessoa.setNome("Jo�o");
		pessoa.setPeso(76);
		listaPessoas.add(pessoa);
		
	%>

	<table width="500" cellpadding="5" cellspacing="0" align="center" border="1">
		<tr>
			<td>Nome</td>
			<td>Nascimento</td>
			<td>Idade</td>
			<td>Peso</td>
		</tr>
		
		<%
			DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			String bgcolor = null;
			for (Pessoa p : listaPessoas) {
				if (cont % 2 == 0) {
					bgcolor = "none";
				} else {
					bgcolor = "blue";
				}
				request.setAttribute ("p", p);
				request.setAttribute("bgcolor", bgcolor);
		%>
			<tr style="background-color: ${bgcolor}">
				<td>${p.nome}</td>			
				<td>${p.nasc}</td>			
				<td>${p.idade}</td>			
				<td>${p.peso}</td>			
			</tr>
		<%
			cont++;
			}
		%>
	</table>

</body>
</html>