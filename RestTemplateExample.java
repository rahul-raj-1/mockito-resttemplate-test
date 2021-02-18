package com.example.mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RestTemplateExample {
	
	
	@Autowired
	private RestTemplateFactoryForMyApp restTemplateFactoryForMyApp;
	
	@Value("${urlid}")
	private int id;
	
	
	public TodosObject m1()
	{
		
        System.out.println( " in here 1 " );

        HttpHeaders requestHeaders = new HttpHeaders();

        HttpEntity<HttpHeaders> requestEntity = new HttpEntity<>(requestHeaders);
        
        ResponseEntity<TodosObject> responseEntity = restTemplateFactoryForMyApp.restTemplate().exchange(
        		"https://jsonplaceholder.typicode.com/todos/" + id,
                HttpMethod.GET,
                null,
                TodosObject.class
        );

        
        System.out.println( " in here last user id is " + responseEntity.getBody().getId());
		return responseEntity.getBody();
	}

}
