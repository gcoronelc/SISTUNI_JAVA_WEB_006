package pe.egcc.eurekaapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class CtrlUtil {

  
  private CtrlUtil() {
  }

  public static void forward(HttpServletRequest request, 
      HttpServletResponse response, String destino) 
          throws ServletException, IOException {
    RequestDispatcher rd;
    rd = request.getRequestDispatcher(destino);
    rd.forward(request, response);
  }
  
   
  
}
