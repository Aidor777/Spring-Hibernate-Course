package com.lovetocode.springdemo.springbootcrud.dao;

import com.lovetocode.springdemo.springbootcrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// @RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // ... And that's it ! No need to write any code ;)

}
