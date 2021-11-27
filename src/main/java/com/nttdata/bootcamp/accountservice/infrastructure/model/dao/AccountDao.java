package com.nttdata.bootcamp.accountservice.infrastructure.model.dao;

import com.nttdata.bootcamp.accountservice.domain.AccountType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Document("account")
public class AccountDao {
	
	@Id
	private String number;
	private Integer userId;
	private AccountType type;
	private String currencyName;
	private BigDecimal balance;

	// Only for Business:
    private List<Integer> holders;
    private List<Integer> signers;

}
