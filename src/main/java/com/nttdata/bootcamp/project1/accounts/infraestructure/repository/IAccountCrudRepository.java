package com.nttdata.bootcamp.project1.accounts.infraestructure.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.nttdata.bootcamp.project1.accounts.infraestructure.model.dao.AccountDao;

public interface IAccountCrudRepository extends ReactiveCrudRepository<AccountDao, String>{

}
