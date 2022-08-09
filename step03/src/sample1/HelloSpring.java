package sample1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		//1.spring 컨데이너 구동 :
		//xml파일에 설정해놓은 것들을 읽어와서  bean객체 생성
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("sample1/bean.xml");
		
		//2.bean 객체 얻어오기
		MessageBean bean = (MessageBean) context.getBean("messageBean");
		bean.sayHello();
		bean.sayHello("바나나", 6000);
		
		//3.spring 컨테이너 종료
		context.close();
	}

}
