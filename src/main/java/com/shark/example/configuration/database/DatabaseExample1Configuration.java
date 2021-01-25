package com.shark.example.configuration.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

@Configuration
@ConfigurationProperties("spring.datasource.example1")
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "example1EntityManagerFactory",
        transactionManagerRef = "example1TransactionManager",
        basePackages = {"com.shark.example.dao.example1.repository"}
)
public class DatabaseExample1Configuration extends HikariConfig {

    public final static String PERSISTENCE_UNIT_NAME = "example1";

    @Bean(name = "example1DataSource")
    public HikariDataSource dataSource() {
        return new HikariDataSource(this);
    }

    @Bean(name = "example1EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            @Qualifier("example1DataSource") final HikariDataSource dataSource) {

        return new LocalContainerEntityManagerFactoryBean() {{
            setDataSource(dataSource);
            setPersistenceProviderClass(HibernatePersistenceProvider.class);
            setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
            setPackagesToScan("com.shark.example.dao.example1");
//            setJpaProperties(JPA_PROPERTIES);
        }};
    }

    @Bean("example1TransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("example1EntityManagerFactory") final EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
