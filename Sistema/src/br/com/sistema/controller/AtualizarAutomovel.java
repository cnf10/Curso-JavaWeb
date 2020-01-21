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
 * Servlet implementation class AutualizarAutomovel
 */
@WebServlet("/AutualizarAutomovel")
public class AtualizarAutomovel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Automovel a = new Automovel();
			a.setId(Long.parseLong(request.getParameter("id")));
			a.setModelo(request.getParameter("modelo"));
			a.setPlaca(request.getParameter("placa"));
			a.setAno(request.getParameter("ano"));
			a.setValor(Double.parseDouble((request.getParameter("valor"))));

			
			DAOAutomovel dao = new DAOAutomovel(a);
			dao.atualizar();
			request.setAttribute("mensagem", "Atualizado"); 		
			request.getRequestDispatcher("/VisualizarAutomovel?id="+request.getParameter("id"))
			.forward(request,response);
			
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("mensagem","Erro ao Atualizar");
			request.getRequestDispatcher("/VisualizarAutomovel?id="+request.getParameter("id"))
			.forward(request,response);
		}
	}

}
