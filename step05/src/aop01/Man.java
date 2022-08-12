package aop01;

public class Man {
	public void classwork() {
		System.out.println("교실문을 연다.");
		
		try {
			//핵심관심사항
			System.out.println("컴퓨터를 켜고 Game을 시작한다.");
		} catch(Exception e) {
			System.out.println("** 오늘은 소독하는 날 **");
		} finally {
			System.out.println("전등이 켜져 있는 지 확인한다.");
		}
		
		
		System.out.println("교실문을 잠근다.");
	}
}
