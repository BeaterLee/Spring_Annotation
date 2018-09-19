package com.beater.springannotation.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.beater.springannotation.config.MainConfigOfAutowired;
import com.beater.springannotation.service.BookService;

public class IOCTestAutoWired {
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
	
	@Test
	public void test01(){
		printBeans(applicationContext);
		BookService bookService = applicationContext.getBean(BookService.class);
		System.out.println();
	}
	
	private void printBeans(ApplicationContext applicationContext) {
		String[] names = applicationContext.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
	}
}
