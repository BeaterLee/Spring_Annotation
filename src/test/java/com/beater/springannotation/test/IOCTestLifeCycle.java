package com.beater.springannotation.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.beater.springannotation.bean.Car;
import com.beater.springannotation.config.MainConfigOfLifeCycle;

public class IOCTestLifeCycle {

	
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
		System.out.println("容器创建完成");
		//applicationContext.getBean(Car.class);
		applicationContext.close();
	}
}
