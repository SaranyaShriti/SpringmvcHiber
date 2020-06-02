package BookingFlight.service.impl;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import BookingFlight.dao.FlightDao;
import BookingFlight.model.Flight;
import BookingFlight.model.Login;
import BookingFlight.model.Search;
import BookingFlight.model.User;
import BookingFlight.service.FlightService;

@Service
@Transactional	
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightDao flightDao;
	
	@Override
	public List<Flight> listFlights(Search search) throws ParseException {
		
		return flightDao.listFlights(search);
	}

	@Override
	public List<Flight> listAllFlights() {
		
		return flightDao.listAllFlights();
	}

	@Override
	public User checkUser(Login login) {
		
		return flightDao.checkUser(login);
	}

	@Override
	public Flight getFlight(String flightNo) {
		
		return flightDao.flightObj(flightNo);
	}
	

	@Override
	public List<String> listAllSource() {
		
		return flightDao.listAllSource();
	}
	
	
	@Override
	public List<String> listAllDestination() {
		
		return flightDao.listAllDestination();
	}

	@Override
	public void passengerDetails(int flightId,int userId, String passengerName, String className) {
		
		flightDao.passengerDetails(flightId, userId, passengerName, className);
		
	}

	@Override
	public Flight getFlightFromId(int flightId) {
		
		return flightDao.getFlightFromId(flightId);
	}
	
}
