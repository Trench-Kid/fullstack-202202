<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
</head>
<body>

	<div class="container m-4">

		<h3 class="text-muted">Registration</h3>

		<c:choose>
		
		<c:when test="${empty registeration}">
		<div class="alert alert-warning">There is no registered student for this class.</div>
		</c:when>
		
		<c:otherwise>
		
			<table class="table table-striped">

			<thead>

				<tr>
					<th>ID</th>
					<th>Student</th>
					<th>Class ID</th>
					<th>e-mail</th>
					<th>Phone</th>
					<th>Start Date</th>
					<th>Course Name</th>
				</tr>

			</thead>

			<tbody>

				<c:forEach var="r" items="${registeration }">
					<tr>
						<td>${r.id}</td>
						<td>${r.student}</td>
						<td>${r.openClass.id}</td>
						<td>${r.email}</td>
						<td>${r.phone}</td>
						<td>${r.openClass.startDate}</td>
						<td>${r.openClass.course.name}</td>

					</tr>

				</c:forEach>

			</tbody>

		</table>
		
		</c:otherwise>
		
		</c:choose>

	</div>

</body>
</html>