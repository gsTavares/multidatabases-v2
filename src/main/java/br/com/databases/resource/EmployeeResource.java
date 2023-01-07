package br.com.databases.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.databases.entity.dto.EmployeeDTO;
import br.com.databases.service.EmployeeService;

@RestController
@RequestMapping(value = "/api-multidatabase-v2", produces = {MediaType.APPLICATION_JSON_VALUE})
public class EmployeeResource {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/employee")
    public ResponseEntity<Object> save(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.save(employeeDTO);
    }


}
