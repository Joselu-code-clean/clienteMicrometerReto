package com.example.clienteMicrometerReto.service;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;




public class ClienteService {

	Logger logger = LoggerFactory.getLogger(ClienteService.class);
	
	RestTemplate restTemplate = new RestTemplate();
	String urlBase = "http://localhost:8080/";
	String writeEndPoint = "estados/writer";
	

	
	
	public void setToOpen() {
		String fooResourceUrl = urlBase+writeEndPoint;
		ResponseEntity<String> response = restTemplate.postForEntity(URI.create(fooResourceUrl), "open", String.class);
		logger.info("Estado ---- open" );

	}
	
	public void setToClose() {
		String fooResourceUrl = urlBase+writeEndPoint;
		ResponseEntity<String> response = restTemplate.postForEntity(URI.create(fooResourceUrl), "close", String.class);
		logger.info("Estado ---- close");

	}
	
	public void setToHalfOpen() {
		String fooResourceUrl = urlBase+writeEndPoint;
		ResponseEntity<String> response = restTemplate.postForEntity(URI.create(fooResourceUrl), "half-open", String.class);
		logger.info("Estado ---- half-open");

	}
}
