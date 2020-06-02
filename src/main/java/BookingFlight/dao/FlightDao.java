package BookingFlight.dao;

import java.text.ParseException;
import java.util.List;

import BookingFlight.model.Flight;
import BookingFlight.model.Login;
import BookingFlight.model.Search;
import BookingFlight.model.User;

public interface FlightDao {
	
	public List<Flight> listFlights(Search search) throws ParseException;

	public List<Flight> listAllFlights();

	public User checkUser(Login login);

	public Flight flightObj(String flightNo);

	int bookObj(int flightId, int userId);

	List<String> listAllSource();

	public List<String> listAllDestination();

	void passengerDetails(int flightId,int userId, String passengerName, String className);	
	
	public Flight getFlightFromId(int flightId);	

}
