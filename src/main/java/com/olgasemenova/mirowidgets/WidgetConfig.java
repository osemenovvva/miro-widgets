package com.olgasemenova.mirowidgets;

import com.olgasemenova.mirowidgets.model.Widget;
import com.olgasemenova.mirowidgets.repository.WidgetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class WidgetConfig {
    @Bean
    CommandLineRunner commandLineRunner(WidgetRepository widgetRepository) {
        return args -> {
            Widget widget1 = new Widget(
                    2,
                    3,
                    1,
                    30,
                    40
            );
            Widget widget2 = new Widget(
                    2,
                    3,
                    2,
                    30,
                    40
            );

            widgetRepository.saveAll(List.of(widget1, widget2));
        };
    }
}
