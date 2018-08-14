<%@page import="com.im.carsale.model.Brand"%>
<%@page import="com.im.carsale.controller.BrandController"%>
<%@page import="java.util.List"%>
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
			<div class="col-md-2">
				Side Bar
			</div>
			<div class="col-md-9">
				<h2>Brand List</h2>
				<hr/>
				
				<table class="table">
					<tr>
						<th> ID</th>
						<th> NAME</th>
						<th> OPTIONS</th>
					</tr>
					<%
					List<Brand> list = BrandController.list();
					for(Brand brand : list){
					%>
					
					<tr>
						<td> <%=brand.getId() %></td>
						<td> <%=brand.getName() %></td>
						<td> 
							<a href="brand_show.jsp?id=<%=brand.getId() %>" class="btn btn-info">SHOW</a>
							<a href="brand_edit.jsp?id=<%=brand.getId() %>" class="btn btn-warning">EDIT</a>
							<a href="brand_delete?id=<%=brand.getId() %>" class="btn btn-danger">DELETE</a>
						</td>
					</tr>
					<%
					}
					%>
				</table>
				
				
			</div>
			
		</div>
		
		
		<%@ include file="WEB-INF/pages/footer.jsp"  %>
		
	</div>
</body>
</html>