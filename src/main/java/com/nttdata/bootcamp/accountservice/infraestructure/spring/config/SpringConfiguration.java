package com.nttdata.bootcamp.accountservice.infraestructure.spring.config;

import com.nttdata.bootcamp.accountservice.infraestructure.repository.AccountCrudRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nttdata.bootcamp.accountservice.application.model.AccountRepository;

@Configuration
public class SpringConfiguration {

	@Bean
	public AccountRepository repository() {
		return new AccountCrudRepository();
	}
	
}
