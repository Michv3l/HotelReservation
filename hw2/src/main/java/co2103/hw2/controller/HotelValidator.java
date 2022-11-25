package co2103.hw2.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import co2103.hw2.domain.Hotel;
import co2103.hw2.repository.HotelRepository;

public class HotelValidator implements Validator {

	//@Autowired
	private HotelRepository hotelreposits;
	
	public HotelValidator(HotelRepository hotelreposits) {
		this.hotelreposits = hotelreposits;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Hotel.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "", "required");

		Hotel hotel = (Hotel) target;
		
		for(Hotel h : hotelreposits.findAll()) {
			if (hotel.getName().equals(h.getName())) {
				errors.rejectValue("name", "", "taken");
				break;
			}
		}

	}

}
