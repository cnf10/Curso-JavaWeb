package br.com.sistema.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistema.model.Automovel;
import br.com.sistema.model.DAOAutomovel;

/**
 * Servlet implementation class VisualizarAutomovel
 */
@WebServlet("/VisualizarAutomovel")
public class VisualizarAutomovel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try{
		
		long id =Long.parseLong(request.getParameter("id"));
		
		DAOAutomovel dao = new DAOAutomovel();
		Automovel automovel = dao.visualizar(id);
		
		request.setAttribute("automovel",automovel);
		request.getRequestDispatcher("visualiza-automovel.jsp").forward(request,response);
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("mensagem","erro");	
	}
	}
}
