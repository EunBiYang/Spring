package sample4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		//1. 스프링 컨데이너를 구동
		//xml파일에 설정해놓은 것들을 읽어온다.
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("sample4/bean.xml");
		
		//2.bean 객체 얻어오기
		MessageBean bean = (MessageBean)context.getBean("messageBean");
		
		//3. 함수 사용
		bean.sayHello();
		
		//4.스프링 컨테이너 종료
		context.close();
	}

}
