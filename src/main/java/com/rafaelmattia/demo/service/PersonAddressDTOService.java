package com.rafaelmattia.demo.service;

import com.rafaelmattia.demo.entity.Address;
import com.rafaelmattia.demo.entity.Person;
import com.rafaelmattia.demo.entity.PersonAddressDTO;
import com.rafaelmattia.demo.repository.AddressRepository;
import com.rafaelmattia.demo.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Service
public class PersonAddressDTOService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AddressRepository addressRepository;

    public Person savePersonWithAddress(PersonAddressDTO personAddressDTO) {
        Address address = addressRepository.save(personAddressDTO.getAddress());
        Person person = personAddressDTO.getPerson();
        person.setPrincipalAddress(address);
        Person savedPerson = personRepository.save(person);
        return savedPerson;
    }

    public Address saveAddress(Address address, Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new RuntimeException("Address not found with id: " + id));
        List<Person> personSet = new ArrayList<Person>();
        personSet.add(person);
        address.setPersonAddresses(personSet);
        addressRepository.save(address);
        return address;
    }


}
