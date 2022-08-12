package aop07;

//target : 핵심관심사 클래스
public class MessageBeanImpl implements MessageBean{
	private String name;
	
	@Override
	public void sayHello() {
		try {
			Thread.sleep(3000);	//3초간 프로그램 멈춤!
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Hello,"+name+"!!/핵심관심사");
	}

	//g/s
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
