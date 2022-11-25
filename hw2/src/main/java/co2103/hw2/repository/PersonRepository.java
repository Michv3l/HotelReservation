package co2103.hw2.repository;

import org.springframework.data.repository.CrudRepository;

import co2103.hw2.domain.Person;

public interface PersonRepository extends CrudRepository<Person, String> {
	public Person findByUsername(String name);

}
