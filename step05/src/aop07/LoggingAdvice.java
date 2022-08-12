package aop07;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class LoggingAdvice {
	
	//매개변수로 호출을 가로챈 함수를 전달받음
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable{
		// 가로채온 함수 이름 얻어오기
		String methodname = joinPoint.getSignature().getName();
		
		StopWatch sw = new StopWatch(); //시간을 재는 클래스
		
		//around = before + after
		//공통관심사항 : before
		System.out.println("[LOG] METHOD : " + methodname + "is calling.");
		sw.start();
		
		// 핵심 관심사항
		joinPoint.proceed();
		
		//공통관심사항 : after
		sw.stop();
		System.out.println("[LOG] METHOD : " + methodname + "was done.");
		System.out.println("[LOG] 처리시간 : " + sw.getTotalTimeMillis()/1000.0+"초");
	}

}
