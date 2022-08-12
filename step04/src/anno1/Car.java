package anno1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// <bean id="car" class="anno1.Car"/> 와 동일한 설정
// 어노테이션에서 id를 따로 지정하지 않으면, 클래스명의 첫글자가 소문자인 이름을 id로 사용함
@Component
public class Car {
	// <bean id="car" class="anno1.Car">
	//	<property name="tire" ref="test"/>
	// </bean>  와 동일한 설정
	@Autowired   // setter injection, setter를 따로 만들지 않아도 내부적으로 만들어서 사용함
	private Tire tire;
	
	public Car() {		
	}

	public Car(Tire tire) {
		super();
		System.out.println("Car(Tire tire) 호출");
		this.tire = tire;
	}
	
	public void drive() {
		System.out.println(tire.getBrand() + "로 만들어진 국산 자동차");
	}
}
