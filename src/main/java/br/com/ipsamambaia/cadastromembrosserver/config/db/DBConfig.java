package br.com.ipsamambaia.cadastromembrosserver.config.db;

import java.net.URISyntaxException;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// TODO: douglas - altrar estratégia de datasource
//@Configurationa
public class DBConfig {

//    @Bean
//    @Primary
//    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() throws URISyntaxException {
        return DataSourceBuilder
            .create()
            .url(System.getenv("JDBC_DATABASE_URL"))
            .username(System.getenv("JDBC_DATABASE_USERNAME"))
            .password(System.getenv("JDBC_DATABASE_PASSWORD"))
            .build();
    }
}
