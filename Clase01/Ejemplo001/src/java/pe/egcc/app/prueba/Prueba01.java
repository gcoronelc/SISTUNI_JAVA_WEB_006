package pe.egcc.app.prueba;

import pe.egcc.app.service.espec.MateServEspec;
import pe.egcc.app.service.impl.MateServiceImpl;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public class Prueba01 {
  
  public static void main(String[] args) {
    // Datos
    int n1 = 56;
    int n2 = 5;
    // Proceso
    MateServEspec service = new MateServiceImpl();
    int s = service.sumar(n1, n2);
    // Reporte
    System.out.println(n1 + " + " + n2 + " = " + s);
  }
  
}
