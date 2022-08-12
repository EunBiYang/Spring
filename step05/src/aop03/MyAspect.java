package aop03;

import org.aspectj.lang.JoinPoint;

public class MyAspect {
	//공통 관심사항을 함수로 등록해놓고 xml에 aop로 등록해서 사용
	public void before(JoinPoint joinPoint) {
		System.out.println("교실문을 연다/before 사용");
	}
	
	public void after(JoinPoint joinPoint) {
		System.out.println("교실문을 닫는다./after 사용");
	}
}
