<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<h1>CARRITO</h1>
<p>Cliente: ${sessionScope.carrito.cliente}</p>
<p>
<a href="agregar.jsp">Agregar Item</a>
<a href="verCarrito.jsp">Ver Carrito</a>
</p>