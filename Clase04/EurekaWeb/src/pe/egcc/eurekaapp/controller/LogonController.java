package pe.egcc.eurekaapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.egcc.eurekaapp.model.Empleado;
import pe.egcc.eurekaapp.service.espec.EmpleadoServiceEspec;
import pe.egcc.eurekaapp.service.impl.EmpleadoServiceImpl;

@WebServlet({ "/LogonIngresar", "/LogonSalir" })
public class LogonController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    switch (request.getServletPath()) {
    case "/LogonIngresar":
      ingresar(request, response);
      break;
    case "/LogonSalir":
      salir(request, response);
      break;
    }

  } // Fin de service

  private void ingresar(HttpServletRequest request, 
      HttpServletResponse response) 
          throws ServletException, IOException {
    String destino;
    try {
      // Datos
      String usuario = request.getParameter("usuario");
      String clave = request.getParameter("clave");
      // Proceso
      EmpleadoServiceEspec service = new EmpleadoServiceImpl();
      Empleado bean = service.validar(usuario, clave);
      if(bean == null){
        throw new RuntimeException("Datos incorrectos");
      }
      Session.put(request, "usuario", bean);
      destino = "main.jsp";
    } catch (Exception e) {
      destino = "index.jsp";
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    CtrlUtil.forward(request,response,destino);
  } // Fin de ingresar

  private void salir(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    request.getSession().invalidate();
    CtrlUtil.forward(request, response, "index.jsp");
  } // Fin de salir

}
