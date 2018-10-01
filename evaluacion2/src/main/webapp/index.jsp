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
			<form action="solicitar.do" method="post">
				<div class="form-group">
					<label for="rut">RUT Cliente</label>
					<input type="text" id="rut"
						class="form-control" name="rut" placeholder="XXXXXXXX-X" required>
				</div>
				<div class="form-group">
					<label for="nombre">Nombre del Cliente</label>
					<input type="text"
						id="nombre" class="form-control" name="nombre"
						placeholder="Pepito" required>
				</div>
				<div class="form-group">
					<label for="apellido">Apellido del Cliente</label>
					<input type="text"
						id="apellido" class="form-control" name="apellido"
						placeholder="Los Palotes" required>
				</div>
				<div class="form-group">
					<label for="telefonia">Plan Telefonía Hogar</label>
					<select class="custom-select" id="telefonia" name="telefonia">
						<option value="" selected>Seleccione...</option>
						<c:forEach var="tel" items="${telefoniaHogar.listTelefoniaHogar}">
							<option value="<c:out value="${tel.id}" />"><c:out value="${tel.nombre}" /></option>
						</c:forEach>
					</select>
				</div>
				<div class="table-responsive">
					<table class="table table-bordered table-hover table-sm">
						<thead>
							<tr>
								<th scope="col">Detalle</th>
								<th scope="col">Minutos</th>
								<th scope="col">Valor</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="tel" items="${telefoniaHogar.listTelefoniaHogar}">
								<tr>
									<th scope="row"><c:out value="${tel.nombre}" /></th>
									<td>
										<c:choose>
											<c:when test="${tel.esIlimitado}">
												∞
											</c:when>
											<c:otherwise>
												<c:out value="${tel.minutos}" />
											</c:otherwise>
										</c:choose>
									</td>
									<td>$<c:out value="${tel.valor}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="form-group">
					<label for="television">Plan Televisión Hogar</label>
					<select class="custom-select" id="television" name="television">
						<option value="" selected>Seleccione...</option>
						<c:forEach var="tv" items="${televisionHogar.listTelevisionHogar}">
							<option value="<c:out value="${tv.id}" />"><c:out value="${tv.nombre}" /></option>
						</c:forEach>
					</select>
				</div>
				<div class="table-responsive">
					<table class="table table-bordered table-hover table-sm">
						<thead>
							<tr>
								<th scope="col">Detalle</th>
								<th scope="col">Canales</th>
								<th scope="col">HD</th>
								<th scope="col">Canales Premium</th>
								<th scope="col">Valor</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="tv" items="${televisionHogar.listTelevisionHogar}">
								<tr>
									<th scope="row"><c:out value="${tv.nombre}" /></th>
									<td><c:out value="${tv.cantCanales}" /></td>
									<td>
										<c:choose>
											<c:when test="${tv.esHD}">
												Sí
											</c:when>
											<c:otherwise>
												No
											</c:otherwise>
										</c:choose>
									</td>
									<td>
										<c:choose>
											<c:when test="${tv.tienePremium}">
												Sí
											</c:when>
											<c:otherwise>
												No
											</c:otherwise>
										</c:choose>
									</td>
									<td>$<c:out value="${tv.valor}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table> 
				</div>

				<div class="form-group">
					<label for="instalaciones">Num. de Instalaciones para TV (después de la 3ra, tiene un costo de $5000 mensual c/u)</label>
					<input type="number" id="instalaciones" class="form-control" name="instalaciones"
						max="10" min="0" maxlength="2" value="0" disabled>
				</div>

				<div class="form-group">
					<label for="fecInstalacion">Fecha de Instalación</label>
					<input type="date" id="fecInstalacion" class="form-control" name="fecInstalacion" required>
				</div>

				<button id="btnSolicitar" type="submit" class="btn btn-success">Solicitar</button>
			</form>
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