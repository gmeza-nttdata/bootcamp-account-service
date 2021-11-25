package com.nttdata.bootcamp.accountservice.infraestructure.repository;

import com.nttdata.bootcamp.accountservice.domain.Account;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nttdata.bootcamp.accountservice.application.model.AccountRepository;
import com.nttdata.bootcamp.accountservice.infraestructure.model.dao.AccountDao;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class AccountCrudRepository implements AccountRepository{
	
	@Autowired
	IAccountCrudRepository repository;

	@Override
	public Mono<Account> getNumber(String number) {
		return repository.findById(number)
				.map(this::mapAccountDaoToAccount);
	}

	@Override
	public Flux<Account> getAll() {
		return repository.findAll()
				.map(this::mapAccountDaoToAccount);
	}

	@Override
	public Mono<Account> saveAccount(Account account) {
		return repository.save(mapAccountToAccountDao(account))
				.map(this::mapAccountDaoToAccount);
	}

	@Override
	public Mono<Account> updateAccount(Mono<Account> account, String number) {
		return repository.findById(number)
				.flatMap(p->account.map(this::mapAccountToAccountDao)
						.doOnNext(e->e.setNumber(number)))
				.flatMap(repository::save)
				.map(this::mapAccountDaoToAccount);
	}

	@Override
	public Mono<Void> deleteAccount(String number) {
		return repository.deleteById(number);
		
	}
	
	private Account mapAccountDaoToAccount(AccountDao accountDao) {
		Account account = new Account();
		/*account.setNumber(accountDao.getNumber());
		account.setAccountType(accountDao.getAccountType());
		account.setCurrencyName(accountDao.getCurrencyName());
		account.setAmount(accountDao.getAmount());*/
		BeanUtils.copyProperties(accountDao, account);
		return account;
	}
	
	private AccountDao mapAccountToAccountDao(Account account) {
		AccountDao accountDao = new AccountDao();
		/*accountDao.setNumber(account.getNumber());
		accountDao.setAccountType(account.getAccountType());
		accountDao.setCurrencyName(account.getCurrencyName());
		accountDao.setAmount(account.getAmount());*/
		BeanUtils.copyProperties(account, accountDao);
		return accountDao;
	}

}
