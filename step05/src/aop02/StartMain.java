package aop02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class StartMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("aop02/bean.xml");
		
		Person w = (Person) context.getBean("woman");
		Person m = (Person) context.getBean("man");
		
		w.classwork();
		System.out.println("-------------");
		
		m.classwork();
		
		context.close();
	}
}
