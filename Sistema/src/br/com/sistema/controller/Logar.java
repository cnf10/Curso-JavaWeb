package br.com.sistema.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.sistema.model.DAOUsuario;
import br.com.sistema.model.Usuario;

/**
 * Servlet implementation class Logar
 */
@WebServlet("/Logar")
public class Logar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Usuario u = new Usuario();
			u.setUsuario(request.getParameter("usuario"));
			u.setSenha(request.getParameter("senha"));
			
			DAOUsuario dao = new DAOUsuario(u);
			u = dao.logar();
			
			if(u.getId()==0)
				throw new Exception("Usuário/Senha inválidos");
			
			HttpSession sessionCarinho = request.getSession(true);
			sessionCarinho.setAttribute("usuario",u);
			
			request.getRequestDispatcher("lista-funcionario.jsp").forward(request,response);
			
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("mensagem", e.getMessage());
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}
		
}

