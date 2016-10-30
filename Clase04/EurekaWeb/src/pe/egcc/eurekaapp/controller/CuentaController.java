package pe.egcc.eurekaapp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.egcc.eurekaapp.model.Empleado;
import pe.egcc.eurekaapp.model.JsonModel;
import pe.egcc.eurekaapp.service.espec.CuentaServiceEspec;
import pe.egcc.eurekaapp.service.impl.CuentaServiceImpl;

@WebServlet({ "/CuentaRetiro", "/CuentaApertura", 
  "/CuentaDeposito", "/CuentaTransferencia", 
  "/TrearMovimientos" })
public class CuentaController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    switch (request.getServletPath()) {
    case "/CuentaRetiro":
      cuentaRetiro(request, response);
      break;
    case "/TrearMovimientos":
      System.err.println("Que pasa");
      trearMovimientos(request, response);
      break;
    }
  }

  private void trearMovimientos(HttpServletRequest request,
      HttpServletResponse response) throws IOException {
    JsonModel model = new JsonModel();
    try {
      // Dato
      String cuenta = request.getParameter("cuenta");
      // Proceso
      CuentaServiceEspec service = new CuentaServiceImpl();
      List<Map<String, ?>> lista = service.getMovimientos(cuenta);
      if(lista.isEmpty()){
        throw new Exception("Cuenta no existe.");
      }
      model.setCode(1);
      Gson gson = new Gson();
      model.setText(gson.toJson(lista));
    } catch (Exception e) {
      model.setCode(-1);
      model.setText(e.getMessage());
    }
   
    // Reportendo JsonModel
    System.err.println("Que pasa.");
    CtrlUtil.sendJson(response, model);
  }

  private void cuentaRetiro(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String salida;
    try {
      // Data
      String cuenta = request.getParameter("cuenta");
      String clave = request.getParameter("clave");
      double importe = Double.parseDouble(request.getParameter("importe"));
      // Empleado
      Empleado bean = (Empleado) Session.get(request, "usuario");
      // Proceso
      CuentaServiceEspec service = new CuentaServiceImpl();
      service.procRetiro(cuenta, importe, clave, bean.getCodigo());
      salida = "1";
    } catch (Exception e) {
      e.printStackTrace();
      salida = "0";
    }
    // Salida
    response.setContentType("text/plain");
    ServletOutputStream out = response.getOutputStream();
    out.println(salida);
    out.close();
    out.flush();
  }

}
