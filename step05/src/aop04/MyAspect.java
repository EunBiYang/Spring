package aop04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//@Aspect(공통관심사항) : 설정파일에서 advice 및 pointcut 등을 설정하지 않고 자동으로 adviece 등록
@Aspect
public class MyAspect {
	//<aop:before>
	@Before("execution(public void aop04.*.*(..))")
	public void before(JoinPoint joinPoint) {
		System.out.println("교실문을 연다.");
	}
	
	//<aop:after>
	@After("execution(public void aop04.*.*(..))")
	public void after(JoinPoint joinPoint) {
		System.out.println("교실문을 잠근다.");
	}
	
	//<aop:after-throwing>
	@AfterThrowing(pointcut="execution(public void aop04.*.*(..))", throwing="e")
	public void throwing(JoinPoint joinPoint, Throwable e) {
		System.out.println("**오늘은 소독하는 날.**\n"+e.getMessage());
	}
}
