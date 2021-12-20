package com.itransition.santa.repository;

import com.itransition.santa.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Override
    List<Employee> findAll();

    @Override
    void deleteAll();

    Optional<Employee> findEmployeeByFullName(String fullName);
}
