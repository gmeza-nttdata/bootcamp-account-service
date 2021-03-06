package com.nttdata.bootcamp.accountservice.infrastructure.mockrepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.nttdata.bootcamp.accountservice.domain.Account;
import org.springframework.stereotype.Component;

import com.nttdata.bootcamp.accountservice.application.model.AccountRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MockRepository implements AccountRepository{

	@Override
	public Mono<Account> getNumber(String number) {
		Account liability = new Account();
		liability.setNumber("123-0544581-0254");
		liability.setCurrencyName("Soles");
		liability.setBalance(BigDecimal.valueOf(25145.38));
		return Mono.just(liability);
	}

	@Override
	public Flux<Account> getAll() {
		List<Account> liabilities = new ArrayList<>();
		return Flux.fromIterable(liabilities);
	}

	@Override
	public Mono<Account> saveAccount(Account account) {
		return Mono.just(account);
	}

	@Override
	public Mono<Void> deleteAccount(String number) {
		return null;
	}

	@Override
	public Mono<Account> updateAccount(Mono<Account> account, String number) {
		return null;
	}

}
