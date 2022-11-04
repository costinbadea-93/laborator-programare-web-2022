package config;

import beans.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ContextConfiguration {

    @Bean(name = "BMW")
    @Primary
    public Car bmw() {
        return new Car("BMW", "BLACK");
    }

    @Bean
    public Car audi() {
        return new Car("Audi", "RED");
    }
}
