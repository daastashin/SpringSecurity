package org.example.services;

import org.example.models.Person;
import org.example.repo.PeopleRepository;
import org.example.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person p1 = new Person();
        Person p2 = new Person();
        HashMap<String, Person> map = new HashMap<>();
        p1.setId(1);
        p1.setUsername("username1");
        p1.setPassword("password1");
        p1.setYearOfBirth(1960);
        p2.setId(2);
        p2.setUsername("username2");
        p2.setPassword("password2");
        p2.setYearOfBirth(1970);
        map.put(p1.getUsername(), p1);
        map.put(p2.getUsername(), p2);
        Person person = map.get(username);
        //Optional<Person> person = peopleRepository.findByUsername(username);

/*        if(person.isEmpty())
            throw new UsernameNotFoundException("User not found");*/

        if (person == null) {
            throw new UsernameNotFoundException("User not found!");
        }

        return new PersonDetails(person);
    }

}
