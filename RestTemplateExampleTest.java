package com.example.mockito;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.given;



@ExtendWith(MockitoExtension.class)
public class RestTemplateExampleTest {

    @Mock
    private RestTemplateFactoryForMyApp restTemplateFactoryForMyApp=mock(RestTemplateFactoryForMyApp.class);;

    @InjectMocks
    private RestTemplateExample restTemplateExample ;
    
	private final RestTemplate restTemplate = mock(RestTemplate.class);

    
    
	@BeforeEach
	void setUp() throws Exception {
	   given(restTemplateFactoryForMyApp.restTemplate()).willReturn(restTemplate);
		ReflectionTestUtils.setField(restTemplateExample, "id", 1);
	}

    @Test
    public void mock_resttemplate() {
    	TodosObject todosObject = new TodosObject();
    	todosObject.setId(1);
    	
    	
    	System.out.println(" restTemplateFactoryForMyApp "  + restTemplateFactoryForMyApp.restTemplate());
    	
    	int i = (int) ReflectionTestUtils.getField(restTemplateExample, "id");
    	
    	System.out.println( " value of i " + i);
    	
        Mockito
          .when(restTemplateFactoryForMyApp.restTemplate().exchange(
        		"https://jsonplaceholder.typicode.com/todos/" + i,
                HttpMethod.GET,
                null,
                TodosObject.class
        ))
          .thenReturn(new ResponseEntity<TodosObject>(todosObject, HttpStatus.OK));
 
        TodosObject todosObject2 =   restTemplateExample.m1();// Actual call happens .How to avoid it.**
        System.out.println( " in here test  - " + todosObject2.getId());
       assertEquals(todosObject.getId(), todosObject2.getId());
    }
}