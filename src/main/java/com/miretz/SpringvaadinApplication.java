package com.miretz;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringvaadinApplication {

	public static void main(final String[] args) {
		SpringApplication.run(SpringvaadinApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(final ReservationRepository rr) {
		return args -> Stream.of("Julia", "Mia", "Phil", "Dave", "Pieter", "Bridget", "Stéphane", "Josh", "Jennifer")
				.forEach(n -> rr.save(new Reservation(n)));
	}

	@Bean
	HealthIndicator customHealthIndicator() {
		return new HealthIndicator() {
			@Override
			public Health health() {
				return Health.status("I <3 Java!").build();
			}
		};
	}
}
