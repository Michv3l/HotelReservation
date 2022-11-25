
package co2103.hw2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import co2103.hw2.domain.Booking;
import co2103.hw2.domain.Hotel;
import co2103.hw2.domain.Person;
import co2103.hw2.domain.UserKind;
import co2103.hw2.repository.BookingRepository;
import co2103.hw2.repository.HotelRepository;
import co2103.hw2.repository.PersonRepository;

@SpringBootApplication
public class Hw2Application implements ApplicationRunner {

	@Autowired
	private HotelRepository hotelreposits;
	
	@Autowired
	private PersonRepository personreposits;
	
	@Autowired
	private BookingRepository bookingreposits;
	
	@Autowired
	private PasswordEncoder pe;
	
	public static Person user;

	public static void main(String[] args) {
		SpringApplication.run(Hw2Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Hotel h1 = new Hotel("Hilton", "by the lake");
		Hotel h2 = new Hotel("Ibis", "behind the station");
		h1 = hotelreposits.save(h1);
		h2 = hotelreposits.save(h2);

		user = new Person("Manfred", "manager", pe.encode("password"), UserKind.Manager);
		user=personreposits.save(user);

		Person p1 = new Person("Steven", "staff1", pe.encode("password"), UserKind.Staff);
		h1.getStaff().add(p1);
		p1=personreposits.save(p1);
		hotelreposits.save(h1);
		

		Person p2 = new Person("Stas", "staff2", pe.encode("password"), UserKind.Staff);
		h2.getStaff().add(p2);
		p2=personreposits.save(p2);
		hotelreposits.save(h1);

		Person p3 = new Person("Gavin", "guest", pe.encode("password"), UserKind.Guest);
		p3=personreposits.save(p3);
		
		Booking b = new Booking();
		b=bookingreposits.save(b);
		b.setHotel(h1);
		b=bookingreposits.save(b);
		h1.getBookings().add(b);
		hotelreposits.save(h1);
		b.getGuests().add(p3);
		b=bookingreposits.save(b);
		
		

	}

}
