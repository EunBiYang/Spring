package aop06;

import org.springframework.stereotype.Component;

@Component
public class Woman implements Person{
//핵심관심사항만 남김
	@Override
	public void classwork() {
		System.out.println("컴퓨터를 켜고 Shopping을 시작한다.");
	}
}