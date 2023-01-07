package br.com.databases.router.entity.dto;

import br.com.databases.router.entity.DatabaseCredential;

public class DatabaseCredentialDTO {

    private Long id;
    private CompanyDTO company;
    private String url;
    private String username;
    private String password;

    public DatabaseCredentialDTO() {
    }

    public DatabaseCredentialDTO(DatabaseCredential databaseCredential) {
        this.id = databaseCredential.getId();
        this.company = new CompanyDTO(databaseCredential.getCompany());
        this.url = databaseCredential.getUrl();
        this.username = databaseCredential.getUsername();
        this.password = databaseCredential.getPassword();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DatabaseCredentialDTO other = (DatabaseCredentialDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}
