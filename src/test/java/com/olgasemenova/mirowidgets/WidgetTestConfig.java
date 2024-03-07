package com.olgasemenova.mirowidgets;

import com.olgasemenova.mirowidgets.repository.InMemoryRepository;
import com.olgasemenova.mirowidgets.repository.WidgetRepository;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

@TestConfiguration
class WidgetTestConfig {

    @Bean
    @Primary
    Clock clock() {
        Instant instant = Instant.parse("2007-12-03T10:15:30.00Z");
        return Clock.fixed(instant, ZoneId.systemDefault());
    }

    @Bean
    WidgetRepository inMemoryWidgetRepository() {
        return new InMemoryRepository();
    }
}