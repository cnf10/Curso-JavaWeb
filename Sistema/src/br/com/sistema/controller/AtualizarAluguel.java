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
 * Servlet implementation class AtualizarAluguel
 */
@WebServlet("/AtualizarAluguel")
public class AtualizarAluguel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Aluguel a = new Aluguel();
			a.setId(Long.parseLong(request.getParameter("id")));
			a.setIdAutomovel(Long.parseLong((request.getParameter("id_automovel"))));
			a.setIdCliente(Long.parseLong((request.getParameter("id_cliente"))));
			a.setIdFuncionario(Long.parseLong((request.getParameter("id_funcionario"))));
			a.setValor(Double.parseDouble((request.getParameter("valor"))));

			
			DAOAluguel dao = new DAOAluguel(a);
			dao.atualizar();
			request.setAttribute("mensagem", "Atualizado"); 		
			request.getRequestDispatcher("/VisualizarAluguel?id="+request.getParameter("id"))
			.forward(request,response);
			
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("mensagem","Erro ao Atualizar");
			request.getRequestDispatcher("/VisualizarAluguel?id="+request.getParameter("id"))
			.forward(request,response);
		}
	}

}
