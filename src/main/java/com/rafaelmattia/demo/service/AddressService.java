package com.rafaelmattia.demo.service;

import com.rafaelmattia.demo.entity.Address;
import com.rafaelmattia.demo.repository.AddressRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AddressService {
    private AddressRepository addressRepository;

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Address save (Address address){
        return addressRepository.save(address);
    }

    public List<Address> findAllById(Long id) {
        return addressRepository.findAllById(id);
    }
}
