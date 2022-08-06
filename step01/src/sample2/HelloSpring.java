package sample2;

public class HelloSpring {
	public static void main(String[] args) {
		//다형성으로 작업 : 부모클래스 이름으로 자식클래스 사용
		MessageBean bean = new MessageBeanKr();
		bean.sayHello();
		
	}

}
