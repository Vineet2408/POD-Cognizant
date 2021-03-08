<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"
    %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<html>
<head>
<%@ include file="headlink.jsp"%>
<title>Home</title>
</head>
<body>
	<div class="container-fluid">
	<%@ include file="homeheader.jsp"%>
	<br>
	<!-- header............................................................................................. -->
	
	 
<div class="container-fluid justify-content-center" id="heading">
    <div class="card justify-content-center">
        <h1 class="text-center">Get Fit  &  Get Back to Healthy Life</h1>

    </div>

</div>
    <div class="container-fluid">
            <div class="row">
                    <div class="col-md-6">
                    	<div class="card bg-primary">
                        <div class="card">
                            <h4>Our International Treatment Packages</h4>
                        </div>
                        <br>
                            <div class="container" name="treatment-packages">
                                <!--start loop here-->
                                <c:forEach var="IPTreatmentPackages" items="${iPTreatmentPackageList}">
                                <div class="row" name="main-row-treatment-packages">
                                    <div class="col">
                                        <div class="card" >
                                            <div class="container">
                                                    <div class="row">
                                                        <div class="col-md-4" name="treatment-ailment-name">
                                                        	<div class="card bg-success">
                                                        	<label>Ailment Category</label><br>
                                                        	<label>${IPTreatmentPackages.ailmentCategory}</label>
                                                        	</div>
                                                            <br>
                                                        </div>
                                                        <div class="col-md-4" name="treatment-package-name">
                                                        	<div class="card bg-success">
                                                        	<label>Package Name</label><br>
                                                            <label>${IPTreatmentPackages.packageDetail.treatmentPackageName}</label>
                                                       		</div>
                                                       		<br>
                                                        </div>
                                                        <div class="col-md-4" name="treatment-package-cost">
                                                            <label>${IPTreatmentPackages.packageDetail.cost}</label>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-6" name="treatment-package-test-detail">
                                                        	<div class="card bg-success">
                                                        	<label>Test Detail</label><br>
                                                            <label>${IPTreatmentPackages.packageDetail.testDetails}</label>
                                                        	</div>
                                                        	<br>
                                                        </div>
                                                        <div class="col-md-6" name="treatment-package-treatment-duration">
                                                            <div class="card bg-success">
                                                                <label>Treatment Duration</label><br>
                                                                ${IPTreatmentPackages.packageDetail.treatmentDuration}
                                                            </div>
                                                            <br>
                                                        </div>
                                                    </div>
                                            </div>
                                        </div>
                                        <br>
                                    </div>
                                </div>
                                </c:forEach>
                                  <!--end loop here-->
                                  
                            </div>
                    </div>
                    </div>
                    <div class="col-md-5">
                    	<div class="card bg-primary">
                        <div class="card">
                            <h4>Our Specialists</h4>
                        </div>
                       <br>
                        <div class="container" name="specialists">
                            <!--start loop here-->
                            <c:forEach var="specialist" items="${specialistList}">
                            <div class="row" name="main-row-specialist">
                                <div class="col">
                                    <div class="card" >
                                        <div class="container">
                                                <div class="row">
                                                    <div class="col-md-6" name="specialist--name">
                                                        <label>${specialist.name}</label>
                                                    </div>
                                                    <div class="col-md-6" name="experience-cost">
                                                        <label>${specialist.experienceInYears} years of Experience</label>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-6" name="area-of-experties">
                                                        <div class="card bg-success">
                                                            <label>Area of Experties</label><br>
                                                            ${specialist.areaOfExpertise}
                                                        </div>
                                                        <br>
                                                    </div>
                                                </div>
                                        </div>
                                    </div>
                                    <br>
                                </div>
                            </div>
                            </c:forEach>
                           <!--end loop here-->
                        </div>
                        </div>
                    </div>
                   

            </div>
    </div>

	</div>
</body>
</html>