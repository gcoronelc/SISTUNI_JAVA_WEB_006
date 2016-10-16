package pe.egcc.eurekaapp.service.espec;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronec@gmail.com
 */
public interface CuentaServiceEspec {

  void procRetiro(String cuenta, double importe,
          String clave, String codEmp);

}
