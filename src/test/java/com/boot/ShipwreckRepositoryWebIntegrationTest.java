package com.boot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ShipwreckRepositoryWebIntegrationTest {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	public void findAllTest() throws IOException{
		ResponseEntity<String> response = testRestTemplate.getForEntity(
				"http://localhost:8081/api/v1/shipwrecks", String.class);
		
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(response.getBody());
		
		assertThat(jsonNode.isMissingNode(), is(false));
		assertThat(jsonNode.toString(), equalTo("[]"));
	}
}
