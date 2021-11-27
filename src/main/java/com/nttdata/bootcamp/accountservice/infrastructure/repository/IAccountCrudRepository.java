package com.nttdata.bootcamp.accountservice.infrastructure.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.nttdata.bootcamp.accountservice.infrastructure.model.dao.AccountDao;

public interface IAccountCrudRepository extends ReactiveCrudRepository<AccountDao, String>{

}
