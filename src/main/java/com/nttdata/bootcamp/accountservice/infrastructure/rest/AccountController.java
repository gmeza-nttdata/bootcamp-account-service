package com.nttdata.bootcamp.accountservice.infrastructure.rest;

import com.nttdata.bootcamp.accountservice.application.AccountOperations;
import com.nttdata.bootcamp.accountservice.domain.Account;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
	
    private final AccountOperations operations;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<ResponseEntity<Flux<Account>>> get() {
		return Mono.just(ResponseEntity.ok(operations.queryAll()));
	}

	@GetMapping(value = "/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<ResponseEntity<Account>> getNumber(@PathVariable String number) {
		return Mono.just(number)
				.flatMap(operations::findNumber)
				.map(ResponseEntity::ok)
				.switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<ResponseEntity<Account>> post(@RequestBody Account entity) {

		log.info("Creating account: " + entity.toString());

		return Mono.just(entity)
				.doOnNext(e -> e.setNumber(null))
				.flatMap(operations::create)
				.map(this::postResponse);
	}

	@PutMapping(value = "/{number}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<ResponseEntity<Account>> put(@PathVariable String number, @RequestBody Mono<Account> entity) {
		return operations.findNumber(number)
				.flatMap(a -> operations.update(number, entity))
				.map(this::postResponse)
				.defaultIfEmpty(ResponseEntity.notFound().build())
				.onErrorReturn(ResponseEntity.badRequest().build());
	}

	@PatchMapping(value = "/{number}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<ResponseEntity<Account>> patch(@PathVariable String number, @RequestBody Account entity) {
		return operations.findNumber(number)
				.doOnNext(a -> a.setBalance(entity.getBalance()))
				.flatMap(a -> operations.update(number, Mono.just(a)))
				.map(this::postResponse)
				.defaultIfEmpty(ResponseEntity.notFound().build())
				.onErrorReturn(ResponseEntity.badRequest().build());
	}

	@DeleteMapping("/{number}")
	public Mono<ResponseEntity<Void>> delete(@PathVariable String number) {
		return operations.findNumber(number)
				.flatMap(account -> operations.delete(account.getNumber())
						.thenReturn(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	private ResponseEntity<Account> postResponse(Account account) {
		return ResponseEntity.created(URI.create("/accounts/" + account.getNumber())).body(account);
	}

}
