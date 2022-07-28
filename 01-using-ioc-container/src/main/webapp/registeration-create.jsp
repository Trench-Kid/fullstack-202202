<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>

	<div class="container mt-2">
	
	
	<h2 class="text-center">Fill up the following form to register for ${course.name} course</h2>
	
	<div class="row">
	
	<div class="col-4">
	<c:url var="register" value="/registeration">
	<c:param name="courseId" value="${course.id}"></c:param>
	</c:url>
	<form action="${register}" method="post">
	
	<div class="mb-3">
	<label class="form-label">Student Name</label>
	<input type="text" class="form-control" placeholder="John Doe" name="student"/>
	</div>
	
	<div class="mb-3">
	<label class="form-label">Email</label>
	<input type="text" class="form-control" placeholder="john@mail.com" name="email"/>
	</div>
	
	<div class="mb-3">
	<label class="form-label">Phone</label>
	<input type="text" class="form-control" placeholder="282310" name="phone"/>
	</div>
	
	<input type="submit" value="Register" class="btn btn-outline-primary"/>

	</form>
	
	</div>
	
	</div>
	
	</div>

</body>
</html>