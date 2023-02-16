package com.rafaelmattia.demo.repository;

import com.rafaelmattia.demo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAllById (Long id);
}
