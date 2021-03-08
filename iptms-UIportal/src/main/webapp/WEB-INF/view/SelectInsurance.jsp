<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"
    %>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<%@ include file="headlink.jsp"%>
<title></title>
</head>
<body>
	<div class="container-fluid">
		<%@include file="LogoutHeader.jsp"%>
		<br>
		<!-- header.................................................................. -->
		
		<!-- main start from here -->
		
		
        <div class="conatiner-fluid justify-content-center">
            <div class="card">
                <h4 class="text-center">  Insurance Packages  </h4>
            </div>
        </div>
       
        <div class="conatiner-fluid">
                <div class="row">
                    <!--start loop here-->
                    <c:forEach var="insurerDetail" items="${insurerDetailList}">
                    <div class="col-md-3">
                       
                        <div class="container" name="insurance-package">
                                <div class="card" name=main-row-insurance>
                                    <div class="container">
                                        <div class="row">
                                            <div class="col-md-6" name="insurer-name">
                                                <div class="card">
                                                    <label>Insurer Name</label><br>
                                                    <p>${insurerDetail.insurerName}</p>
                                                </div>
                                                <br>
                                            </div>
                                            <div class="col-md-6" name="insurance-package-name">
                                                <div class="card">
                                                    <label>Package Name</label><br>
                                                    <p>${insurerDetail.insurerPackageName}</p>
                                                </div>
                                                
                                            </div>                                           
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6" name="amount-limit">
                                                <div class="card">
                                                    <label>Amount Limit</label><br>
                                                    <p>${insurerDetail.insuranceAmountLimit}</p>
                                                </div>
                                                <br>
                                            </div>
                                            <div class="col-md-6" name="disbursement-duration">
                                                <div class="card">
                                                    <label>Disbursement Duration </label><br>
                                                    <p>${insurerDetail.disbursementDuration}</p>
                                                </div>
                                                <br>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col justified-content-center">
                                                
                                                    <div class="card">
                                                        <a href="/insurance/initiateClaim?packageName=${insurerDetail.insurerPackageName}" class="btn-danger">Initiate Claim</a>
                                                    
                                                    </div>
                                                    <br>
                                            </div>
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