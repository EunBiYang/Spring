package test1;

public class CalcMul implements Calc {

	int a;
	int b;
	
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	
	public void calculate() {
		System.out.println(getA()+" x "+ getB() + "= "+getA()*getB());		
	}
	
}
