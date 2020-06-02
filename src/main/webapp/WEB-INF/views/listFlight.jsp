<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
	<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Login Page</title>

</head>
<body>

	<h3 class="text-center">Book Your Flight</h3>

	<div class="container">
		<div class="row">
			<p></p>
		</div>

		<div class="row">

			<form:form method="post" action="/BookingFlight/search"
				modelAttribute="searchForm">
				<div class="form-group">
					<form:label path="source">Source</form:label>
					<form:input path="source" />

					<form:label path="destination">Destination</form:label>
					<form:input path="destination" />

					<form:label path="journeydate">Journey Date</form:label>
					<form:input path="journeydate" placeholder="yyyy-MM-dd" />

					<input class="btn btn-primary" type="submit" value="Search" />
				</div>
			</form:form>
		</div>
		<div class="row">
			<div class="col-8">
				
				<c:forEach var="flight" items="${listFlight}">
					<p></p>
					<div class="card">
						<div class="card-header">
							<!--  <p class="d-inline">Leave From</p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <p class="d-inline">Going To </p><br>-->
							<h5 class="d-inline">${flight.source}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </h5><i class="fa fa-exchange"
								style="font-size: 20px"></i>&nbsp;&nbsp;<h5 class="d-inline"> ${flight.destination}</h5>
								
							<h4 class="float-right">${flight.companyName}</h4>
						</div>
						<div class="card-body">
							
							<p class="card-text float-left"><b>Journey Date</b> &nbsp;&nbsp;&nbsp;&nbsp;
							<c:set var="str" value='${flight.departureDate}' />
    							${fn:substring(str,0,11)}
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
							<p class="card-text d-inline"><b>Price</b>&nbsp;&nbsp;&nbsp;<i class="fas fa-rupee-sign" style='font-size:15px'></i>
							${flight.fare}</b>
							<div>
							<a href="loginPage?flightId=${flight.flightNumber}" class="btn btn-outline-secondary d-inline float-right">Book</a>
							</div>
						</div>
					</div>
					
				</c:forEach>
			
			</div>
		</div>
	</div>
</body>
</html>