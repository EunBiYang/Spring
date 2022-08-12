package aop08;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
public class AdviceEx {

	// @Pointcut = 실행시킬 핵심 사항 함수를 정의
	@Pointcut("execution(* zeroMethod(..))")
	public void myClass() {
	}

	@Before("myClass()")
	public void before(JoinPoint joinPoint) {
		System.out.println("Joinpoint 앞에 실행되는 Adivice");
	}

	@Around("myClass()")
	public void around(ProceedingJoinPoint joinPoint) {
		System.out.println("Joinpoint 양쪽의 전에 실행되는 Advice" );
		try {
			joinPoint.proceed();
		} catch (Throwable e) {
			//e.printStackTrace();
		}
		System.out.println("Joinpoint 양쪽의 전에 실행되는 Advice" );
	}
	
	
	@AfterThrowing(pointcut ="myClass()", throwing = "e")
	public void afterThrowing(Throwable e) {
		System.out.println("예외가 발생했을 때 실행되는 Advice");
		System.out.println(e.getMessage());
	}
	
	@AfterReturning("myClass()")
	public void afterReturning() {
		System.out.println("Joinpoint 뒤에서 실행되는 Advice");
	}
	/*
	@AfterReturning(pointcut="myClass()",ref="" )
	public void afterReturning() {
		System.out.println("Joinpoint 뒤에서 실행되는 Advice");
	}
*/
	@After("myClass()")
	public void after(JoinPoint joinPoint) {
		System.out.println("joinpoint가 정상 종료후 실행되는 Advice");
	}
	


}
