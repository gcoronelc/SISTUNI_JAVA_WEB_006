package pe.egcc.eurekaapp.prueba;

import java.util.Map;

import pe.egcc.eurekaapp.service.espec.CuentaServiceEspec;
import pe.egcc.eurekaapp.service.impl.CuentaServiceImpl;

public class Prueba05 {

  public static void main(String[] args) {
    try {
      CuentaServiceEspec service = new CuentaServiceImpl();
      for (Map<String, ?> r : service.getMovimientos("00100002")) {
        String texto = r.get("MOVINUMERO") + " - " + r.get("MOVIFECHA") + " - " + r.get("TIPONOMBRE") + " - "
            + r.get("MOVIIMPORTE");
        System.out.println(texto);
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }

}
