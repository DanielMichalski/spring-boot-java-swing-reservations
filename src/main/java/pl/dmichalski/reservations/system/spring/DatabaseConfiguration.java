package pl.dmichalski.reservations.system.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

}
