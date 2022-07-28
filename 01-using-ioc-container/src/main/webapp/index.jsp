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

		<h2>01-using-using-ioc-container</h2>
		<h3>Course List</h3>

		<div class="mt-3">
			<a href="course-edit" class="btn btn-primary">Add new course</a>
		</div>
		<div class="mt-4">
			<c:choose>

				<c:when test="${empty courses}">
					<div class="alert alert-warning">There is no class in the
						list.</div>
				</c:when>

				<c:otherwise>

					<table class="table table-striped">

						<thead>

							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Fees</th>
								<th>Duration</th>
								<th>Description</th>
								<th></th>
							</tr>

						</thead>

						<tbody>

							<c:forEach var="c" items="${courses}">

								<tr>

									<td>${c.id}</td>
									<td>${c.name }</td>
									<td>${c.fees }</td>
									<td>${c.duration } Months</td>
									<td>${c.description }</td>
									
									<td>
									<c:url var="classes" value="/classes">
									<c:param name="courseId" value="${c.id}"></c:param>
									</c:url>
									<a class="btn btn-outline-info" href="${classes}">open class</a>
									</td>

								</tr>

							</c:forEach>

						</tbody>

					</table>

				</c:otherwise>

			</c:choose>

		</div>

	</div>

</body>
</html>