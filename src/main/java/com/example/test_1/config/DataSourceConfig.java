package com.example.test_1.config;

import org.apache.ignite.IgniteJdbcThinDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

import org.apache.ignite.IgniteJdbcThinDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Configuration
public class DataSourceConfig {

  private static final Logger log = LoggerFactory.getLogger(DataSourceConfig.class);

  @Value("${spring.datasource.url}")
  private String url;

  @Value("${spring.datasource.username}")
  private String username;

  @Value("${spring.datasource.password}")
  private String password;

  @Value("${spring.datasource.driver-class-name}")
  private String driverClassName;

  // Bean for Ignite DataSource connection
  @Bean
  public DataSource dataSource() throws SQLException {
    IgniteJdbcThinDataSource dataSource = new IgniteJdbcThinDataSource();
    dataSource.setUrl(url);
    dataSource.setUsername(username);
    dataSource.setPassword(password);

    // Test connection to Ignite
    try (Connection connection = dataSource.getConnection()) {
      Statement stmt = connection.createStatement();
      stmt.executeQuery("SELECT 1");
      log.info("Connection to Apache Ignite was successful.");
    } catch (SQLException e) {
      log.error("Failed to connect to Apache Ignite.", e);
      throw e; // Rethrow exception to ensure app doesn't start if Ignite is not reachable
    }

    log.info("Ignite data source initialized");
    return dataSource;
  }
}
