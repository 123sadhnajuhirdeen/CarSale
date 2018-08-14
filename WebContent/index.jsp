<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Sale</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		
		<%@ include file="WEB-INF/pages/header.jsp"  %>
		
		<div class="row">
			<div class="col-md-3">
				<img src="images/default.png" 
				class="img img-responsive img-thumbnail"/>
			</div>
			<div class="col-md-9">
				<h2>Honda CIVIC Car for Sale </h2>
				<p> Description Here</p>
				<h6> Price: 3,800,000/=</h6>
				<a href="car_view.jsp" class="btn btn-warning">View</a>
			</div>
		</div>
		
		
		<%@ include file="WEB-INF/pages/footer.jsp"  %>
		
	</div>
</body>
</html>