<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/tabla.css">
<title>CARRITO</title>
</head>
<body>
  <jsp:include page="cabecera.jsp"/>
  <h2>Datos Generales</h2>
  <table>
    <tr>
      <td width="100px">Cliente:</td>
      <td>${sessionScope.carrito.cliente}</td>
    </tr>
    <tr>
      <td>Importe:</td>
      <td>${sessionScope.carrito.importe}</td>
    </tr>
    <tr>
      <td>Impuesto:</td>
      <td>${sessionScope.carrito.impuesto}</td>
    </tr>
    <tr>
      <td>Total:</td>
      <td>${sessionScope.carrito.total}</td>
    </tr>
  </table>
  <h2>Items</h2>
  <table class="tftable">
    <thead>
      <tr>
	      <th>NOMBRE</th>
	      <th>PRECIO</th>
	      <th>CANTIDAD</th>
	      <th>SUBTOTAL</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${sessionScope.carrito.items}" var="r">
        <tr>
          <td>${r.nombre}</td>
          <td>${r.precio}</td>
          <td>${r.cant}</td>
          <td>${r.subtotal}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
  <a href="CarritoProcesar">Procesar</a>
</body>
</html>