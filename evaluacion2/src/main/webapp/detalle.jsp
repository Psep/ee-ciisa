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
		<form action="pagar.do" method="post">
			<div class="row">
				<div class="col">
					<label for="nombre">RUT del Cliente</label> <input type="text"
						class="form-control" value="${solicitudIngresada.cliente.rut}"
						readonly="readonly">
				</div>
			</div>

			<div class="row">
				<div class="col">
					<label for="nombre">Nombre del Cliente</label> <input type="text"
						class="form-control" value="${solicitudIngresada.cliente.nombre}"
						readonly="readonly">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="apellido">Apellido del Cliente</label> <input
						type="text" class="form-control"
						value="${solicitudIngresada.cliente.apellido}" readonly="readonly">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="fecInstalacion">Fecha de Instalación</label> <input
						type="text" class="form-control"
						value="${solicitudIngresada.fechaInstalacion}" readonly="readonly">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="detalle">Detalle de Facturación</label>
					<div id="detalle" class="table-responsive">
						<table class="table table-bordered table-hover table-sm">
							<thead>
								<tr>
									<th scope="col">Plan</th>
									<th scope="col">Detalle</th>
									<th scope="col">Valor</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${solicitudIngresada.telefoniaHogar != null}">
									<tr>
										<td>Telefonía Hogar:
											${solicitudIngresada.telefoniaHogar.nombre}</td>
										<td><c:choose>
												<c:when
													test="${solicitudIngresada.telefoniaHogar.esIlimitado}">∞</c:when>
												<c:otherwise>
													<c:out value="${solicitudIngresada.telefoniaHogar.minutos}" />
												</c:otherwise>
											</c:choose> minutos</td>
										<td>${solicitudIngresada.telefoniaHogar.valor}</td>
									</tr>
								</c:if>
								<c:if test="${solicitudIngresada.televisionHogar != null}">
									<tr>
										<td>Televisión Hogar:
											${solicitudIngresada.televisionHogar.nombre}</td>
										<td>${solicitudIngresada.televisionHogar.cantCanales}
											canales, <c:choose>
												<c:when test="${solicitudIngresada.televisionHogar.esHD}">
												incluye HD, 
											</c:when>
												<c:otherwise>
												no incluye HD, 
											</c:otherwise>
											</c:choose> <c:choose>
												<c:when
													test="${solicitudIngresada.televisionHogar.tienePremium}">
												incluye canales premium
											</c:when>
												<c:otherwise>
												no incluye canales premium
											</c:otherwise>
											</c:choose>
										</td>
										<td>${solicitudIngresada.televisionHogar.valor}</td>
									</tr>
								</c:if>
								<tr>
									<td>Instalaciones TV</td>
									<td>${solicitudIngresada.cantInstTv}solicitadas</td>
									<td>${solicitudIngresada.adicionalInstalacion}</td>
								</tr>
								<tr>
									<th scope="row" colspan="2">Total</th>
									<td>${solicitudIngresada.total}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<button id="btnPagar" type="submit" class="btn btn-success">Pagar</button>
				</div>
			</div>
		</form>

		<footer>
			<div class="footer-copyright text-center py-3">
				<p>&copy; 2018 - Evaluación 2</p>
			</div>
			<script src="assets/js/main.js"></script>
		</footer>
	</div>
</body>
</html>