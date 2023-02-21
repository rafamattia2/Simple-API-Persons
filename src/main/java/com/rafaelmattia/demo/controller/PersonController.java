package com.rafaelmattia.demo.controller;

import com.rafaelmattia.demo.dto.*;
import com.rafaelmattia.demo.entity.Address;
import com.rafaelmattia.demo.entity.Person;
import com.rafaelmattia.demo.repository.AddressRepository;
import com.rafaelmattia.demo.service.AddressService;
import com.rafaelmattia.demo.service.PersonService;
import com.rafaelmattia.demo.util.AddressMapperUtil;
import com.rafaelmattia.demo.util.PersonMapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private PersonService personService;
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<Set<PersonDescription>> findAll() {
        Set<PersonDescription> personDescription = personService.findAll().stream()
                .map(person -> PersonMapperUtil.mapToDescription(person))
                .collect(Collectors.toSet());
        return ResponseEntity.ok(personDescription);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDetails> findById(@PathVariable Long id) {
        PersonDetails personDetails = PersonMapperUtil.mapToDetails(personService.findById(id));
        return ResponseEntity.ok(personDetails);
    }

    @GetMapping("/addresses/{id}")
    public ResponseEntity<Set<AddressDescription>> findAddresses(@PathVariable Long id) {
        Person person = personService.findById(id);
        Set<AddressDescription> addressDescriptionSet = person.getAddresses().stream()
                .map(address -> AddressMapperUtil.mapToDescription(address))
                .collect(Collectors.toSet());
        return ResponseEntity.ok(addressDescriptionSet);
    }

    @GetMapping("/principalAddress/{id}")
    public ResponseEntity<AddressDetails> findPrincipalAddress(@PathVariable Long id) {
        PersonDetails personDetails = PersonMapperUtil.mapToDetails(personService.findById(id));
        return ResponseEntity.ok(personDetails.principalAddressDetails());
    }

    @PostMapping
    public ResponseEntity<PersonDetails> create(@RequestBody PersonForm personForm) {
        Person person = PersonMapperUtil.map(personForm);
        person = personService.create(person);
        PersonDetails personDetails = PersonMapperUtil.mapToDetails(person);
        return ResponseEntity.ok(personDetails);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> put(@RequestBody Person person, @PathVariable Long id) {
        return ResponseEntity.ok(personService.put(person, id));
    }

    @PutMapping("/person/{personId}/address/{addressId}")
    public ResponseEntity<Void> addAddress(@PathVariable Long personId, @PathVariable Long addressId) {
        Person person = personService.findById(personId);
        Address address = addressService.findById(addressId);
        personService.addAddressInPerson(person, address);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        personService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
