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

	<div class="container mt-4">
		<h3>
			Classes available for ${course.name} course
			</h3>
				
				<div class="m-2">
				<c:url var="addNew" value="/class-edit">
					<c:param name="courseId" value="${course.id}"></c:param>
				</c:url>
				<a href="${addNew}" class="btn btn-primary">Add new class</a>
				</div>

					<c:choose>
					
					<c:when test="${empty classes}">
					<div class="alert alert-warning">There's no class available. Add new class to the list.</div>
					</c:when>
					
					<c:otherwise>
					
					<table class="table table-striped">

						<thead>

							<tr>

								<th>ID</th>
								<th>Teacher</th>
								<th>Start-Date</th>
								<th>Course</th>
								<th>Fees</th>
								<th>Duration</th>
								<th>Description</th>
								<th></th>

							</tr>

						</thead>

						<tbody>

							<c:forEach var="c" items="${classes}">

								<tr>

									<td>${c.id}</td>
									<td>${c.teacher}</td>
									<td>${c.startDate}</td>
									<td>${c.course.name}</td>
									<td>${c.course.fees}</td>
									<td>${c.course.duration} Months</td>
									<td>${c.course.description}</td>
									
									<td>
									<c:url var="register" value="/registeration-create">
									<c:param name="courseId" value="${course.id}"></c:param>
									<c:param name="openClassId" value="${c.id}"></c:param>
									
									</c:url>
									<a class="btn btn-outline-success" href="${register}">Register Now!</a>
									</td>

								</tr>
								
								</c:forEach>

						</tbody>

					</table>
					
					</c:otherwise>
					
					</c:choose>
	</div>

</body>
</html>