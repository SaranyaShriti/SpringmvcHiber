package BookingFlight.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import BookingFlight.dao.FlightDao;
import BookingFlight.model.Flight;
import BookingFlight.model.Login;
import BookingFlight.model.Search;
import BookingFlight.model.User;
import BookingFlight.service.FlightService;

@Controller
public class FlightController {
	
	
	@Autowired
	FlightService flightService;
	/*
	 * Controller used to list all the flights with search Form
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String homePage(@ModelAttribute("searchForm")Search search, Model model)
	{
		model.addAttribute("listFlight", flightService.listAllFlights());
		return "listFlight";
	}
	
	/*
	 * Controller used to search the flights based on source and destination
	 */
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String searchFlights(@ModelAttribute("searchForm")Search search, Model model) throws ParseException
	{
		model.addAttribute("listFlight", flightService.listFlights(search));
		return "listFlight";
		
	}
	
	/*
	 * Controller used to redirect to login page when the user want to book flight
	 */
	@RequestMapping(value="/loginPage")
	public String searchFlights(@ModelAttribute("loginForm")Login login, @RequestParam("flightId")String flightNo, Model model) throws ParseException
	{
		try
		{
		model.addAttribute("flightNumber", flightNo);
		model.addAttribute("login", new Login());
		return "login";
		}
		catch(Exception e)
		{
			return "invalid";
		}
	}
	
	/*
	 * Controller used to book the flight 
	 */
	
	@RequestMapping(value="/bookTicket")
	public String bookTicket(@ModelAttribute("loginForm")Login login, @RequestParam("flightNumber")String flightNo, Model model) throws ParseException
	{
		try
		{
		User user=flightService.checkUser(login);

		if(user!=null)
		{
			model.addAttribute("user", user);
			model.addAttribute("flight", flightService.getFlight(flightNo));
			return "userview";
		}
		else 
			return "invalid";
		}
		catch(Exception e)
		{
			model.addAttribute("unknownUser", "You are not authenticated user!");
			return "invalid";	
		}
		
	}
	
	@RequestMapping(value="/passengerDetails")
	public String passengerDetails(@RequestParam("flightId")String flightId,@RequestParam("userId")String userId, @RequestParam("passengerName")String passengerName, @RequestParam("class1")String classname, Model model) throws ParseException
	{
		model.addAttribute("flight", flightService.getFlightFromId(Integer.valueOf(flightId)));
		model.addAttribute("passengerName", passengerName);
		model.addAttribute("className", classname);
		flightService.passengerDetails(Integer.valueOf(flightId),Integer.valueOf(userId), passengerName, classname);
		return "ticket";
	}

}
