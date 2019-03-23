package com.java.spring.core.autowire.xmlconfig;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpAddressSpringEx {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config.xml");

		
        Employee emps = (Employee) ctx.getBean("employee");
		
		emps.printDetails();
		ctx.close();
	}

}
