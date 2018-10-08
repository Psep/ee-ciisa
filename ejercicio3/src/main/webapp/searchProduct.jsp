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
<title>Buscar - Ejercicio 3 - Ciisa</title>
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
			<form action="buscar.jsp" method="post">
				<div class="form-group">
					<h2>Buscar Producto</h2>
				</div>
				<c:if test="${errorMessage != null}">
					<div class="form-group">
						<div class="alert alert-danger">${errorMessage}</div>
					</div>
				</c:if>
				<c:if test="${infoMessage != null}">
					<div class="form-group">
						<div class="alert alert-info">${infoMessage}</div>
					</div>
				</c:if>
				<div class="row">
					<div>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<label class="input-group-text" for="tipoBusqueda"> Tipo
									de Búsqueda </label>
							</div>
							<select class="custom-select" id="tipoBusqueda"
								name="tipoBusqueda" required>
								<option value="porCodigo" selected>Código</option>
								<option value="porNombre">Nombre</option>
							</select>
						</div>
					</div>
					<div class="col">
						<input type="number" id="busqueda" class="form-control"
							name="busqueda" required>
					</div>
					<div class="col">
						<button type="submit" class="btn btn-outline-primary">Buscar</button>
					</div>
				</div>
				<c:if test="${busqueda != null}">
					<div id="tituloResultados" class="form-group">
						<h4>Resultados</h4>
					</div>
					<div id="resultados" class="table-responsive">
						<table class="table table-bordered table-hover table-sm">
							<thead>
								<tr>
									<th scope="col">Código</th>
									<th scope="col">Nombre</th>
									<th scope="col">Descripción</th>
									<th scope="col">Precio</th>
									<th scope="col">Proveedores</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${productos == null || productos.size() == 0}">
									<tr><td colspan="5">No se encontraron resultados para la búsqueda</td></tr>
								</c:if>
								<c:if test="${productos != null}">
									<c:forEach var="producto" items="${productos}">
										<tr>
											<td>${producto.idProducto}</td>
											<td>${producto.nombre}</td>
											<td>${producto.descripcion}</td>
											<td>${producto.precio}</td>
											<td>${producto.toStringProveedores()}</td>
										</tr>
									</c:forEach>
								</c:if>
							</tbody>
						</table>
					</div>
				</c:if>
			</form>
		</div>
		<footer>
			<div class="footer-copyright text-center py-3">
				<p>&copy; 2018 - Ejercicio 3</p>
			</div>
			<script src="assets/js/main.js"></script>
		</footer>
	</div>
</body>
</html>