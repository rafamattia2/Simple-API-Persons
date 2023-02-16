package com.rafaelmattia.demo.controller;

import com.rafaelmattia.demo.entity.Person;
import com.rafaelmattia.demo.service.PersonService;
import jakarta.websocket.server.PathParam;
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

    @PutMapping("/{id}")
    public ResponseEntity<Person> put(@RequestBody Person person, @PathVariable Long id){
        return ResponseEntity.ok(personService.put(person, id));
    }


}