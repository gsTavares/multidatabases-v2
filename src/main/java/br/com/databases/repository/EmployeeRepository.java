package br.com.databases.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.databases.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}
