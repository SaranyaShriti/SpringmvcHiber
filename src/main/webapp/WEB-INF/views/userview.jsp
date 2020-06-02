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
<title>User Page</title>
</head>

<body>
	<div class="container">
		<div class="col-4"></div>
		<div class="col-6">


			<form method="post" action="/BookingFlight/passengerDetails">
				
				<div class="form-group">
					
					<input type="hidden"
						name="userId" value="${user.userId}" class="form-control" />
				</div>
				<div class="form-group">
					
					<input type="hidden"
						name="flightId" value="${flight.flightId}" class="form-control" />
				</div>
				<div class="form-group">
					<h6>Enter Passenger Details</h6>
					<label>Passenger Name: </label><input type="text"
						name="passengerName" id="passengerName" class="form-control" />
				</div>

				<div class="form-group">
					<label for="class">Select Class:</label> <select name="class1"
						id="class1" class="form-control">
						<option value="Business">Business Class</option>
						<option value="Economy">Economy Class</option>
						<option value="First">First Class</option>

					</select>
				</div>

				<div class="form-group">
					<input type="submit" class="btn btn-primary" name="answer"
						value="Book ticket" onclick="showDiv()" />
				</div>
			</form>
		
			<p></p>

		</div>
	</div>
</body>
</html>