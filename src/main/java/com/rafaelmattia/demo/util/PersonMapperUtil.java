package com.rafaelmattia.demo.util;

import com.rafaelmattia.demo.dto.PersonDescription;
import com.rafaelmattia.demo.entity.Person;

public class PersonMapperUtil {
    public static PersonDescription map(Person person){
        PersonDescription personDescription = new PersonDescription(
                person.getFirstName(),
                person.getLastName(),
                person.getBirthDate()
        );
        return personDescription;
    }
}
