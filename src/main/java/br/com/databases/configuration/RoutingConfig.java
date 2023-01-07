package br.com.databases.configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import br.com.databases.router.entity.DatabaseCredential;
import br.com.databases.router.entity.dto.DatabaseCredentialDTO;
import br.com.databases.router.repository.DatabaseCredentialRepository;

@Configuration
public class RoutingConfig {

    private DataSource buildDataSource(DatabaseCredentialDTO dbCredential) {
        DriverManagerDataSource dmds = new DriverManagerDataSource(
                dbCredential.getUrl(),
                dbCredential.getUsername(),
                dbCredential.getPassword());
        dmds.setDriverClassName("org.postgresql.Driver");

        return dmds;
    }

    @Bean
    public DataSource availableDataSources(DatabaseCredentialRepository databaseCredentialRepository) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        Boolean firstIteration = Boolean.TRUE;
        DataSourceRouter router = new DataSourceRouter();
        List<DatabaseCredential> databases = databaseCredentialRepository.findAll();
        DataSource defaultDataSource = null;
        System.out.println("\n");

        for(DatabaseCredential database : databases) {
            DatabaseCredentialDTO dbCredential = new DatabaseCredentialDTO(database);
            DataSource dataSource = buildDataSource(dbCredential);
            targetDataSources.put(dbCredential, dataSource);
            System.out.println("Banco registrado: " + dbCredential.getUrl());
            if(firstIteration) {
                defaultDataSource = dataSource;
            }
        }

        System.out.println("\n");
        router.setTargetDataSources(targetDataSources);
        router.setDefaultTargetDataSource(defaultDataSource);

        return router;
    }

}
