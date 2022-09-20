package br.com.lucasladeira.taxaselicanualapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class TaxaSelicAnualApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxaSelicAnualApiApplication.class, args);
	}

}
