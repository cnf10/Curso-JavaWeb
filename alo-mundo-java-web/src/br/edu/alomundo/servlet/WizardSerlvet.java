package br.edu.alomundo.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WizardSerlvet
 */
@WebServlet("/wizard")
public class WizardSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		request.setAttribute("data", dateFormat.format(new Date()));
//		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/servlet-resultado.jsp");
//		dispatcher.forward(request, response);
		response.sendRedirect("jsp/servlet-resultado.jsp");
	}

}
