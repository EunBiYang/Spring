package aop02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

//공통관심사항 관리하는 클래스
//MethodInterceptor
public class MyAspect implements MethodInterceptor{
	
	// invoke() : 핵심 관심 사항이 포함된 함수가 호출되면, 그 함수를 가로채는 함수를 매개변수로 전달
	//				MethodInterceptor가 가지고 있다.
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object returnValue = null;
		
		// 대상 메소드 실행전 코드 : Before
		System.out.println("교실문을 연다");
		
		
		try {
			// 대상 메소드 실행 : pointcut
			//invocation.proceed(); = 핵심관심사항이 포함된 코드
			returnValue = invocation.proceed();
		} catch(Exception e) {
			// 대상 메소드 실행 중 예외 발생시 실행되는 코드 : After Throwing
			System.out.println("** 오늘은 소독하는 날 **");
		} finally {
			// 대상 메소드 실행후 코드 : After Returning
			System.out.println("전등이 꺼져 있는지 확인한다.");
		}
		// 대상 메소드 실행후 코드 : After
		System.out.println("교실문을 잠근다.");
		
		return returnValue;
	}

}
