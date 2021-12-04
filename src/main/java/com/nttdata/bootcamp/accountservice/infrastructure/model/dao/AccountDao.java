package com.nttdata.bootcamp.accountservice.infrastructure.model.dao;

import com.nttdata.bootcamp.accountservice.domain.AccountContract;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Document("account")
public class AccountDao {
	/** account number or id. */
	@Id
	private String number;
	/** main holder. */
	private Integer userId;
	/** account type. */
	private String type;
	/** Currency of the account. */
	private String currencyName;
	/** Current Account balance. */
	private BigDecimal balance;
	/** Account Contract. */
	private AccountContract contract;

	// Only for Business:
	/** Holders list. */
	private List<Integer> holders;
	/** Singers list. */
	private List<Integer> signers;


}
