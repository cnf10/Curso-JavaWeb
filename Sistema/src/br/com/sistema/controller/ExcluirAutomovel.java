package br.com.sistema.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistema.model.DAOAutomovel;
/**
 * Servlet implementation class ExcluirAutomovel
 */
@WebServlet("/ExcluirAutomovel")
public class ExcluirAutomovel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try{
			
			long id =Long.parseLong(request.getParameter("id"));
			DAOAutomovel dao = new DAOAutomovel();
			dao.excluir(id);
			request.setAttribute("mensagem","Excluido com Sucesso!");
			}catch(Exception e){
				e.printStackTrace();
				request.setAttribute("mensagem","erro");	
			}
			request.getRequestDispatcher("lista-automovel.jsp").forward(request,response);
	}

}
