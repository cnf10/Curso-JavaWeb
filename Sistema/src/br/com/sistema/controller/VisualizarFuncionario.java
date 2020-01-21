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
 * Servlet implementation class VisualizarFuncionario
 */
@WebServlet("/VisualizarFuncionario")
public class VisualizarFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try{
			
			long id =Long.parseLong(request.getParameter("id"));
			
			DAOFuncionario dao = new DAOFuncionario();
			Funcionario funcionario = dao.visualizar(id);
			
			request.setAttribute("funcionario",funcionario);
			request.getRequestDispatcher("visualiza-funcionario.jsp").forward(request,response);
			}catch(Exception e){
				e.printStackTrace();
				request.setAttribute("mensagem","erro");	
			}
		}
	}

