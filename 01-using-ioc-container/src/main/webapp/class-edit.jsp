<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="container mt-2">

		<h3>Add new class for ${course.name} course!</h3>

		<div class="row">

			<div class="col-4">
				<c:url var="save" value="/classes">
					<c:param name="courseId" value="${course.id}"></c:param>
				</c:url>
				<form action="${save}" method="post">

					<div class="form-floating mb-3">
						<input name="teacher" type="text" required="required"
							class="form-control" placeholder="Teacher's name" /> <label
							class="form-label">Teacher</label>

					</div>

					<div class="mb-3">
						<input name="startDate" type="date" required="required"
							class="form-control" placeholder="Class starting date" /> <label
							class="form-label">Start-date</label>

					</div>

					<input type="submit" value="Save new class" class="btn btn-primary" />

				</form>

			</div>

		</div>

	</div>

</body>
</html>