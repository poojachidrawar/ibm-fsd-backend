package com.java.spring.core.xmlconfig;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

@SuppressWarnings("deprecation")
public class EmpAddressSpringEx {

	public static void main(String[] args) {
		
		@SuppressWarnings("deprecation")
		BeanFactory container = new XmlBeanFactory(new ClassPathResource("beans-config.xml"));
		
		Employee emp = (Employee) container.getBean("employee");
		
		emp.getAddress();
		emp.printDetails();


	}

}
