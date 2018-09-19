package com.beater.springannotation.condition;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.beater.springannotation.bean.Rainbow;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	/**
	 * AnnotationMetadata：当前类的注解信息
	 * BeanDefinitionRegistry:BeanDefinition注册类；
	 * 		把所有需要添加到容器中的bean；调用
	 * 		BeanDefinitionRegistry.registerBeanDefinition手工注册进来
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// TODO Auto-generated method stub
		boolean definition1 = registry.containsBeanDefinition("com.beater.springannotation.bean.Red");
		boolean definition2 = registry.containsBeanDefinition("com.beater.springannotation.bean.Blue");
		if (definition1 && definition2) {
			//指定Bean定义信息；（Bean的类型，Bean的作用域等等）
			BeanDefinition beanDefinition = new RootBeanDefinition(Rainbow.class);
			//注册一个Bean，指定bean名
			registry.registerBeanDefinition("rainbow", beanDefinition);
		}
	}

}
