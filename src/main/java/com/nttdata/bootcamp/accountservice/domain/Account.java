package com.nttdata.bootcamp.accountservice.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@Data
public class Account {

	private String number;
	private Integer userId;
	private AccountType type;
	private String currencyName;
	private BigDecimal balance;

	// Only for Business:
    private List<Integer> holders;
    private List<Integer> signers;

}
