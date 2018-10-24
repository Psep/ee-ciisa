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
<title>Login - Evaluación 3 - Ciisa</title>
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/main.css">
<script src="assets/js/jquery-3.3.1.slim.min.js"></script>
<script src="assets/js/popper.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/main.js"></script>
</head>
<body>
	<div
		class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
		<h5 class="my-0 mr-md-auto font-weight-normal">
			<a href="index.jsp" title="Evaluación 3">Evaluación 3</a>
		</h5>
	</div>
	<div class="container">
		<div class="row d-flex justify-content-center">
			<form action="login.jsp" method="post">
				<c:if test="${errorMessage != null}">
					<div class="form-group">
						<div class="alert alert-danger">${errorMessage}</div>
					</div>
				</c:if>

				<div class="card" style="width: 18rem;">
					<div class="card-body">
						<h5 class="card-title d-flex justify-content-center">Ingreso a Evaluación 3</h5>
						<h6 class="card-subtitle mb-2 text-muted">Debe validarse para revisar el contenido</h6>
						<div class="form-group">
							<label for="username">Nombre de Usuario</label>
							<input type="text" class="form-control" id="username" name="username" placeholder="Ingrese su nombre de usuario" required="required">
						</div>
						<div class="form-group">
							<label for="passwd">Contraseña</label>
							<input type="password" class="form-control" id="passwd" name="passwd" placeholder="Ingrese su contraseña" required="required" size="4">
						</div>
						<button id="btnLogin" type="submit" class="btn btn-primary">Ingresar</button>
					</div>
				</div>
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