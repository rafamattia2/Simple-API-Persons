package com.rafaelmattia.demo.repository;

import com.rafaelmattia.demo.entity.Person;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Modifying
    @Transactional
    @Query(value = "insert into person_addresses values (:personId, :addressId)", nativeQuery = true)
    void addPersonInAddress(@Param("personId") Long personId, @Param("addressId") Long addressId);

}
