package com.beater.springannotation.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector {

	@Override
	// 返回值，就是到导入到容器中的组件全类名
	// AnnotationMetadata:当前标注@Import注解的类的所有注解信息,还包括一些类的信息
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		// TODO Auto-generated method stub
		// 方法可以返回空数组但是不能返回null，返回null会抛异常
		System.out.println("FromMyImportSelector-->" + importingClassMetadata.getClassName());
		return new String[] { "com.beater.springannotation.bean.Blue", "com.beater.springannotation.bean.Yellow" };
	}

}
