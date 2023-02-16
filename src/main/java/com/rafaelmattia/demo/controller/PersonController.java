package com.rafaelmattia.demo.controller;

import com.rafaelmattia.demo.entity.Address;
import com.rafaelmattia.demo.entity.Person;
import com.rafaelmattia.demo.repository.AddressRepository;
import com.rafaelmattia.demo.service.AddressService;
import com.rafaelmattia.demo.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> findAll() {

        return ResponseEntity.ok(personService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id) {
        return ResponseEntity.ok(personService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person) {
        return ResponseEntity.ok(personService.save(person));
    }

//    @PostMapping("/saveAddress/{id}")
//    public ResponseEntity<Person> saveAdress(@RequestBody Person person, @PathVariable Address address){
//        person.setPrincipalAddress(address);
//        Person personWithAddress = personService.save(person);
//        return ResponseEntity.ok(person);
//
//    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> put(@RequestBody Person person, @PathVariable Long id){
        return ResponseEntity.ok(personService.put(person, id));
    }


}
