package com.nttdata.bootcamp.accountservice.infrastructure.spring.config;

import com.nttdata.bootcamp.accountservice.infrastructure.repository.AccountCrudRepository;
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
