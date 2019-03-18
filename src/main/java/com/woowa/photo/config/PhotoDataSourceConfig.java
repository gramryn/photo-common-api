package com.woowa.photo.config;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * PhotoDataSourceConfig 클래스
 *
 * @author 
 * @version 1.0
 * @since 2019.03.14
 */
@Configuration
@EnableJpaRepositories(
        basePackages = "com.woowa.photo.repository",
        entityManagerFactoryRef = "photoEntityManager",
        transactionManagerRef = "photoTransactionManager"
)
public class PhotoDataSourceConfig {

    private static final Logger logger = getLogger(PhotoDataSourceConfig.class);

    @Value("${datasource.photo.driver-class-name}") String photoDriverClassName;
    @Value("${datasource.photo.url}") String photoUrl;
    @Value("${datasource.photo.username}") String photoUsername;
    @Value("${datasource.photo.password}") String photoPassword;
    @Value("${jpa.hibernate.ddl-auto}") String ddlAuto;
    @Value("${jpa.hibernate.naming.strategy}") String dialect;


    @Bean
    public boolean loggerPrintConfig() {


        logger.info("[PotalConfig]=====================================================================");
        logger.info(photoDriverClassName+"photoDriverClassName");
        logger.info(photoUrl+"photoUrl");
        logger.info(photoUsername+"photoUsername");
        logger.info(photoPassword+"photoPassword");
        logger.info(ddlAuto+"PotalddlAuto");
        logger.info(dialect+"Potaldialect");
        logger.info("==================================================================================");


        return true;
    }


    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean photoEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(photoDataSource());
        em.setPackagesToScan(new String[] { "com.woowa.photo.entity" });

        HibernateJpaVendorAdapter vendorAdapter= new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto",ddlAuto);//validate
        properties.put("hibernate.dialect",dialect);    //hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Primary
    @Bean
    public DataSource photoDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(photoDriverClassName);
        dataSource.setUrl(photoUrl);
        dataSource.setUsername(photoUsername);
        dataSource.setPassword(photoPassword);
        return dataSource;
    }

    @Primary
    @Bean
    public PlatformTransactionManager photoTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(photoEntityManager().getObject());
        return transactionManager;
    }

}
