package sample6;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		// 1. spring 컨테이너 구동 : bean 객체 생성
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("sample6/bean.xml");
		
		//2. bean 객체 얻어오기
		MessageBean bean = (MessageBean)context.getBean("messageBean");
		bean.helloCall();
		
		//3. spring 컨테이너 종료
		context.close();
		
	}

}
