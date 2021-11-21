package com.nttdata.bootcamp.project1.accounts.infraestructure.model.dao;

import com.nttdata.bootcamp.project1.accounts.domain.AccountType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import java.math.BigDecimal;

@Data
@Document("account")
public class AccountDao {
	
	@Id
	private String number;
	private Integer userId;
	private AccountType type;
	private String currencyName;
	private BigDecimal amount;

}
