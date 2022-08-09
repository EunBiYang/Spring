package sample2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class FooTestApp {
	public static void main(String[] args) {
		//1. spring 컨테이너 구동 및 bean 객체 생성
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("sample2/bean.xml");
		System.out.println("------------------");
		
		//2.종료
		context.close();
	}
}
