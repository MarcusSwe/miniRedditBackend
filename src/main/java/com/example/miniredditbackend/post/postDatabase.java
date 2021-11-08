package com.example.miniredditbackend.post;


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
        entityManagerFactoryRef = "entitypost",
        transactionManagerRef = "tm1",
        basePackages = {
                "com.example.miniredditbackend.post"
        }
)
public class postDatabase {

    @Primary
    @Bean(name = "postdb")
    @ConfigurationProperties(prefix = "postdatabase.datasource")
    public DataSource postdb(){
        return DataSourceBuilder.create().build();
    }


    @Primary
    @Bean(name = "entitypost")
    public LocalContainerEntityManagerFactoryBean entitypost(EntityManagerFactoryBuilder builder,
                                                          @Qualifier ("postdb") DataSource datasource){
        return builder.dataSource(datasource).packages("com.example.miniredditbackend.post").persistenceUnit("postsx").build();
    }


    @Bean(name = "tm1")
    @Primary
    public PlatformTransactionManager tm1(@Qualifier ("entitypost") EntityManagerFactory entitypost){
        return new JpaTransactionManager(entitypost);
    }

}
