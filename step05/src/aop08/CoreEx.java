package aop08;

public class CoreEx {
	
	public void zeroMethod(int a, int b) {
		try {
			System.out.println(a+" / "+ b +" = "+ (a/b));
		}catch(Exception e) {
			System.out.println("0으로 나눌수 없습니다.");
		}
	}

}
