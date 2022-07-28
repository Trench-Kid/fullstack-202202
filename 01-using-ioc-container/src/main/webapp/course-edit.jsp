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

<h3 class="text-center">Add New Course</h3>

	<div class="row">
	
		<div class="col-4">
		
		<c:url var="save" value="/courses"></c:url>

		<form action="${save}" method="post">

			<div class="mb-3">

				<label class="form-label">Name</label> <input name="name" type="text"
					required="required" placeholder="Enter course name"
					class="form-control" />

			</div>

			<div class="mb-3">

				<label class="form-label">Fees</label> <input name="fees" type="number"
					required="required" placeholder="Enter course fees"
					class="form-control" />

			</div>

			<div class="mb-3">

				<label class="form-label">Duration</label> <input name="duration" type="number"
					required="required" placeholder="Enter course duration"
					class="form-control" />

			</div>

			<div class="mb-3">

				<label class="form-label">Description</label>
				<textarea name="description" rows="4" cols="40" class="form-control"></textarea>

			</div>
			
			<input type="submit" class="btn btn-primary" value="Save course"/>

		</form>
		
		</div>

	</div>

</div>
	

</body>
</html>