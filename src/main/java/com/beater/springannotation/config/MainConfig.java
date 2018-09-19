package com.beater.springannotation.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.beater.springannotation.bean.Person;

//声明配置类，此类相当于配置文件
@Configuration
//配置自动扫描的包，用法与配置文件类型差不多
//jdk1.8以后可以多次使用该注解来配置多样的自动扫描计划，低于jdk1.8的可以使用@ComponentScans实现此功能
//FilterType.ASSIGNABLE_TYPE:指定具体类
//FilterType.ANNOTATION:指定注解
//FilterType.CUSTOM:指定自定义过滤规则类
@ComponentScan(basePackages = { "com.beater.springannotation" }, includeFilters = {
		//@Filter(type = FilterType.ANNOTATION, classes = { Controller.class }),
		//@Filter(type= FilterType.ASSIGNABLE_TYPE, classes = { BookService.class }),
		@Filter(type=FilterType.CUSTOM,classes= {MyTypeFilter.class})
}, useDefaultFilters = false)
public class MainConfig {

	// 为容器注册一个bean，class即为返回值类型，id在未指定的情况下使用方法名，可通过bean的value属性指定id
	//scope指定bean作用范围
	//ConfigurableBeanFactory.SCOPE_SINGLETON:单实例的（默认值）：ioc容器启动会调用方法创建对象放到ioc容器中。以后每次获取就是直接从容器（map.get()）中拿，
	//ConfigurableBeanFactory.SCOPE_PROTOTYPE：多实例的：ioc容器启动并不会去调用方法创建对象放在容器中。 每次获取的时候才会调用方法创建对象；
	@Scope(scopeName=ConfigurableBeanFactory.SCOPE_SINGLETON)
	//懒加载：单实例bean：默认在容器启动的时候创建对象；懒加载：容器启动不创建对象。第一次使用(获取)Bean创建对象，并初始化；
	@Lazy
	@Bean("person")
	public Person getPerson() {
		return new Person("Ming", 12);
	}
}
