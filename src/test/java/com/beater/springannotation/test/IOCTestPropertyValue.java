package com.beater.springannotation.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.beater.springannotation.bean.Person;
import com.beater.springannotation.config.MainConfigOfPropertyValue;

public class IOCTestPropertyValue {
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValue.class);
	
	@Test
	public void test01(){
		//printBeans(applicationContext);
		Person person = (Person) applicationContext.getBean("person");
		System.out.println(person);
	}
	
	private void printBeans(ApplicationContext applicationContext) {
		String[] names = applicationContext.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
	}
}
