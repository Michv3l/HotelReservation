package co2103.hw2.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co2103.hw2.domain.Hotel;

public interface HotelRepository extends CrudRepository<Hotel, String> {
	public List<Hotel> findByName(String hotel);

}
