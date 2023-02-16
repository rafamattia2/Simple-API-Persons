package com.rafaelmattia.demo.controller;

import com.rafaelmattia.demo.entity.Address;
import com.rafaelmattia.demo.entity.Person;
import com.rafaelmattia.demo.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class AddressController {
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<List<Address>> findAll() {

        return ResponseEntity.ok(addressService.findAll());
    }
}
