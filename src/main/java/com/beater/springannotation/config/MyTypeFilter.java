package com.beater.springannotation.config;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

//自定义过滤规则类
public class MyTypeFilter implements TypeFilter {

	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		// TODO Auto-generated method stub
		//获取类的注解信息
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		//获取当前扫描的类的信息
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		//获取类的资源(类路径)
		Resource resource = metadataReader.getResource();
		//System.out.println("From:" + classMetadata.getClassName());
		if(classMetadata.getClassName().contains("er")) {
			return true;
		}
		return false;
	}

}
