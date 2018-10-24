<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Login - Evaluación 3">
<meta name="keywords" content="evaluacion3, sessions, ciisa">
<meta name="author" content="Pablo Sepúlveda">
<link rel="icon" href="https://getbootstrap.com/favicon.ico">
<title>Evaluación 3 - Ciisa</title>
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
			<a href="index.jsp" title="Evaluación 3">Evaluación 3</a>
		</h5>
	</div>

	<div class="container">
		<div class="row">
			<form action="login.jsp" method="post">
				<div class="form-group">
					<div class="alert alert-success">¡Bienvenido!</div>
				</div>
				<h1>Datos del Usuario</h1>
				<div class="form-group">
					<label for="rut">RUT</label>
					<input id="rut" type="text" class="form-control" value="${usuario.persona.rut}-${usuario.persona.dv}" readonly="readonly">
				</div>
				<div class="form-group">
					<label for="nombre">Nombre</label>
					<input id="nombre" type="text" class="form-control" value="${usuario.persona.nombre}" readonly="readonly">
				</div>
				<div class="form-group">
					<label for="apellidos">Apellidos</label>
					<input id="apellidos" type="text" class="form-control" value="${usuario.persona.apellidos}" readonly="readonly">
				</div>
				
				<button id="btnLogout" name="btnLogout" type="submit" class="btn btn-outline-secondary">Salir</button>
			</form>
		</div>
		<footer>
			<div class="footer-copyright text-center py-3">
				<p>&copy; 2018 - Evaluación 3</p>
			</div>
		</footer>
	</div>
</body>
</html>