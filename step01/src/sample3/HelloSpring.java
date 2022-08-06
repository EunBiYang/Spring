package sample3;

public class HelloSpring {
	public static void main(String[] args) {
		BeanFactory factory = new BeanFactory();
		MessageBean bean = factory.getBean("kr");
		bean.sayHello();
	}
}
