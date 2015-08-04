package com.baselogic.demos.configuration;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class JdbcEmbeddedConfig implements DisposableBean {

    EmbeddedDatabase database = null;

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        database = builder.setType(EmbeddedDatabaseType.H2)
//                .ignoreFailedDrops(true)
//                .continueOnError(false)
//                .addScript("classpath:schema.sql")
//                .addScript("classpath:seed-data.sql")
                .build();
        return database;
    }

    @Override
    public void destroy() {
        if (database != null) {
            database.shutdown();
        }
    }

}
