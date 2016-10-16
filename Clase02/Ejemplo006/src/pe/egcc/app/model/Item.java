package pe.egcc.app.model;

public class Item {

  private String nombre;
  private double precio;
  private int cant;
  private double subtotal;

  public Item() {
  }

  public Item(String nombre, double precio, int cant, double subtotal) {
    super();
    this.nombre = nombre;
    this.precio = precio;
    this.cant = cant;
    this.subtotal = subtotal;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public int getCant() {
    return cant;
  }

  public void setCant(int cant) {
    this.cant = cant;
  }

  public double getSubtotal() {
    return subtotal;
  }

  public void setSubtotal(double subtotal) {
    this.subtotal = subtotal;
  }

}
