package com.rafaelmattia.demo.controller;

import com.rafaelmattia.demo.entity.Address;
import com.rafaelmattia.demo.entity.Person;
import com.rafaelmattia.demo.entity.PersonAddressDTO;
import com.rafaelmattia.demo.service.PersonAddressDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/personaddress")
public class PersonAddressDTOController {
    @Autowired
    private PersonAddressDTOService personAddressDTOService;

    @PostMapping("/saveperson")
    public Person savePersonWithAddress(@RequestBody PersonAddressDTO personAddressDTO) {
        return personAddressDTOService.savePersonWithAddress(personAddressDTO);
    }

    @PostMapping("/saveaddress/{id}")
    public Address saveAddress(@RequestBody Address address, @PathVariable Long id) {
       return personAddressDTOService.saveAddress(address, id);
    }
}
