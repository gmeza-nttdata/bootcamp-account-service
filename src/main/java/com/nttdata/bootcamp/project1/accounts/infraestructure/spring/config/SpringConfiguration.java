package com.nttdata.bootcamp.project1.accounts.infraestructure.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nttdata.bootcamp.project1.accounts.application.model.AccountRepository;
import com.nttdata.bootcamp.project1.accounts.infraestructure.repository.AccountCrudRepository;

@Configuration
public class SpringConfiguration {

	@Bean
	public AccountRepository repository() {
		return new AccountCrudRepository();
	}
	
}
