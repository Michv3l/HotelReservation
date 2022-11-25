package co2103.hw2.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import co2103.hw2.domain.Room;

public class RoomValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Room.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category", "", "required");

		Room r = (Room) target;

		if (r.getMaxGuests() < 1 || r.getMaxGuests() > 12) {
			errors.rejectValue("maxGuests", "", "wrong");
		}
	}

}
