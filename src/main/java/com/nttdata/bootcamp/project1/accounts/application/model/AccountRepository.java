package com.nttdata.bootcamp.project1.accounts.application.model;

import com.nttdata.bootcamp.project1.accounts.domain.Account;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountRepository {

	Mono<Account> getNumber(String number);
	Flux<Account> getAll();
	Mono<Account> saveAccount(Account account);
	Mono<Account> updateAccount(Mono<Account> account, String number);
	Mono<Void> deleteAccount(String number);
	
}
