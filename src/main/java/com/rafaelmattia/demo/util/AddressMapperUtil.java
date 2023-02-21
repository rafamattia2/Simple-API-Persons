package com.rafaelmattia.demo.util;

import com.rafaelmattia.demo.dto.*;
import com.rafaelmattia.demo.entity.Address;
import com.rafaelmattia.demo.entity.Person;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AddressMapperUtil {
    public static Address map(AddressForm addressForm) {
        Address address = new Address();
        address.setRoad(addressForm.road());
        address.setCep(addressForm.cep());
        address.setNumber(addressForm.houseNumber());
        address.setCity(addressForm.city());
        return address;
    }
    public static AddressDetails mapToDetails(Address address) {

        Set<Person> setPersons = address.getPersons();
        Set<PersonDescription> personsDescriptionSet = null;
        if (setPersons != null){
           personsDescriptionSet = address.getPersons().stream()
                    .map(person -> PersonMapperUtil.mapToDescription(person))
                    .collect(Collectors.toSet());
        }

        AddressDetails addressDetails = new AddressDetails(
                address.getId(),
                address.getRoad(),
                address.getCep(),
                address.getCity(),
                address.getNumber(),
                personsDescriptionSet
        );

        return addressDetails;
    }

    public static AddressDescription mapToDescription(Address address) {
        AddressDescription addressDescription = new AddressDescription(
                address.getId(),
                address.getRoad(),
                address.getCep(),
                address.getCity(),
                address.getNumber()
        );
        return addressDescription;
    }
}
