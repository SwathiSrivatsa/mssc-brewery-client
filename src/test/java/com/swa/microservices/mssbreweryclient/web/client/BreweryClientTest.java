package com.swa.microservices.mssbreweryclient.web.client;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.swa.microservices.mssbreweryclient.web.model.BeerDto;

@SpringBootTest
class BreweryClientTest {
	
	@Autowired
	BreweryClient client;
	
	@Test
	void testGetBeerById() {
		BeerDto dto= client.getBeerById(UUID.randomUUID());
		
		assertNotNull(dto);
	}
	
	@Test
	void testSaveNewBeer() {
		BeerDto dto=BeerDto.builder().beerName("New Beer").build();
		
		URI uri=client.saveNewBeer(dto);
		assertNotNull(uri);
		System.out.println(uri.toString());
	}
	
	@Test
	void testUpdateBeer() {
		BeerDto dto=BeerDto.builder().beerName("New Beer").build();
		
		client.updateBeer(UUID.randomUUID(), dto);
		
	}
	
	@Test
	void testDeleteBeer() {
		client.deleteBeer(UUID.randomUUID());
	}

}
