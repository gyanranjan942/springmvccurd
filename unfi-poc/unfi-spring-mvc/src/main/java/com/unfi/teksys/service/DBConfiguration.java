package com.unfi.teksys.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import javax.sql.DataSource;
@Configuration
public class DBConfiguration {
        @Bean
        public DataSource dataSource() {
            return new EmbeddedDatabaseBuilder()
                    .generateUniqueName(false)
                    .setName("testdb")
                    .setType(EmbeddedDatabaseType.H2)
                    .addDefaultScripts()
                    .setScriptEncoding("UTF-8")
                    .ignoreFailedDrops(true)
                    .build();
        }
        @Bean
        public JdbcTemplate namedParamJdbcTemplate(DataSource dataSource) {
            JdbcTemplate jdbcTemplate =
                    new JdbcTemplate(dataSource);
            return jdbcTemplate;
        }

}
