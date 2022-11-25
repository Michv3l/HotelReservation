package co2103.hw2.controller;

import java.security.Principal;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co2103.hw2.domain.Booking;
import co2103.hw2.domain.Hotel;
import co2103.hw2.domain.Person;
import co2103.hw2.repository.BookingRepository;
import co2103.hw2.repository.HotelRepository;
import co2103.hw2.repository.PersonRepository;


/**
 * 
 * @author oa194
 * BookingController class to manage requests to urls starting with /b/
 *
 */

@Controller
@RequestMapping("/b/")
public class BookingController {
	
	/**
	 * asks spring to inject the hotel repository in a variable automatically
	 */
	@Autowired
	private HotelRepository hotelreposits;
	
	/**
	 * asks spring to inject the person repository in a variable automatically
	 */
	@Autowired
	private PersonRepository personreposits;
	
	/**
	 * asks spring to inject the booking repository in a variable automatically
	 */
	@Autowired
	private BookingRepository bookingreposits;
	
	/**
	 * Controls requests from "/Bookings"
	 * Shows the user's current bookings
	 * @param model used to manage the behaviour and data of the Booking domain
	 * @return list of bookings to user
	 */
	@GetMapping("/bookings")
	public String showBookings(Model model) {
		model.addAttribute("bookings", bookingreposits.findAll());
		return "bookings/list";
	}
	
	/**
	 * Controls requests from "/newBooking"
	 * Loads a booking form for the user to create a booking
	 * @param model used to manage the behaviour and data of the Booking domain
	 * @return the bookings form to create a new booking
	 */
	@RequestMapping("/newBooking")
	public String newBooking(Model model) {
		model.addAttribute("hotels", ((Collection<Hotel>) hotelreposits.findAll()).stream().map(x -> x.getName()).collect(Collectors.toList()));
		model.addAttribute("booking", new Booking());
		return "bookings/form";
	}
	
	/**
	 * Controls requests from "/addBooking"
	 * Adds a new booking and saves to the repository
	 * @param booking a Booking model attribute used to connect the data from the form to the Booking Domain
	 * @param hotelName name of hotel being booked
	 * @param principal used to access information about the current user and saves user to the booking
	 * @return the bookings list to user
	 */
	@PostMapping("/addBooking")
	public String addBooking(@ModelAttribute Booking booking, @RequestParam String hotelName, Principal principal) {
		Person p = personreposits.findByUsername(principal.getName());
		for (Hotel h : hotelreposits.findAll()) {
			if (hotelName.equals(h.getName())) {
				booking=bookingreposits.save(booking);
				booking.setHotel(h);
				booking=bookingreposits.save(booking);
				break;
			}
		}
		booking.getGuests().add(p);
		booking=bookingreposits.save(booking);
		//booking.setId((int) System.currentTimeMillis());
		booking.setId(booking.getId());
		booking=bookingreposits.save(booking);
		return "redirect:/b/bookings";
	}
	
	/**
	 * Controls requests from "/deleteBooking"
	 * Checks if the booking id is present then deletes it
	 * @param id of booking to be deleted
	 * @return the bookings list to user
	 */
	@GetMapping("/deleteBooking")
	public String deleteBooking(@RequestParam int id) {
		
		if (bookingreposits.findById(id).isPresent()) {
			bookingreposits.delete(bookingreposits.findById(id).get());
		}
		return "redirect:/b/bookings";
	}
}
