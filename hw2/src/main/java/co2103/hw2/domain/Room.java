package co2103.hw2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * @author oa194
 * Room class to set and get information about rooms
 *
 */

@Entity
public class Room {
	/***the automatically generated id and primary key of the room */
	@Id
	@GeneratedValue
	private int id;
	/***the description of the room */
	private String description;
	/***the room category */
	private String category;
	/***the max number of guests allowed in the room */
	private int maxGuests;

	public Room() {
		super();
	}

	public Room(String description, String category, int maxGuests) {
		this.category = category;
		this.description = description;
		this.maxGuests = maxGuests;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getMaxGuests() {
		return maxGuests;
	}

	public void setMaxGuests(int maxGuests) {
		this.maxGuests = maxGuests;
	}

}
