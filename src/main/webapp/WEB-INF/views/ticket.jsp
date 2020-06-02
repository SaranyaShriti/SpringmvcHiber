<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<title>Ticket Page</title>
</head>

<body>
	<div class="container">
		<div class="col-4"></div>
		<div class="col-6">


			 

				<p>You have booked ticket for your flight!</p>
				<div class="card text-white bg-dark">
					<div class="card-header">
						<h6>${flight.companyName}&nbsp;Airlines</h6>
					</div>
					<div class="card-body">
						<h5 class="card-title">Passenger Name: ${passengerName}</h5>
						<p class="card-text">FLIGHT NO : ${flight.flightNumber}</p>
						<p class="card-text">FROM : ${flight.source}</p>
						<p class="card-text">TO : ${flight.destination}</p>
						<c:set var="str" value='${flight.departureDate}' />
						<p class="card-text">DATE: ${fn:substring(str,0,11)} 11:00</p>
						
						<p class="card-text d-inline">CLASS :&nbsp;${className}</p>
					</div>
				</div>

			
			<p></p>

		</div>
	</div>
</body>
</html>