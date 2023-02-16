package com.rafaelmattia.demo.controller;

import com.rafaelmattia.demo.entity.Address;
import com.rafaelmattia.demo.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/address")
public class AddressController {
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<List<Address>> findAll() {
        return ResponseEntity.ok(addressService.findAll());
    }

    @PostMapping
    public ResponseEntity<Address> save(@RequestBody Address address) {
        return ResponseEntity.ok(addressService.save(address));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Address>> findAllById(Long id) {
        return ResponseEntity.ok(addressService.findAllById(id));
    }
}
