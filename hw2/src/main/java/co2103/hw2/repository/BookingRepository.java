package co2103.hw2.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co2103.hw2.domain.Booking;
import co2103.hw2.domain.Person;

public interface BookingRepository extends CrudRepository<Booking, Integer> {
	public List<Booking> findByHotel_Staff(Person staff);
	public List<Booking> findByGuests(Person guests);
}
