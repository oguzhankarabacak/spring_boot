package com.oguzhan.repository;

import com.oguzhan.entities.Address;
import com.oguzhan.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Long> {
}
