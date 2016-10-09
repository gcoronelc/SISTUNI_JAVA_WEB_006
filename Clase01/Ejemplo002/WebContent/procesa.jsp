<%@page import="pe.egcc.app.service.VentaService"%>
<%@page import="pe.egcc.app.model.VentaModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- Scriptlet -->
<%
  // Datos
  double precio = Double.parseDouble(request.getParameter("precio"));
  int cant = Integer.parseInt(request.getParameter("cant"));
  VentaModel model = new VentaModel();
  model.setPrecio(precio);
  model.setCant(cant);
  
  // Proceso
  VentaService service = new VentaService();
  service.procesar(model);

%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>RESULTADO</h1>
  <p>Precio: <%= model.getPrecio() %></p>
  <p>Cantidad: <%= model.getCant() %></p>
  <p>Importe: <%= model.getImporte() %></p>
  <p>Impuesto: <%= model.getImpuesto() %></p>
  <p>Total: <%= model.getTotal() %></p>
  <a href="index.html">Retornar</a>
</body>
</html>