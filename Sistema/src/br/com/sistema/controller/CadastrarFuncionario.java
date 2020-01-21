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
 * Servlet implementation class CadastrarFuncionario
 */
@WebServlet("/CadastrarFuncionario")
public class CadastrarFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
			Funcionario f = new Funcionario();
			f.setNomeFuncionario(request.getParameter("nome_funcionario"));
			f.setMatricula(request.getParameter("matricula"));
			f.setEndereco(request.getParameter("endereco"));
			f.setTelefone(request.getParameter("telefone"));
			f.setCargo(request.getParameter("cargo"));

			DAOFuncionario dao = new DAOFuncionario(f);
			dao.cadastrar();
			request.setAttribute("mensagem", "cadastrado"); 		
		}catch(Exception e){
			e.printStackTrace();
				request.setAttribute("mensagem","Erro ao Cadastrar");
			}
				request.getRequestDispatcher("cadastro-funcionario.jsp").forward(request,response);
			}
	}

