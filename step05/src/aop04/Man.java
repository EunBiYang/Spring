package aop04;

public class Man implements Person{
//핵심관심사항만 남김
	@Override
	public void classwork() {
		System.out.println("컴퓨터를 켜고 Game을 시작한다.");
		System.out.println("result : "+ (15/0));//예외코드
	}
}
