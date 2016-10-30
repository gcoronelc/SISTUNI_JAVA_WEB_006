<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EUREKA</title>
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<style type="text/css">
  #panchito{
    background-color: white;
    width: 400px;
    margin: 15px auto;
    padding: 10px;
    color: gray;
  }
</style>
</head>
<body>
  <div id="panchito">
    <img alt="" src="img/logo.gif"/>
    <h1>INICIO DE SESION</h1>
    
    <c:if test="${requestScope.error != mnull}">
      <p class="egcc_error">${requestScope.error}</p>
    </c:if>
    
    <form method="post" action="LogonIngresar">
    <table>
      <tr>
        <td rowspan="4">
          <img alt="" src="img/user_login.png">
        </td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        
      </tr>
      <tr>
        <td>Usuario</td>
        <td><input type="text" name="usuario"/></td>
      </tr>
      <tr>
        <td>Clave:</td>
        <td><input type="password" name="clave"/></td>
      </tr>
      <tr>
        <td colspan="2" style="text-align: center;;">
          <input type="submit" value="Ingresar">
        </td>
      </tr>
    </table>
    </form>
  </div>
</body>
</html>