package co2103.hw2.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * 
 * @author oa194
 * Hotel class to set and get information about hotels
 *
 */

@Entity
public class Hotel {
	/***the name and primary key of a hotel */
	@Id
	private String name;
	/***the description of the hotel */
	private String description;

	/***a list of all the rooms in the hotel
	 * one hotel can have many rooms */
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Room> rooms = new ArrayList<>();

	/***a list of all staff in the hotel
	 * one hotel can have many staff */
	@OneToMany
	@JoinColumn
	private List<Person> staff = new ArrayList<>();
	
	/***a list of all bookings made in the hotel
	 * one hotel can have many bookings */
	@OneToMany(mappedBy= "hotel",cascade= CascadeType.PERSIST)//{CascadeType.PERSIST,CascadeType.MERGE})
	private List<Booking> bookings = new ArrayList<>();
	
	public Hotel() {
	}

	public Hotel(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public List<Person> getStaff() {
		return staff;
	}

	public void setStaff(List<Person> staff) {
		this.staff = staff;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

}
