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
 * Servlet implementation class CadastrarCliente
 */
@WebServlet("/CadastrarCliente")
public class CadastrarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try{
			
			Cliente c = new Cliente();
			c.setNomeCliente(request.getParameter("nome_cliente"));
			c.setCpf(request.getParameter("cpf"));
			c.setEndereco(request.getParameter("endereco"));
			c.setTelefone(request.getParameter("telefone"));

			DAOCliente dao = new DAOCliente(c);
			dao.cadastrar();
			request.setAttribute("mensagem", "cadastrado"); 		
		}catch(Exception e){
			e.printStackTrace();
				request.setAttribute("mensagem","Erro ao Cadastrar");
			}
				request.getRequestDispatcher("cadastro-cliente.jsp").forward(request,response);
			}
	}

