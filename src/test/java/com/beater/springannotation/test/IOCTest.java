package com.beater.springannotation.test;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.beater.springannotation.bean.Person;
import com.beater.springannotation.config.MainConfig;
import com.beater.springannotation.config.MainConfig2;

public class IOCTest {
	//测试FactoryBean
	@Test
	public void test05() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
		Object bean = applicationContext.getBean("colorByFactoryBean");
		System.out.println(bean);
		Object bean2 = applicationContext.getBean("colorByFactoryBean");
		System.out.println(bean == bean2);
	}
	
	//测试Import
	@Test
	public void test04() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
		printBeans(applicationContext);
	}
	
	private void printBeans(ApplicationContext applicationContext) {
		String[] names = applicationContext.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
	}
	
	//该测试测试了Condition条件过滤后的IOC容器所包含的Person类的bean
	@Test
	public void test03() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
		String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
		for (String name : namesForType) {
			System.out.println(name);
		}
	}
	
	@Test
	public void test02() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		Person person1 = applicationContext.getBean(Person.class);
		Person person2 = applicationContext.getBean(Person.class);
		System.out.println(person1 == person2);
	}

	@Test
	public void test01() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		String[] names = applicationContext.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
	}
}
