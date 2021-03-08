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
		<%@ include file="Insuranceheader.jsp"%>
		<c:set var="count" value="1"/>
		<br>
		<!-- header............................................................................................. -->
	
			<!-- main start here -->
		 <div class="conatiner-fluid justify-content-center">
            <div class="card bg-danger" style="margin-left:5px;margin-right:5px">
                <h4 class="text-center">  Insurance Packages  </h4>
            </div>
        </div>
       
        <div class="conatiner-fluid">
                <div class="row">
                <!-- start loop here -->
                    <c:forEach var="insurancePackage" items="${insurancePackagesList}">
                    <div class="col-md-3">
                       <p>${count}</p>
                       <c:set var="count" value="${count+1}"/>
                        <div class="container" name="insurance-package">
                                <div class="card btn-success bg-primary" name=main-row-insurance>
                                
                                    <div class="container">
                                        <div class="row">
                                            <div class="col-md-6" name="insurer-name">
                                                <div class="card bg-danger">
                                                    <label >Insurer Name</label></br>
                                                    ${insurancePackage.insurerName}
                                                </div>
                                                <br>
                                            </div>
                                            <div class="col-md-6" name="insurance-package-name">
                                                <div class="card  bg-danger">
                                                    <label>Package Name</label></br>
                                                   ${insurancePackage.insurerPackageName}
                                                </div>
                                                <br>
                                            </div>                                           
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6" name="amount-limit">
                                                <div class="card  bg-danger">
                                                    <label>Amount Limit</label><br>
                                                    ${insurancePackage.insuranceAmountLimit}
                                                </div>
                                                <br>
                                            </div>
                                            <div class="col-md-6" name="disbursement-duration">
                                                <div class="card  bg-danger">
                                                    <label>Disbursement Duration </label><br>
                                                    ${insurancePackage.disbursementDuration}
                                                </div>
                                                <br>
                                            </div>
                                        </div>
                                </div>
                                </div>
                        </div>
                    </div>
                </c:forEach>
                <!-- end loop here -->
                </div>
        </div>
       
		
		<!-- main ended here -->
	</div>
</body>
</html>