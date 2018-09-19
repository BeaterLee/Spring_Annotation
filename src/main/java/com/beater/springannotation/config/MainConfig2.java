package com.beater.springannotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.beater.springannotation.bean.Color;
import com.beater.springannotation.bean.ColorFactoryBean;
import com.beater.springannotation.bean.Person;
import com.beater.springannotation.bean.Red;
import com.beater.springannotation.condition.LinuxCondition;
import com.beater.springannotation.condition.MyImportBeanDefinitionRegistrar;
import com.beater.springannotation.condition.MyImportSelector;
import com.beater.springannotation.condition.WindowsCondition;

@Configuration
//类中组件统一设置。满足当前条件，这个类中配置的所有bean注册才能生效；
@Conditional(WindowsCondition.class)
@Import({Color.class,Red.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {

	@Bean("person")
	public Person getPerson() {
		return new Person("Ming", 12);
	}
	
	/**
	 * @Conditional({Condition}) ： 按照一定的条件进行判断，满足条件给容器中注册bean
	 * 
	 * 如果系统是windows，给容器中注册("bill")
	 * 如果是linux系统，给容器中注册("linus")
	 */
	@Bean("BillGates")
	//除了注解到方法上之外，@Conditional还能注解到类上，类中组件统一设置。满足当前条件，这个类中配置的所有bean注册才能生效；
	public Person getBillGates() {
		return new Person("BillGates", 62);
	}
	
	@Bean("Linus")
	@Conditional(LinuxCondition.class)
	public Person getLinus() {
		return new Person("Linus", 49);
	}
	
	/**
	 * 给容器中注册组件；
	 * 1）、包扫描+组件标注注解（@Controller/@Service/@Repository/@Component）[自己写的类]
	 * 2）、@Bean[导入的第三方包里面的组件]
	 * 3）、@Import[快速给容器中导入一个组件]
	 * 		1）、@Import(要导入到容器中的组件)；容器中就会自动注册这个组件，id默认是全类名
	 * 		2）、ImportSelector:返回需要导入的组件的全类名数组；
	 * 		3）、ImportBeanDefinitionRegistrar:手动注册bean到容器中
	 * 4）、使用Spring提供的 FactoryBean（工厂Bean）;
	 * 		1）、默认获取到的是工厂bean调用getObject创建的对象
	 * 		2）、要获取工厂Bean本身，我们需要给id前面加一个&
	 * 			&colorFactoryBean
	 */
	@Bean("colorByFactoryBean")
	public ColorFactoryBean colorFactoryBean() {
		return new ColorFactoryBean();
	}
}
