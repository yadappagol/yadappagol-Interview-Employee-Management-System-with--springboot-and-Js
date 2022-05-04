<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Employee Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="https://www.xadmin.net" class="navbar-brand"> Employee Management Application </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Employee</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${employee != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${employee == null}">
					<form action="add" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${employee != null}">
            			Add Employee
            		</c:if>
						<c:if test="${employee == null}">
            			Add New Employee
            		</c:if>
					</h2>
				</caption>

				<c:if test="${employee != null}">
					<input type="hidden" name="id" value="<c:out value='${employee.employeeId}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Employee Name</label> <input type="text"
						value="<c:out value='${employee.employeeName}' />" class="form-control"
						name="employeeName" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Employee Email</label> <input type="text"
						value="<c:out value='${employee.employeeMailId}' />" class="form-control"
						name="employeeMailId">
				</fieldset>

                <fieldset class="form-group">
					<label>Employee Date Of Birth</label> <input type="date" 
						value="<c:out value='${employee.employeeDob}' />" class="form-control"
						name="employeeDob">
				</fieldset>

				<fieldset class="form-group">
					<label>Employee Salary</label> <input type="text"
						value="<c:out value='${employee.employeeSalary}' />" class="form-control"
						name="employeeSalary">
				</fieldset>

				<fieldset class="form-group">
					<label>Employee Place</label> <input type="text"
						value="<c:out value='${employee.employeeLocation}' />" class="form-control"
						name="employeeLocation">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>