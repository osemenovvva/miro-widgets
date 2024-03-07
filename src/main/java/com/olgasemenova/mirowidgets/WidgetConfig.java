package com.olgasemenova.mirowidgets;

import com.olgasemenova.mirowidgets.model.Widget;
import com.olgasemenova.mirowidgets.repository.WidgetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;
import java.util.List;

@Configuration
public class WidgetConfig {

    @Bean
    Clock getClock() {
        return Clock.systemDefaultZone();
    }

    @Bean
    CommandLineRunner commandLineRunner(WidgetRepository widgetRepository, Clock clock) {
        return args -> {
            Widget widget1 = new Widget(
                    2,
                    3,
                    1,
                    30,
                    40,
                    clock
            );
            Widget widget2 = new Widget(
                    2,
                    3,
                    2,
                    30,
                    40,
                    clock
            );

            widgetRepository.saveAllWidgets(List.of(widget1, widget2));
        };
    }
}
