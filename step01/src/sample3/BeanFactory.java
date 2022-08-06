package sample3;

//2. 팩토리 패턴 이용
//=> 공장에서 물건을 찍어내듯이, 개체를 생성하는 기능의 클래스
public class BeanFactory {
	public MessageBean getBean(String beanName) {
		MessageBean bean = null;
		if(beanName.equals("en")) {
			bean = new MessageBeanEn();
		}else if(beanName.equals("kr")) {
			bean = new MessageBeanKr();
		}
		return bean;
	}
}
