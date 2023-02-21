package com.rafaelmattia.demo.util;

import com.rafaelmattia.demo.dto.*;
import com.rafaelmattia.demo.entity.Address;
import com.rafaelmattia.demo.entity.Person;

import java.util.Set;
import java.util.stream.Collectors;

public class PersonMapperUtil {
    public static Person map(PersonForm personForm) {
        Person person = new Person();
        person.setFirstName(personForm.firstName());
        person.setLastName(personForm.lastName());
        person.setBirthDate(personForm.birthDate());
        person.setPrincipalAddress(personForm.principalAddress());

        return person;
    }
    public static PersonDescription mapToDescription(Person person){
        PersonDescription personDescription = new PersonDescription(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getBirthDate()
        );
        return personDescription;
    }

    public static PersonDetails mapToDetails(Person person){
        Set<Address> setAddresses = person.getAddresses();
        Set<AddressDescription> addressDescriptionSet = null;
        if (setAddresses != null){
            addressDescriptionSet = person.getAddresses().stream()
                    .map(address -> AddressMapperUtil.mapToDescription(address))
                    .collect(Collectors.toSet());
        }
        PersonDetails personDetails = new PersonDetails(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getBirthDate(),
                AddressMapperUtil.mapToDetails(person.getPrincipalAddress()),
                addressDescriptionSet
        );
        return personDetails;
    }
}
