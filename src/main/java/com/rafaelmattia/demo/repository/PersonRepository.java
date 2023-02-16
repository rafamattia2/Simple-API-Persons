package com.rafaelmattia.demo.repository;

import com.rafaelmattia.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
