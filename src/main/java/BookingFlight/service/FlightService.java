package BookingFlight.service;

import java.text.ParseException;
import java.util.List;

import BookingFlight.model.Flight;
import BookingFlight.model.Login;
import BookingFlight.model.Search;
import BookingFlight.model.User;

public interface FlightService {
		public List<Flight> listFlights(Search search) throws ParseException;
		
		public List<Flight> listAllFlights();

		public User checkUser(Login login);

		public Flight getFlight(String flightNo);
		
		List<String> listAllSource();

		List<String> listAllDestination();	
		
		void passengerDetails(int flightId,int userId, String passengerName, String className);

		public Flight getFlightFromId(int flightId);	

}
