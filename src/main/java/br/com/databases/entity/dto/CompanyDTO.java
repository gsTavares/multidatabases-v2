package br.com.databases.entity.dto;

import br.com.databases.entity.Company;
import br.com.databases.router.entity.enumerated.CompanyType;

public class CompanyDTO {
    
    private Long id;
    private CompanyType type;
    
    public CompanyDTO() {
    }

    public CompanyDTO(Company company) {
        this.id = company.getId();
        this.type = company.getType();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompanyType getType() {
        return type;
    }

    public void setType(CompanyType type) {
        this.type = type;
    }

    
}
