<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Mantenedor de Productos">
<meta name="keywords" content="ejercicio3, productos, ciisa">
<meta name="author" content="Pablo Sepúlveda">
<link rel="icon" href="https://getbootstrap.com/favicon.ico">
<title>Agregar - Ejercicio 3 - Ciisa</title>
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
			<a href="index.jsp" title="Mantenedor de Productos">Mantenedor de
				Productos</a>
		</h5>
		<nav class="my-2 my-md-0 mr-md-3">
			<a class="p-2 text-dark" href="index.jsp">Agregar</a> <a
				class="p-2 text-dark" href="buscar.jsp">Buscar</a>
		</nav>
	</div>
	<div class="container">
		<div class="row">
			<form action="index.jsp" method="post">
				<div class="form-group">
					<h2>Agregar Producto</h2>
				</div>
				<c:if test="${errorMessage != null}">
					<div class="form-group">
						<div class="alert alert-danger">
							${errorMessage}
						</div>
					</div>
				</c:if>
				<c:if test="${sucessMessage != null}">
					<div class="form-group">
						<div class="alert alert-success">
							${sucessMessage}
						</div>
					</div>
				</c:if>
				<div class="form-group">
					<label for="codigo">Código del Producto</label> <input type="number"
						id="codigo" class="form-control" name="codigo" value="${codigo}"
						placeholder="10" max="99999" min="0" maxlength="5" size="5" required>
				</div>
				<div class="form-group">
					<label for="nombre">Nombre del Producto</label> <input type="text"
						id="nombre" class="form-control" name="nombre" value="${nombre}"
						placeholder="Producto Uno" required>
				</div>
				<div class="form-group">
					<label for="descripcion">Descripción</label> <input type="text"
						id="descripcion" class="form-control" name="descripcion"
						value="${descripcion}" placeholder="Producto para limpieza del hogar" required>
				</div>
				<div class="form-group">
					<label for="precio">Precio</label>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text">$</span>
						</div>
						<input type="number" id="precio" class="form-control"
							name="precio" max="99999" min="0" maxlength="5" size="5" placeholder="1990"
							value="${precio}" required>
					</div>
				</div>
				<div class="form-group">
					<label for="proveedores">Proveedores</label>
					<select class="custom-select" id="proveedores" name="proveedores" multiple required>
						<c:forEach var="proveedor" items="${proveedores}">
							<option value="${proveedor.idProveedor}">${proveedor.nombre}</option>
						</c:forEach>
					</select>
				</div>
				<button id="btnAgregar" type="submit" class="btn btn-success">Agregar</button>
			</form>
		</div>
		<footer>
			<div class="footer-copyright text-center py-3">
				<p>&copy; 2018 - Ejercicio 3</p>
			</div>
		</footer>
	</div>
</body>
</html>