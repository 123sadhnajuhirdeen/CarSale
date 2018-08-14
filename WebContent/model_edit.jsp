<%@page import="java.util.List"%>
<%@page import="com.im.carsale.controller.ModelController"%>
<%@page import="com.im.carsale.model.Model"%>
<%@page import="com.im.carsale.controller.BrandController"%>
<%@page import="com.im.carsale.model.Brand"%>
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
				<h2>Model Edit</h2>
				<hr/>
				
				<%
				Object idObj = request.getParameter("id");
				if(idObj!=null){
					int id = Integer.parseInt(idObj.toString());
					Model model = ModelController.get(id);
					%>
					<form action="model_update" method="post">
						<input type="text" class="form-control" value="<%=model.getId() %>" name="id" readonly="readonly"/>
						<select name="brand_id" class="form-control">
							<%
							List<Brand> list = BrandController.list();
							for(Brand brand : list){
								String selected = "";
								if(brand.getId()==model.getBrand().getId()){
									selected = "selected";
								}
								
							%>
								<option <%=selected %> value="<%=brand.getId() %>"><%=brand.getName() %></option>
							<%
							}
							%>
						</select>
						<label>Name</label>
						<input type="text" class="form-control"  value="<%=model.getName() %>" name="name"/>
						<input type="reset" value="Reset" class="btn btn-default"/>
						<input type="submit" value="Save"class="btn btn-success"/>
					</form>
					
					<%
				}else{
					out.print("BAD REQUEST.");
				}
				
				
				%>
				
				
				
				
			</div>
			
		</div>
		
		
		<%@ include file="WEB-INF/pages/footer.jsp"  %>
		
	</div>
</body>
</html>