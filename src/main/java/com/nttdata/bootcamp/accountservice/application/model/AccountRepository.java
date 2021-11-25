package com.nttdata.bootcamp.accountservice.application.model;

import com.nttdata.bootcamp.accountservice.domain.Account;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountRepository {

	Mono<Account> getNumber(String number);
	Flux<Account> getAll();
	Mono<Account> saveAccount(Account account);
	Mono<Account> updateAccount(Mono<Account> account, String number);
	Mono<Void> deleteAccount(String number);
	
}
