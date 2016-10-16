<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CARRITO</title>
</head>
<body>
  <jsp:include page="cabecera.jsp"/>
  <h2>AGREGAR ITEM</h2>
  
  <c:if test="${requestScope.error != null }">
    <p style="color:red;">${requestScope.error}</p>
  </c:if>
  
  <form method="post" action="CarritoAgregar">
    <table>
      <tr>
        <td>Producto:</td>
        <td><input type="text" name="producto" value="${requestScope.item.nombre}"/></td>
      </tr>
      <tr>
        <td>Precio:</td>
        <td><input type="text" name="precio" value="${requestScope.item.precio}"/></td>
      </tr>
      <tr>
        <td>Cantidad:</td>
        <td><input type="text" name="cant" value="${requestScope.item.cant}"/></td>
      </tr>    
      <tr>
        <td><input type="submit" value="Procesar"/></td>
      </tr>    
    </table>
    
  </form>
</body>
</html>