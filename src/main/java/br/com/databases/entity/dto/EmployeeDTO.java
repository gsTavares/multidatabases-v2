package br.com.databases.entity.dto;

import java.io.Serializable;

import br.com.databases.entity.Employee;
import br.com.databases.router.entity.enumerated.CompanyType;

public class EmployeeDTO implements Serializable {
    
    private Long id;
    private String fullname;
    private String email;
    private String password;
    private CompanyType companyType;
    
    public EmployeeDTO() {
    }

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.fullname = employee.getFullname();
        this.email = employee.getEmail();
        this.password = employee.getPassword();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }    
    
}
