package technicalblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
public class JpaConfig {

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emfb  = new LocalContainerEntityManagerFactoryBean();
        emfb.setPersistenceXmlLocation("classpath:META-INF/persistence.xml"); //loads ther persistence.xml file
        emfb.afterPropertiesSet(); //reads through the properties and prepares the config

        return emfb.getObject(); //Gets the entity manaager factory object
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://localhost:5432/technicalblog");
        ds.setUsername("postgres");
        ds.setPassword("P@ssw0rd");
        return ds;
    }
}