package com.init.edm.database;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Конфигурация для встроенного DataSource.
 *
 * @author GKordyukova
 */
@Configuration
public class DataSourceConfiguration {

    /**
     * Получить встроенный DataSource.
     *
     * @return {@link DataSource} встроенный DataSource
     */
    @Bean
    public DataSource getDataSource() {
        return DataSourceBuilder.create().url("jdbc:derby:ecm;create=true").build();
    }
}
