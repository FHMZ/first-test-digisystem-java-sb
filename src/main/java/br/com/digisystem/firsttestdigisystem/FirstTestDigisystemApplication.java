package br.com.digisystem.firsttestdigisystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class FirstTestDigisystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstTestDigisystemApplication.class, args);
	}

}
