package pe.egcc.app.model;

import java.util.ArrayList;
import java.util.List;

public class Carrito {

  private String cliente;
  private double importe;
  private double impuesto;
  private double total;
  private List<Item> items;
  
  public Carrito() {
    items = new ArrayList<>();
  }

  public String getCliente() {
    return cliente;
  }

  public void setCliente(String cliente) {
    this.cliente = cliente;
  }

  public double getImporte() {
    return importe;
  }

  public void setImporte(double importe) {
    this.importe = importe;
  }

  public double getImpuesto() {
    return impuesto;
  }

  public void setImpuesto(double impuesto) {
    this.impuesto = impuesto;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }
  
  public void agregarItem(Item item){
    double subtotal = item.getPrecio() * item.getCant();
    item.setSubtotal(subtotal);
    items.add(item);
    actualizarTotales();
  }

  public void actualizarTotales() {
    total = 0.0;
    items.stream().forEach(i -> total += i.getSubtotal());
    importe = total / 1.18;
    impuesto = total - importe;
  }
  
  
}
