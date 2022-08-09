package sample7;

import org.springframework.context.support.GenericXmlApplicationContext;

public class EmpMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("sample7/bean.xml");
		
		Emp hong = (Emp)context.getBean("developer");
		System.out.println(hong.toString());
		System.out.println("--------------");
		
		
		Emp lee = (Emp)context.getBean("engineer");
		System.out.println(lee.toString());
		
		
		context.close();
		
	}
}
