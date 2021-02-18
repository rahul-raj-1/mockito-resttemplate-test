package com.example.mockito;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@Autowired
	private RestTemplateExample restTemplateExample;

    @GetMapping(value = "/m2")
    public void  getCities() {

    	restTemplateExample.m1();

       
    }
}