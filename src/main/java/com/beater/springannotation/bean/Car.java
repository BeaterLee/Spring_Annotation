package com.beater.springannotation.bean;

import org.springframework.stereotype.Component;

@Component
public class Car {
	public Car() {
		System.out.println("Car Constructor..");
	}
	
	public void init() {
		System.out.println("Car Init...");
	}
	
	public void destroy() {
		System.out.println("Car Destroy...");
	}
}
