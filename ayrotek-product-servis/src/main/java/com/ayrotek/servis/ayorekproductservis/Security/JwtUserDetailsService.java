package com.ayrotek.servis.ayorekproductservis.Security;

import com.ayrotek.servis.ayorekproductservis.model.Person;
import com.ayrotek.servis.ayorekproductservis.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private PersonRepository personRepository;

    @Autowired
    public JwtUserDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> userList = personRepository.findByEmail(username);
        if (!userList.isPresent()) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(userList.get());
        }
    }
}