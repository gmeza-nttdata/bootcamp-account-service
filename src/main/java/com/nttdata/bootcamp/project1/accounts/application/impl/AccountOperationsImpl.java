package com.nttdata.bootcamp.project1.accounts.application.impl;

import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.project1.accounts.application.AccountOperations;
import com.nttdata.bootcamp.project1.accounts.application.model.AccountRepository;
import com.nttdata.bootcamp.project1.accounts.domain.Account;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AccountOperationsImpl implements AccountOperations{
	
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
