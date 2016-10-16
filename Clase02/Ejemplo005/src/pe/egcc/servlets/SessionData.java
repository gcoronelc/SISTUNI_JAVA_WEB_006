package pe.egcc.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionData")
public class SessionData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	  // Datos
	  String nombre = request.getParameter("nombre");

	  // Proceso
	  HttpSession session = request.getSession();
	  session.setAttribute("nombre", nombre);
	  
	  // forward
	  RequestDispatcher rd;
	  rd = request.getRequestDispatcher("destino.jsp");
	  rd.forward(request, response);
	
	}

}
