package br.com.databases.router.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.databases.router.entity.DatabaseCredential;
import br.com.databases.router.entity.enumerated.CompanyType;

public interface DatabaseCredentialRepository extends JpaRepository<DatabaseCredential, Long> {
    DatabaseCredential findByCompanyType(CompanyType companyType);
}
