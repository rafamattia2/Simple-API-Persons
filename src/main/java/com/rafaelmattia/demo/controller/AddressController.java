package com.rafaelmattia.demo.controller;

import com.rafaelmattia.demo.dto.AddressDescription;
import com.rafaelmattia.demo.dto.AddressDetails;
import com.rafaelmattia.demo.dto.AddressForm;
import com.rafaelmattia.demo.entity.Address;
import com.rafaelmattia.demo.entity.Person;
import com.rafaelmattia.demo.repository.PersonRepository;
import com.rafaelmattia.demo.service.AddressService;
import com.rafaelmattia.demo.util.AddressMapperUtil;
import lombok.AllArgsConstructor;
import lombok.Delegate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/address")
public class AddressController {
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressDetails> create(@RequestBody AddressForm addressForm) {
        Address address = AddressMapperUtil.map(addressForm);
        address = addressService.create(address);
        AddressDetails addressDetails = AddressMapperUtil.mapToDetails(address);
        return ResponseEntity.ok(addressDetails);
    }
    @GetMapping
    public ResponseEntity<Set<AddressDescription>> findAll() {
        Set<AddressDescription> addressDescription = addressService.findAll().stream()
                .map(address -> AddressMapperUtil.mapToDescription(address))
                .collect(Collectors.toSet());
        return ResponseEntity.ok(addressDescription);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AddressDetails> findById(@PathVariable Long id) {
        AddressDetails addressDetails = AddressMapperUtil.mapToDetails(addressService.findById(id));
        return ResponseEntity.ok(addressDetails);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AddressDetails> update(@RequestBody AddressForm addressForm, @PathVariable Long id){
        Address address = AddressMapperUtil.map(addressForm);
        address = addressService.update(address, id);
        AddressDetails addressDetails = AddressMapperUtil.mapToDetails(address);
        return ResponseEntity.ok(addressDetails);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        addressService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
