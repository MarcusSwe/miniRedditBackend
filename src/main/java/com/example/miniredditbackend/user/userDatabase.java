package com.example.miniredditbackend.user;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        entityManagerFactoryRef = "entityuser",
        transactionManagerRef = "tm2",
        basePackages = {
                "com.example.miniredditbackend.user"
        }
)
public class userDatabase {

    @Bean(name = "userdb")
    @ConfigurationProperties(prefix = "userdatabase.datasource")
    public DataSource userdb(){
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "entityuser")
    public LocalContainerEntityManagerFactoryBean entityuser(EntityManagerFactoryBuilder builder,
                                                          @Qualifier ("userdb") DataSource datasource){
        return builder.dataSource(datasource).packages("com.example.miniredditbackend.user").persistenceUnit("usersx").build();
    }

    @Bean(name = "tm2")
    public PlatformTransactionManager tm2(@Qualifier ("entityuser") EntityManagerFactory entityuser){
        return new JpaTransactionManager(entityuser);
    }
}
