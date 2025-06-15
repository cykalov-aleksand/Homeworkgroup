package sky.group.homeworkgroup.configuration;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import sky.group.homeworkgroup.model_dinamicbase.Dinamic;

import javax.sql.DataSource;

@EnableJpaRepositories(
        entityManagerFactoryRef = "bookingEntityManager",
        transactionManagerRef = "bookingTransactionManager",
        basePackages = "sky.group.homeworkgroup.dinamicrepository")
@Configuration
public class TwoConfiguration {
    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource myDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/dinamicBd");
        dataSource.setUsername("GroupWork");
        dataSource.setPassword("123");
        return dataSource;
    }

    @Primary
    @Bean(name = "bookingEntityManager")
    public LocalContainerEntityManagerFactoryBean myEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(myDataSource())
                .packages(Dinamic.class)
                .build();
    }

    @Primary
    @Bean(name = "bookingTransactionManager")
    public PlatformTransactionManager myTransactionManager(@Qualifier("bookingEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
