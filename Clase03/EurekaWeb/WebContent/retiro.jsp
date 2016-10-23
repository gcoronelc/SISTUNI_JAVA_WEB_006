<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RETIRO</title>
</head>
<body>
  <h1>PROCESO RETIRO</h1>
  
  <form id="form1">
  <fieldset>
    <legend>Datos de la operación</legend>
    
    <label>Cuenta:</label>
    <input type="text" name="cuenta" id="cuenta"/> <br/>
    
    <label>Importe:</label>
    <input type="text" name="importe" id="importe" /> <br/>
    
    <label>Clave:</label>
    <input type="password" name="clave" id="clave" /> <br/>
    
    <input type="button" id="btnProcesar" value="Procesar">
    
  </fieldset>
  </form>
  
  <script type="text/javascript">
  
  $("#btnProcesar").click(function(){
	  
	  var datos = $("#form1").serialize();
	  
	  $.post("CuentaRetiro",datos,function(rpta){
		  if( parseInt(rpta) == 1){
			  alert("Proceso ejecutado correctamente.");
        $("#cuenta").val("");
        $("#importe").val("");
        $("#clave").val("");
		  } else {
			  alert("Error en el proceso.");
		  }
	  });
	  
  });
  
  </script>
  
</body>
</html>