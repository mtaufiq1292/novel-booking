package com.shop.novelbooking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
  
    @Bean
    CommandLineRunner initDatabase(NovelRepository repository) {
  
      return args -> {
        log.info("Preloading " + repository.save(new Novel("Abu Bakar - Sahabat Sejati", "Abdul Latip bin Talib")));
        log.info("Preloading " + repository.save(new Novel("Umar Al-Khattab - Reformis Dunia Islam", "Abdul Latip bin Talib")));
      };
    }
}
