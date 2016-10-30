package pe.egcc.eurekaapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.egcc.eurekaapp.model.JsonModel;

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
  
   
  public static void sendJson(HttpServletResponse response, 
      JsonModel model) throws IOException {
    Gson gson = new Gson();
    String textoJson = gson.toJson(model);
    response.setContentType("application/json");
    //response.setContentType("text/plain");
    PrintWriter out = response.getWriter();
    out.print(textoJson);
    out.flush();
  }
}
