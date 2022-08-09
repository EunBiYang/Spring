package test1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		//1. 스프링 컨테이너 구동		
		GenericXmlApplicationContext context= new GenericXmlApplicationContext("test1/bean.xml");
		
		Calc cal= (Calc)context.getBean("add");
		Calc cal2=(Calc)context.getBean("mul");
		
		cal.calculate();
		cal2.calculate();
		
		context.close();
		/////////////////////////////////////
		// 일반 형식으로 객체 생성
		Calc calc1 = new CalcAdd(30, 40);
		CalcMul calc2 = new CalcMul();
		calc2.setA(30);
		calc2.setB(40);
		
		calc1.calculate();
		calc2.calculate();
	}
	
}
