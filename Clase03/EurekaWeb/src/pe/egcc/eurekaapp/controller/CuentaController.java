package pe.egcc.eurekaapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.egcc.eurekaapp.model.Empleado;
import pe.egcc.eurekaapp.service.espec.CuentaServiceEspec;
import pe.egcc.eurekaapp.service.impl.CuentaService;

@WebServlet({ "/CuentaRetiro", "/CuentaApertura", "/CuentaDeposito", "/CuentaTransferencia" })
public class CuentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch (request.getServletPath()) {
    case "/CuentaRetiro":
      cuentaRetiro(request,response);
      break;
    }
	}

  private void cuentaRetiro(HttpServletRequest request, 
      HttpServletResponse response) throws IOException {
    String salida;
    try {
      // Data
      String cuenta = request.getParameter("cuenta");
      String clave = request.getParameter("clave");
      double importe = Double.parseDouble(request.getParameter("importe"));
      // Empleado
      Empleado bean = (Empleado) Session.get(request, "usuario");
      // Proceso
      CuentaServiceEspec service = new CuentaService();
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
