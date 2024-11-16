package com.example.test_1.config;


import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.ClientConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IgniteConfig {

    @Bean
    public Ignite igniteInstance() {
        ClientConfiguration cfg = new ClientConfiguration();
        cfg.setAddresses("localhost:10800");  // Ignite thin client connection

        return (Ignite) Ignition.startClient(cfg);
    }
}
