package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class CouponControllerTest {
	
	@Autowired
	TestRestTemplate restTemplate;

	@Test
	public void testCall() throws Exception {
		ResponseEntity<String> test = restTemplate.getForEntity("/test", String.class);
		//System.out.println("test call >>" + test);
		assertThat(test.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(test.getBody().equals("test"));
	}

}
