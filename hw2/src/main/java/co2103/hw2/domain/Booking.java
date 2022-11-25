package co2103.hw2.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @author oa194
 * Booking class to set and get information about bookings
 *
 */

@Entity
public class Booking {
	/***the automatically generated id and primary key of a booking */
	@Id
	@GeneratedValue
	int id;
	/***the date the booking begins */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date start = Calendar.getInstance().getTime();
	/***the date the booking ends */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date end = Calendar.getInstance().getTime();;

	/***a list of each guest under the booking
	 * Guests can have multiple bookings and a booking can have multiple guests */
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinColumn
	private List<Person> guests = new ArrayList<>();

	/***the hotel being booked */
	@ManyToOne(cascade=CascadeType.MERGE)
	private Hotel hotel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Person> getGuests() {
		return guests;
	}

	public void setGuests(List<Person> guests) {
		this.guests = guests;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}
	
}
