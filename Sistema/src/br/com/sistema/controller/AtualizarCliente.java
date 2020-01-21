package br.com.sistema.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistema.model.Cliente;
import br.com.sistema.model.DAOCliente;


/**
 * Servlet implementation class AtualizarCliente
 */
@WebServlet("/AtualizarCliente")
public class AtualizarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Cliente c = new Cliente();
			c.setId(Long.parseLong(request.getParameter("id")));
			c.setNomeCliente(request.getParameter("nome_cliente"));
			c.setCpf(request.getParameter("cpf"));
			c.setEndereco(request.getParameter("endereco"));
			c.setTelefone(request.getParameter("telefone"));

			
			DAOCliente dao = new DAOCliente(c);
			dao.atualizar();
			request.setAttribute("mensagem", "Atualizado"); 		
			request.getRequestDispatcher("/VisualizarCliente?id="+request.getParameter("id"))
			.forward(request,response);
			
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("mensagem","Erro ao Atualizar");
			request.getRequestDispatcher("/VisualizarCliente?id="+request.getParameter("id"))
			.forward(request,response);
		}
	}

}
