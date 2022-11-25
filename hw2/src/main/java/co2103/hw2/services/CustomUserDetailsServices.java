package co2103.hw2.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co2103.hw2.domain.Person;
import co2103.hw2.repository.PersonRepository;

@Service
public class CustomUserDetailsServices implements UserDetailsService{
	
	@Autowired
	private PersonRepository prepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Person p = prepo.findByUsername(username);
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_"+p.getKind()));
		
		
		return new User(p.getUsername(), p.getPassword(), true, 
				true, true, true, authorities);
	}

}
