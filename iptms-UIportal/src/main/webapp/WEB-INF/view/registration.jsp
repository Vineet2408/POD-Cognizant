<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    isELIgnored="false"%>
<!DOCTYPE html>
<html>
<%@ include file="headlink.jsp" %>
<head>
<meta charset="ISO-8859-1">
<title>Patient Details</title>
</head>
<body>
	<div class=container-fluid>
		<%@ include file="registrationheader.jsp" %>
		<!-- header finished -->
		
		
		<!-- main started here -->
		   <div class="container-fluid justified-content-center">
            <div class="card">
                <h1 class="text-center">Registration Form</h1>
            </div>
        </div>
        
	<div class=container-fluid>
		<form action="/patient/processform" method="post">
	
			<div class="form-group">
				<label for="name">Name</label>
				<input type="text" class="form-control" id="name" name="name" placeholder="Enter Email">
			</div>
			<div class="form-group">
				<label for="age">Age</label>
				<input type="number" class="form-control" id="age" name="age" placeholder="Enter Age">
			</div>
			<div class="form-group">
				<label for="ailment">Ailment</label>
				<input type="text" class="form-control" id="ailment" name="ailment" placeholder="Enter Ailment">
			</div>
			<button type="submit" class="btn btn-success">Register </button>
		</form>
	</div>
	
	</div>
</body>
</html>