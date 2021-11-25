package com.nttdata.bootcamp.accountservice.application;

import com.nttdata.bootcamp.accountservice.domain.Account;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountOperations {
	
	Flux<Account> queryAll();
	Mono<Account> findNumber(String number);
	Mono<Account> create(Account account);
	Mono<Account> update(String number, Mono<Account> account);
	Mono<Void> delete(String number);

}
