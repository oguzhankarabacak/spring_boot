package com.oguzhan.repository;

import com.oguzhan.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
}
