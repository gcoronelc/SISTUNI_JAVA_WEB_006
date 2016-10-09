package pe.egcc.app.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.app.service.espec.MateServEspec;
import pe.egcc.app.service.impl.MateServiceImpl;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
@WebServlet(name = "SumarServlet", urlPatterns = {"/SumarServlet"})
public class SumarServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request,
          HttpServletResponse response) throws ServletException, IOException {

    // Datos
    int n1 = Integer.parseInt(request.getParameter("num1"));
    int n2 = Integer.parseInt(request.getParameter("num2"));
    // Proceso
    MateServEspec service = new MateServiceImpl();
    int su = service.sumar(n1, n2);
    // Reporte
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>SUMAR</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>SUMAR</h1>");
    out.println("<p>Número 1: " + n1 + "</p>");
    out.println("<p>Número 2: " + n2 + "</p>");
    out.println("<p>Suma: " + su + "</p>");
    out.println("<a href='index.html'>Retornar</a>");
    out.println("</body>");
    out.println("</html>");
  } // Fin de service

} // Fin de SumarServlet
