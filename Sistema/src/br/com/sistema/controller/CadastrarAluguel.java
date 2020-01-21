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
 * Servlet implementation class CadastrarAluguel
 */
@WebServlet("/CadastrarAluguel")
public class CadastrarAluguel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try{
			
			Aluguel a = new Aluguel();
			a.setIdAutomovel(Long.parseLong((request.getParameter("id_automovel"))));
			a.setIdCliente(Long.parseLong((request.getParameter("id_cliente"))));
			a.setIdFuncionario(Long.parseLong((request.getParameter("id_funcionario"))));
			a.setValor(Double.parseDouble((request.getParameter("valor"))));

			DAOAluguel dao = new DAOAluguel(a);
			dao.cadastrar();
			request.setAttribute("mensagem", "cadastrado"); 		
		}catch(Exception e){
			e.printStackTrace();
				request.setAttribute("mensagem","Erro ao Cadastrar");
			}
				request.getRequestDispatcher("cadastro-aluguel.jsp").forward(request,response);
	}

}
