<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description"
	content="Simulador de Cotizaciones de Cursos en Ejercicio 2">
<meta name="keywords" content="ejercicio2, cursos, cotizacion, ciisa">
<meta name="author" content="Pablo Sepúlveda">
<link rel="icon" href="https://getbootstrap.com/favicon.ico">
<title>Ejercicio 2 - Ciisa</title>
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/main.css">
<script src="assets/js/jquery-3.3.1.slim.min.js"></script>
<script src="assets/js/popper.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
</head>
<body>
	<div
		class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
		<h5 class="my-0 mr-md-auto font-weight-normal">
			<a href="index.jsp" title="Simulador de Cotización para Capacitaciones">Simulador de Cotización para Capacitaciones</a>
		</h5>
		<nav class="my-2 my-md-0 mr-md-3">
			<a class="p-2 text-dark" href="index.jsp">Inicio</a>
        </nav>
	</div>
	
	<div class="container">
		<div class="row">
			<form action="simular.do" method="post">
				<div class="form-group">
					<label for="rut">RUT Cotizante</label>
					<input type="text" id="rut" class="form-control" name="rut" placeholder="XXXXXXXX-X" required>
				</div>
				<div class="form-group">
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<label class="input-group-text" for="capacitacion">Capacitación</label>
						</div>
						<select class="custom-select" id="capacitacion" name="capacitacion" required>
							<option value="" selected>Seleccione...</option>
							<c:forEach var="message" items="${cursoBean.cursos}">
								<option value="<c:out value="${message.valor}" />"><c:out value="${message.nombre}" /></option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="precio">Precio por persona</label>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text">$</span>
						</div>
						<input id="precio" type="text" class="form-control" value=""
							disabled>
					</div>
				</div>
				<div class="form-group">
					<label for="coffeeBreak">¿Coffee Break? ($1000 por persona)</label>
					<div class="input-group mb-3">
  						<div class="input-group-prepend">
    						<div class="input-group-text">
      							<input id="coffeeBreak" name="coffeeBreak" type="checkbox" value="true">
    						</div>
  						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="fIda">Fecha de Inicio</label>
					<input type="date" id="fIinicio" class="form-control" name="fIinicio" required>
				</div>
				<div class="form-group">
					<label for="cantidad">Cantidad de Asistentes</label>
					<input type="number" id="cantidad" class="form-control" name="cantidad" max="99" min="0" maxlength="2" required>
				</div>

				<button id="btnSimular" type="submit" class="btn btn-success">Simular</button>
			</form>
		</div>
		<footer>
			<script src="assets/js/main.js"></script>
		</footer>
	</div>
</body>
</html>