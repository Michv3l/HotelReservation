package co2103.hw2.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co2103.hw2.domain.Hotel;
import co2103.hw2.repository.HotelRepository;

@Controller
@RequestMapping("/h/")
public class HotelController {
	
	@Autowired
	private HotelRepository hotelreposits;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new HotelValidator(hotelreposits));
	}

	@GetMapping("/hotels")
	public String showHotels(Model model) {
		model.addAttribute("hotels", hotelreposits.findAll());
		return "hotels/list";
	}

	@RequestMapping("/newHotel")
	public String newHotel(Model model) {
		model.addAttribute("hotel", new Hotel());
		return "hotels/form";
	}

	@PostMapping("/addHotel")
	public String newHotel(@Valid @ModelAttribute Hotel hotel, BindingResult result) {
		if (result.hasErrors()) {			
			return "hotels/form";	
		}
		hotelreposits.save(hotel);
		return "redirect:/h/hotels";
	}
}
