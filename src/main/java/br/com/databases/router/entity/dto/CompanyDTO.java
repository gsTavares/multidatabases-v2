package br.com.databases.router.entity.dto;

import br.com.databases.router.entity.Company;
import br.com.databases.router.entity.enumerated.CompanyType;

public class CompanyDTO {
    
    private Long id;
    private String name;
    private CompanyType type;

    public CompanyDTO() {
    }

    public CompanyDTO(Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.type = company.getType();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompanyType getType() {
        return type;
    }

    public void setType(CompanyType type) {
        this.type = type;
    }

    

}
