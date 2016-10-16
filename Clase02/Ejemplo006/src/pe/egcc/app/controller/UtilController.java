package pe.egcc.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.egcc.app.model.Carrito;

public final class UtilController {

  private UtilController() {
  }
  
  public static void forward(HttpServletRequest request,
      HttpServletResponse response, String destino) 
          throws ServletException, IOException{
    RequestDispatcher rd;
    rd = request.getRequestDispatcher(destino);
    rd.forward(request, response);
  }
  
  public static Carrito getCarrito(HttpServletRequest request) {
    HttpSession session = request.getSession();
    Carrito carrito = (Carrito) session.getAttribute("carrito");
    return carrito;
  }

  public static void emptyCarrito(HttpServletRequest request) {
    HttpSession session = request.getSession();
    Carrito carrito = (Carrito) session.getAttribute("carrito");
    carrito.getItems().clear();
    carrito.actualizarTotales();
  }

  
  
}
