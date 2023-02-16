package com.rafaelmattia.demo.service;

import com.rafaelmattia.demo.entity.Address;
import com.rafaelmattia.demo.entity.Person;
import com.rafaelmattia.demo.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PersonService {
    private PersonRepository personRepository;


    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public Person findById(Long id) {
        Optional<Person> personOptional = personRepository.findById(id);
        if(personOptional.isPresent()){
            return personRepository.findById(id).get();
        }else{
            return null;
        }
    }
    public Person put(Person person, Long id) {
        Person oldPerson= this.findById(id);
        oldPerson.setBirthDate(person.getBirthDate());
        oldPerson.setFirstName(person.getFirstName());
        oldPerson.setLastName(person.getLastName());
        oldPerson.setPrincipalAddress(person.getPrincipalAddress());
        return personRepository.save(oldPerson);
    }
}
