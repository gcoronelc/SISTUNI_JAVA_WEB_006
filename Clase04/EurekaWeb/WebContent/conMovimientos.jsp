<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CONSULTA DE MOVIMIENTOS</title>
</head>
<body>
	<form id="form1">
		<h1>CONSULTA DE MOVIMIENTOS</h1>
		<fieldset>
			<legend>Datos</legend>
			<label>Cuenta:</label> <input type="text" name="cuenta" /> <input
				type="button" id="btnConsultar" value="Consultar" />
		</fieldset>
	</form>
	<div id="divMovs">
		<h2>RESULTADO</h2>
		<p>Cuenta: <span id="cuenta"></span> </p>
		<table class="egcc_table" style="width: 100%;">
			<thead>
				<th>NRO.MOV.</th>
				<th>FECHA</th>
				<th>TIPO</th>
				<th>IMPORTE</th>
			</thead>
			<tbody id="dataTable">
			</tbody>
		</table>
	</div>
	<script type="text/javascript">
		$("#btnConsultar").click(function() {
			var data = $("#form1").serialize();
			$.post("TrearMovimientos", data, function(objJson) {
				if(objJson.code == 1){
					var arreglo = $.parseJSON(objJson.text);
					$("#cuenta").text(arreglo[0].CUENCODIGO);
					$("#dataTable").empty();
					$.each( arreglo, function( i, obj ){
						var fila = "<tr>";
						fila += "<td>" + obj.MOVINUMERO + "</td>";
						fila += "<td>" + obj.MOVIFECHA + "</td>";
						fila += "<td>" + obj.TIPONOMBRE + "</td>";
						fila += "<td>" + obj.MOVIIMPORTE + "</td>";
						fila += "</tr>";
						$("#dataTable").append(fila);
					});
				} else {
					alert(objJson.text);
				}
			});
		});
	</script>
</body>
</html>