<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="headlink.jsp"%>
<title>Insurance</title>
</head>
<body>
<div class="container-fluid">
<%@ include file="Insuranceheader.jsp" %>


	<div class="container-fluid">
            <div class="row">
                <div class="col-md-5">
                    <a href="/insurance/viewApplications">
                        <div class="card">
                            <h4>View All Applications for Insurance Claim</h4>
                            <img src="application-form.jpg" width="200" height="300">
                        </div>
                    </a>
                   
                </div>
                <div class="col-md-5">
                    <a href="/insurance/viewAllPackages">
                        <div class="card">
                            <h4>View All Insurance Packages</h4>
                            <img src="insurance packages.jpg" width="200" height="300">
                        </div>
                    </a>
                    
                </div>
            </div>
        </div>
</div>
</body>
</html>