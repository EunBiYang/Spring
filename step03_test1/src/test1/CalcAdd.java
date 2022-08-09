package test1;

public class CalcAdd implements Calc{

	int a;
	int b;
	
	public CalcAdd() {
		
	}
	public CalcAdd(int a, int b) {
		this.a=a;
		this.b=b;
	}
	
	public void calculate() {
		System.out.println(a + "+" + b + " = " + (a+b));
		
	}
}
