<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Darío Vera García">
<title>Contact Manager</title>

<!-- Bootstrap CSS 5.1.3-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<style>
body{
background-image: url("https://www.gastosdeviaje.mx/wp-content/uploads/2021/10/18.jpg");
}
</style>


</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">DATABASE</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
        <a class="nav-link active" aria-current="page" href="#">Home</a>
        <a class="nav-link" href="#">Registro de Clientes</a>
      </div>
    </div>
  </div>
</nav>
<br>
<br>

	<c:if test="${msgError !=null}">
		<div class="alert alert-danger" role="alert">
			<c:out value="${msgError}"></c:out>
		</div>
	</c:if>

	<c:if test="${msgOk !=null}">
		<div class="alert alert-success" role="alert">
			<c:out value="${msgOk}"></c:out>
		</div>
	</c:if>

<div class="ms-4 me-4">
	<form:form method="POST" action="/contactManager" modelAttribute="contacto">
			<div class="input-group">
			<form:label class="input-group-text" path="nombre">Nombre:</form:label>
			<form:input type="text" aria-label="nombre" path="nombre"
				class="form-control" />
			<form:errors path="nombre" class="text-danger" />

			<form:label class="input-group-text" path="apellidoPaterno">Apellido Paterno:</form:label>
			<form:input type="text" aria-label="apellidoPaterno"
				path="apellidoPaterno" class="form-control" />
			<form:errors path="apellidoPaterno" class="text-danger" />

			<form:label class="input-group-text" path="apellidoMaterno">Apellido Materno:</form:label>
			<form:input type="text" aria-label="apellidoMaterno"
				path="apellidoMaterno" class="form-control" />
			<form:errors path="apellidoMaterno" class="text-danger" />
		</div>
	<br>
		<div class="input-group">
			<form:label class="input-group-text" path="direccion">Dirección:</form:label>
			<form:input type="text" aria-label="direccion" path="direccion"
				class="form-control" />
			<form:errors path="direccion" class="text-danger" />

			<form:label class="input-group-text" path="telefono">Teléfono:</form:label>
			<form:input type="text" aria-label="telefono" path="telefono"
				class="form-control" />
			<form:errors path="telefono" class="text-danger" />
		</div>
<br>
		<div class="align-items-center d-flex">
			<button type="submit" class="btn btn-success ms-auto">Agregar</button>
		</div>
	</form:form>
</div>
	<br>
	
	<section class="text-center text-dark">
		<h1>Lista de Contacto Clientes</h1>
	</section>

<div class="ms-4 me-4 text">
	<div class="table-responsive">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Nombre</th>
					<th scope="col">Apellido Paterno</th>
					<th scope="col">Apellido Materno</th>
					<th scope="col">Dirección</th>
					<th scope="col">Teléfono</th>
					<th scope="col">Acción</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="contacto" items="${listaContacto}">
					<tr>
						<th scope="row"><c:out value="${contacto.id}"></c:out></th>
						<td><c:out value="${contacto.nombre}"></c:out></td>
						<td><c:out value="${contacto.apellidoPaterno}"></c:out></td>
						<td><c:out value="${contacto.apellidoMaterno}"></c:out></td>
						<td><c:out value="${contacto.direccion}"></c:out></td>
						<td><c:out value="${contacto.telefono}"></c:out></td>
						<td><a class="btn btn-danger" href="contactManager/deleteContact/${contacto.id}"
							   role="button" onclick="delete()">Eliminar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
	<br>
	<br>
<div class="container">
  <footer class="d-flex flex-wrap justify-content-between py-3 my-5 border-top">
    <p class="text-left">© 2022 Company, Inc</p>
  </footer>
</div>
	<!-- Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p " crossorigin="anonymous ">
	</script>
		
</body>
</html>