<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<jsp:useBean id="model" class="pe.egcc.app.model.VentaModel"/>
<jsp:setProperty name="model" property="precio" param="precio"/>
<jsp:setProperty name="model" property="cant" param="cant"/>

<jsp:useBean id="service" class="pe.egcc.app.service.VentaService"/>

<% service.procesar(model); %>

        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>RESULTADO</h1>
  <p>Precio: ${model.precio}</p>
  <p>Cantidad: ${model.cant}</p>
  <p>Importe: ${model.importe}</p>
  <p>Impuesto: ${model.impuesto}</p>
  <p>Total: ${model.total}</p>
  <a href="index.html">Retornar</a>
</body>
</html>