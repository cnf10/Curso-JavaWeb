package br.com.sistema.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistema.model.Aluguel;
import br.com.sistema.model.DAOAluguel;


/**
 * Servlet implementation class VisualizarAluguel
 */
@WebServlet("/VisualizarAluguel")
public class VisualizarAluguel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
			long id =Long.parseLong(request.getParameter("id"));
			
			DAOAluguel dao = new DAOAluguel();
			Aluguel aluguel = dao.visualizar(id);
			
			request.setAttribute("aluguel",aluguel);
			request.getRequestDispatcher("visualiza-aluguel.jsp").forward(request,response);
			}catch(Exception e){
				e.printStackTrace();
				request.setAttribute("mensagem","erro");	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
