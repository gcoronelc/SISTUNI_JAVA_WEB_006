package pe.egcc.eurekaapp.prueba;

import pe.egcc.eurekaapp.service.impl.CuentaService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronec@gmail.com
 */
public class Prueba02 {
  
  public static void main(String[] args) {
    try {
      CuentaService service;
      service = new CuentaService();
      service.procRetiro("00100001", 50000, "123456", "0004");
      System.out.println("Ok");
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
