package com.rafaelmattia.demo.service;

import com.rafaelmattia.demo.entity.Address;
import com.rafaelmattia.demo.entity.Person;
import com.rafaelmattia.demo.repository.AddressRepository;
import com.rafaelmattia.demo.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AddressService {
    private AddressRepository addressRepository;
    private PersonService personService;
    public Address create(Address address){
        return addressRepository.save(address);
    }
    public List<Address> findAll() {
        return addressRepository.findAll();
    }
    public Address findById(Long id) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        if(addressOptional.isPresent()){
            return addressRepository.findById(id).get();
        }else{
            return null;
        }
    }
    public Address update(Address address, Long id) {
        Address oldAddress= this.findById(id);
        oldAddress.setCep(address.getCep());
        oldAddress.setRoad(address.getRoad());
        oldAddress.setNumber(address.getNumber());
        return addressRepository.save(oldAddress);
    }
    public Address putPersonInAddress(Long addressId, Long personId) {
        Address address = addressRepository.findById(addressId).get();
        Person person = personService.findById(personId);
        address.getPersons().add(person);
        return addressRepository.save(address);
    }
    public void deleteById(Long id) {
        addressRepository.deleteById(id);
    }
}
