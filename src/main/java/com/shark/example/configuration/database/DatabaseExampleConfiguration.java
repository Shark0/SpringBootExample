package com.shark.example.configuration.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

@Configuration
@ConfigurationProperties("spring.datasource.example")
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "exampleEntityManagerFactory",
        transactionManagerRef = "exampleTransactionManager",
        basePackages = {"com.shark.example.dao.example.repository"}
)
public class DatabaseExampleConfiguration extends HikariConfig {

    public final static String PERSISTENCE_UNIT_NAME = "example";

    @Primary
    @Bean(name = "exampleDataSource")
    public HikariDataSource dataSource() {
        return new HikariDataSource(this);
    }

    @Primary
    @Bean(name = "exampleEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            @Qualifier("exampleDataSource") final HikariDataSource dataSource) {

        return new LocalContainerEntityManagerFactoryBean() {{
            setDataSource(dataSource);
            setPersistenceProviderClass(HibernatePersistenceProvider.class);
            setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
            setPackagesToScan("com.shark.example.dao.example");
//            setJpaProperties(JPA_PROPERTIES);
        }};
    }

    @Primary
    @Bean("exampleTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("exampleEntityManagerFactory") final EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
