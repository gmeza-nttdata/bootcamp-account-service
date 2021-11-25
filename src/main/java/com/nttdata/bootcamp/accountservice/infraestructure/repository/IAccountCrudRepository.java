package com.nttdata.bootcamp.accountservice.infraestructure.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.nttdata.bootcamp.accountservice.infraestructure.model.dao.AccountDao;

public interface IAccountCrudRepository extends ReactiveCrudRepository<AccountDao, String>{

}
