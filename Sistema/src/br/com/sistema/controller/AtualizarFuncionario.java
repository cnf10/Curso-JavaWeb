package br.com.sistema.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistema.model.DAOFuncionario;
import br.com.sistema.model.Funcionario;

/**
 * Servlet implementation class AtualizarFuncionario
 */
@WebServlet("/AtualizarFuncionario")
public class AtualizarFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Funcionario f = new Funcionario();
			f.setId(Long.parseLong(request.getParameter("id")));
			f.setNomeFuncionario(request.getParameter("nome_funcionario"));
			f.setMatricula(request.getParameter("matricula"));
			f.setEndereco(request.getParameter("endereco"));
			f.setTelefone(request.getParameter("telefone"));
			f.setCargo(request.getParameter("cargo"));
			
			DAOFuncionario dao = new DAOFuncionario(f);
			dao.atualizar();
			request.setAttribute("mensagem", "Atualizado"); 		
			request.getRequestDispatcher("/VisualizarFuncionario?id="+request.getParameter("id"))
			.forward(request,response);
			
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("mensagem","Erro ao Atualizar");
			request.getRequestDispatcher("/VisualizarFuncionario?id="+request.getParameter("id"))
			.forward(request,response);
		}
		}
}

