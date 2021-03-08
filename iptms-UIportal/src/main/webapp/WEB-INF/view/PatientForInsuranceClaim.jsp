<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"
    %>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<%@ include file="headlink.jsp" %>
<title></title>
</head>
<body>
<div class="container-fluid">
	<%@ include file="Insuranceheader.jsp"%>
	</br>
		<!-- header............................................................................................. -->
	
			<!-- main start here -->
	
        <div class="container-fluid justified-content-center">
            <div class="card">
                <h1 class="text-center">Applications for Insurance Claim</h1>
            </div>
        </div>

        <div class="container-fluid">
            <div class="row">
                <!-- loop here -->
                <c:forEach var="treatmentPlan" items="${treatmentPlanList}">
                <div class="col-md-4">
                    <div class="card">
                        <div class="container">
                            <div class="row">
                                <div class="col">
                                    <div class="card">
                                        <h5>Name of Patient</h5>
                                       ${treatmentPlan.patientDetail.name}
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="card">
                                        <h5>Ailment</h5>
                                        ${treatmentPlan.patientDetail.ailment}
                                    </div>
                                   
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <div class="card">
                                        <h5>Treatment Package</h5>
                                        ${treatmentPlan.packageName}
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="card">
                                        <h5>Cost</h5>
                                        ${treatmentPlan.cost}
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="card">
                                        <h5>Treatment Start Date</h5>
                                        ${treatmentPlan.treatmentCommencementDate}
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- the patient details row ended here-->
                        <div class="row">
                            <div class="col justified-content-center">
                                <div class="card">
                                   <a href="/insurance/selectInsurance/?tpid=${treatmentPlan.treatmentPlanId}" class="btn-danger">Select Insurance Package</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </c:forEach>
                <!--end the loop here-->
            </div>
        </div>
</div>
</body>
</html>