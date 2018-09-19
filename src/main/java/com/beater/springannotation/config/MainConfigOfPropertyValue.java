package com.beater.springannotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.beater.springannotation.bean.Person;

//声明配置类，此类相当于配置文件
@Configuration
//使用@PropertySource读取外部配置文件中的k/v保存到运行的(!环境变量中!:这意味着可从environment中取出配置文件的值);加载完外部的配置文件以后使用${}取出配置文件的值
@PropertySource({"classpath:PropertyValue.properties"})
public class MainConfigOfPropertyValue {

	@Bean("person")
	public Person getPerson() {
		return new Person();
	}
}
