package com.nttdata.bootcamp.project1.accounts.infraestructure.mockRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.nttdata.bootcamp.project1.accounts.domain.AccountType;
import org.springframework.stereotype.Component;

import com.nttdata.bootcamp.project1.accounts.application.model.AccountRepository;
import com.nttdata.bootcamp.project1.accounts.domain.Account;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MockRepository implements AccountRepository{

	@Override
	public Mono<Account> getNumber(String number) {
		Account liability = new Account();
		liability.setNumber("123-0544581-0254");
		liability.setType(AccountType.CURRENT);
		liability.setCurrencyName("Soles");
		liability.setAmount(BigDecimal.valueOf(25145.38));
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Account> updateAccount(Mono<Account> account, String number) {
		// TODO Auto-generated method stub
		return null;
	}

}
