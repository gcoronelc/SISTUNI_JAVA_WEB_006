package pe.egcc.app.prueba;

import pe.egcc.app.model.VentaModel;
import pe.egcc.app.service.VentaService;

public class Prueba01 {

  public static void main(String[] args) {
    // Dato
    VentaModel model = new VentaModel();
    model.setPrecio(578.37);
    model.setCant(5);
    // Proceso
    VentaService service = new VentaService();
    service.procesar(model);
    // Reporte
    System.out.println("Importe: " + model.getImporte());
    System.out.println("Impuesto: " + model.getImpuesto());
    System.out.println("Total: " + model.getTotal());
  }
}
