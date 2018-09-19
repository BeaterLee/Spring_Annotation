package com.beater.springannotation.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Dog {
	public Dog() {
		System.out.println("Dog Constructor..");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Dog Init...");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Dog Destroy...");
	}
}
