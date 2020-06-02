package BookingFlight.dao.impl;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import BookingFlight.dao.FlightDao;
import BookingFlight.model.BookingConfirmation;
import BookingFlight.model.Flight;
import BookingFlight.model.Login;
import BookingFlight.model.Search;
import BookingFlight.model.User;


@Repository
public class FlightDaoImpl implements FlightDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Flight> listFlights(Search search) throws ParseException {
		Session session = sessionFactory.getCurrentSession();
		Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(search.getJourneydate());
		Query<Flight> query = session.createQuery("from Flight where source=:source AND destination=:destination AND departureDate=:date");
		query.setParameter("source", search.getSource());
		query.setParameter("destination", search.getDestination());
		query.setParameter("date", date1);

		return query.list();
	}
	
	@Override
	public User checkUser(Login login) {
		Session session = sessionFactory.getCurrentSession();
		String stmt = "from User where userName='"+login.getUsername()+"' AND password='"+login.getPassword()+"'";
		Query<?> q=session.createQuery(stmt);
		User u=(User) q.uniqueResult();
		if(u.getUserId()>0)
			return u;
		else
			return null;
	}
	
	@Override
	public List<Flight> listAllFlights() {
		Session session = sessionFactory.getCurrentSession();
		Query<Flight> query = session.createQuery("from Flight where status=1");
		return query.list();
	}
	
	@Override
	public List<String> listAllSource() {
		Session session = sessionFactory.getCurrentSession();
		Query<String> query = session.createQuery("select DISTINCT(source) from Flight where status=1");
		return query.list();
	}
	
	@Override
	public List<String> listAllDestination() {
		Session session = sessionFactory.getCurrentSession();
		Query<String> query = session.createQuery("select DISTINCT(destination) from Flight where status=1");
		return query.list();
	}

	@Override
	public Flight flightObj(String flightNo) {
		Session session = sessionFactory.getCurrentSession();
		Query<Flight> query = session.createQuery("from Flight where flightNumber='"+flightNo+"'");
		return query.uniqueResult();
	}
	
	@Override
	public int bookObj(int flightId, int userId) {
		Session session = sessionFactory.getCurrentSession();
		BookingConfirmation bc = new BookingConfirmation();
		bc.setFlightId(flightId);
		bc.setUserId(userId);
		session.save(bc);
	    return bc.getBookId();
		
	}

	@Override
	public void passengerDetails(int flightId,int userId, String passengerName, String className) {
		
		BookingConfirmation bc = new BookingConfirmation();
		bc.setFlightId(flightId);
		bc.setUserId(userId);
		bc.setPassengerName(passengerName);
		bc.setClassName(className);
		
		Session session1 = sessionFactory.getCurrentSession();
		session1.persist(bc);
	}

	@Override
	public Flight getFlightFromId(int flightId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Flight.class, flightId);
	}



	
}
