package br.com.databases.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "appEntityManagerFactory", transactionManagerRef= "appTransactionManager", basePackages = {
    "br.com.databases.repository" })
public class ApplicationDatabaseConfig {

    @Bean(name = "appDataSource")
    public DataSource appDataSource(@Qualifier("availableDataSources") DataSource datasource) {
        return datasource;
    }

    @Bean(name = "appEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean appEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("appDataSource") DataSource appDataSource) {
        return builder
                .dataSource(appDataSource)
                .packages("br.com.databases.entity")
                .build();
    }

    @Bean(name = "appTransactionManager")
    public PlatformTransactionManager appTransactionManager(
            @Qualifier("appEntityManagerFactory") EntityManagerFactory appEntityManagerFactory) {
        return new JpaTransactionManager(appEntityManagerFactory);
    }

    public String getDatabaseName() {
        String[] arr = DatabaseContextHolder.getDatabaseCredential().getUrl().split("/");
        return arr[arr.length -1];
    }

}
