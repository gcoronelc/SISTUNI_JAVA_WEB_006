package pe.egcc.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.egcc.app.model.Carrito;
import pe.egcc.app.model.Item;

@WebServlet({ "/CarritoInit", "/CarritoCliente", 
  "/CarritoAgregar","/CarritoProcesar" })
public class CarritoController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    switch (request.getServletPath()) {
    case "/CarritoInit":
      carritoInit(request, response);
      break;
    case "/CarritoCliente":
      carritoCliente(request, response);
      break;
    case "/CarritoAgregar":
      carritoAgregar(request, response);
      break;
    case "/CarritoProcesar":
      carritoProcesar(request, response);
      break;

    }

  }

  private void carritoProcesar(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    UtilController.emptyCarrito(request);
    request.setAttribute("mensaje", "Gracias por su compra.");
    UtilController.forward(request, response, "main.jsp");
  }

  private void carritoAgregar(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    String destino;
    Item item = new Item(); 
    try {
      // Datos
       item.setNombre(request.getParameter("producto"));
      item.setPrecio(Double.parseDouble(request.getParameter("precio")));
      item.setCant(Integer.parseInt(request.getParameter("cant")));
      // Proceso
      Carrito carrito = UtilController.getCarrito(request);
      carrito.agregarItem(item);
      destino = "verCarrito.jsp";
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
      request.setAttribute("item", item);
      destino = "agregar.jsp";
    }
    // Forward
    UtilController.forward(request, response, destino);
  }

  private void carritoCliente(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    // Dato
    String cliente = request.getParameter("cliente");
    // Proceso
    Carrito carrito = UtilController.getCarrito(request);
    carrito.setCliente(cliente);
    // Forward
    UtilController.forward(request, response, "main.jsp");
  }

  private void carritoInit(HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
    Carrito carrito = UtilController.getCarrito(request);
    carrito.setCliente("NONE");
    UtilController.forward(request, response, "index.jsp");
  }

}
