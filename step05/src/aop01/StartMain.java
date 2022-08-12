package aop01;

public class StartMain {
	public static void main(String[] args) {
		Woman w = new Woman();
		Man m = new Man();
		
		w.classwork();
		System.out.println("--------------");
		
		m.classwork();		
	}
}
