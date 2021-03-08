<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"
    %>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<html>
<head>
<%@ include file="headlink.jsp"%>
<title></title>
</head>
<body>
 
 	<div class="container-fluid">
		<%@ include file="patientheader.jsp"%>
		<br>
		<!-- header............................................................................................. -->

	<div class="container-fluid">
		<form action="/searchPackage">
			<div class="container">
				<div class="row">
					<div class="col-md-5">
					
						<label for="packageName">Package Name</label>
						<input type="text" class="form-control" id="packageName" name="packageName" placeholder="Enter Package Name">
					
					</div>
					<div class="col-md-5">
						<label for="ailmet">Ailment</label>
						<input type="text" class="form-control" id="ailment" name="ailment" placeholder="Enter Ailment">
					</div>
					<div class="col-md-2">
						<p> </p>
						<button type="submit" class="btn btn-success">Search </button>
					</div>
				</div>
			</div>
			
		</form>
	</div>
	<div class="container-fluid">

    <div class="row">
        <!--start loop here-->
        <c:forEach var="iptreatmentPackage" items="${iptreatmentPackageList}">
        <div class="col-md-3 col-lg-3 col-sm-3">
            
            <div class="card">
                <div class="row">
                    <div class="col bg-danger"><label>${iptreatmentPackage.ailmentCategory}</label></div>
                </div>
                <img class="card-img-top" 
                src="https://images.unsplash.com/photo-1597764690523-15bea4c581c9?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=750&q=80" alt="Sandwich">
                
                    <div class="container">
                        <div class="row">
                            <div class="col text-left">
                                <label  name="Name" >${iptreatmentPackage.packageDetail.treatmentPackageName}</label>
                            </div>
                            <div class="col text-right">
                                <label class="card-text" name="Cost">${iptreatmentPackage.packageDetail.cost}</label>
                            </div>
                            
                        </div>
                        <div class="row">
                            <div class="col text-left">
                                <span class="badge badge-success" name="Detail" id="Package-Details">Test Detail</span>
                                <label class="text-danger" name="Category">${iptreatmentPackage.packageDetail.testDetails}</label>
                            </div>
                            <div class="col text-right" id="Sandwich-delivery">
                                <label> </label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col text-left text-muted">
                                <i class="material-icons" id="schedule-icon">schedule</i><label>Treatment Duration</label><br>
                            </div>
                            <div class="col text-right">
                                <label>${iptreatmentPackage.packageDetail.treatmentDuration}</label>
                            </div>
                           
                        </div>
                        <div class="row justify-content-center">
                            <div></div>
                            <div class="col-12 justify-content-center">
                                
                                    <a href="/patient/getTreatment/?id=${iptreatmentPackage.id}" class=" btn btn-primary" name="Edit"><i class="material-icons">queue</i>Get Treatment</a>
                                </div>
                            </div>
                        </div>
                    </div>
            </div>
             </c:forEach>
            <!--end loop here-->
        </div>
	</div>
	
	
	</div>
	
</body>
</html>