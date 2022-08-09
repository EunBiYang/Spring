package sample8;

import org.springframework.context.support.GenericXmlApplicationContext;


public class EmpMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("sample8/bean.xml");
		
		Developer hong = (Developer)context.getBean("developer");
		System.out.println(hong.toString());
		System.out.println("--------------");
		
		
		Engineer lee = (Engineer)context.getBean("engineer");
		System.out.println(lee.toString());
		
		
		context.close();
		
	}

}
