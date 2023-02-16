package com.rafaelmattia.demo.repository;

import com.rafaelmattia.demo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
