package br.com.databases.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.databases.configuration.DatabaseContextHolder;
import br.com.databases.entity.Employee;
import br.com.databases.entity.dto.EmployeeDTO;
import br.com.databases.repository.EmployeeRepository;
import br.com.databases.router.entity.dto.DatabaseCredentialDTO;
import br.com.databases.router.repository.DatabaseCredentialRepository;

@Service
public class EmployeeService {
    
    @Autowired
    private DatabaseCredentialRepository databaseCredentialRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public ResponseEntity<Object> save(EmployeeDTO employeeDTO) {
        DatabaseContextHolder.set(new DatabaseCredentialDTO(databaseCredentialRepository.findByCompanyType(employeeDTO.getCompanyType())));
        System.out.println(DatabaseContextHolder.getDatabaseCredential().getUrl());
        try {
            Employee employee = new Employee(employeeDTO);
            Employee result = employeeRepository.saveAndFlush(employee);
            return ResponseEntity.ok().body(new EmployeeDTO(result));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        } finally {
            DatabaseContextHolder.clear();
        }
    } 

}
