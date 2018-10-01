<%@page import="cl.ciisa.ee.evaluacion2.model.TelefoniaHogar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Solicitud de Planes">
<meta name="keywords"
	content="evaluacion2, cursos, telefonia, television, ciisa">
<meta name="author" content="Pablo Sepúlveda">
<link rel="icon" href="https://getbootstrap.com/favicon.ico">
<title>Evaluación 2 - Ciisa</title>
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
			<a href="index.jsp" title="Solicitud de Planes">Solicitud de
				Planes</a>
		</h5>
		<nav class="my-2 my-md-0 mr-md-3">
			<a class="p-2 text-dark" href="index.jsp">Inicio</a>
		</nav>
	</div>

	<div class="container">
		<div class="row">
			<div class="col">
				<div class="alert alert-success">
					<strong>${mensaje}</strong>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<a href="index.jsp" class="btn btn-primary">Volver</a>
			</div>
		</div>
		<footer>
			<div class="footer-copyright text-center py-3">
				<p>&copy; 2018 - Evaluación 2</p>
			</div>
			<script src="assets/js/main.js"></script>
		</footer>
	</div>
</body>
</html>