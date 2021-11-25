package com.nttdata.bootcamp.accountservice.application.impl;

import com.nttdata.bootcamp.accountservice.application.AccountOperations;
import com.nttdata.bootcamp.accountservice.domain.Account;
import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.accountservice.application.model.AccountRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AccountOperationsImpl implements AccountOperations {
	
	private final AccountRepository repository;

	@Override
	public Flux<Account> queryAll() {
		return repository.getAll();
	}

	@Override
	public Mono<Account> create(Account account) {
		return repository.saveAccount(account);
	}

	@Override
	public Mono<Account> update(String number, Mono<Account> account) {
		return repository.updateAccount(account, number);
	}

	@Override
	public Mono<Void> delete(String number) {
		return repository.deleteAccount(number);
	}

	@Override
	public Mono<Account> findNumber(String number) {
		return repository.getNumber(number);
	}

}
