package com.rafaelmattia.demo;

import com.rafaelmattia.demo.entity.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		Person person = new Person(Long.valueOf("0"), "Nome", "Sobrenome", new Date(2000/03/03));
		String nome = person.getFirstName();
		System.out.println(nome);
	}

}
