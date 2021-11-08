package com.example.miniredditbackend.token;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;



@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entitytoken",
        transactionManagerRef = "tm3",
        basePackages = {
                "com.example.miniredditbackend.token"
        }
)
public class tokenDatabase {

    @Primary
    @Bean(name = "tokendb")
    @ConfigurationProperties(prefix = "tokendatabase.datasource")
    public DataSource tokendb(){
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "entitytoken")
    public LocalContainerEntityManagerFactoryBean entitytoken(EntityManagerFactoryBuilder builder,
                                                          @Qualifier ("tokendb") DataSource datasource){
        return builder.dataSource(datasource).packages("com.example.miniredditbackend.token").persistenceUnit("tokensx").build();
    }

    @Primary
    @Bean(name = "tm3")
    public PlatformTransactionManager tm3(@Qualifier ("entitytoken") EntityManagerFactory entitytoken){
        return new JpaTransactionManager(entitytoken);
    }
}
