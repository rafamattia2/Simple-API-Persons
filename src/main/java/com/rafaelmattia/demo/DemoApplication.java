package com.rafaelmattia.demo;

import com.rafaelmattia.demo.entity.Person;
import com.rafaelmattia.demo.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	@Bean
	CommandLineRunner commandLineRunner(PersonRepository personRepository){
		return args -> {

			Person person = new Person(
					"Rafael",
					"Mattia",
					LocalDate.of(2020, 11, 20)
			);
			personRepository.save(person);
		};
	}

}
