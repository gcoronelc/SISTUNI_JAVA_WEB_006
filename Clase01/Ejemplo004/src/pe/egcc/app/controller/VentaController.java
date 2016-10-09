package pe.egcc.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.egcc.app.model.VentaModel;
import pe.egcc.app.service.VentaService;

@WebServlet("/VentaController")
public class VentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Datos
	  VentaModel model = new VentaModel();
	  model.setPrecio(Double.parseDouble(request.getParameter("precio")));
	  model.setCant(Integer.parseInt(request.getParameter("cant")));
	  // Proceso
	  VentaService service = new VentaService();
	  service.procesar(model);
	  // Forward
	  request.setAttribute("model", model);
	  RequestDispatcher rd;
	  rd = request.getRequestDispatcher("resultado.jsp");
	  rd.forward(request, response);
	}

}
