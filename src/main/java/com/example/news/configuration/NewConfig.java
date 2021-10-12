package com.example.news.configuration;

import com.example.news.domain.ports.api.NewServicePort;
import com.example.news.domain.ports.spi.NewPersistencePort;
import com.example.news.domain.service.NewServiceImpl;
import com.example.news.infraestructure.adapters.NewJpaAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NewConfig {
    @Bean
    public NewPersistencePort newPersistence() {
        return new NewJpaAdapter();
    }

    @Bean
    public NewServicePort newService() {
        return new NewServiceImpl(newPersistence());
    }
}
