package sample7;

public class Developer extends Emp{
	private String dept;
	
	public Developer() {
	}
	
	public Developer(String name, int salary) {
		super(name, salary); //부모클래스에 보냄
	}

	@Override
	public String toString() {
		return super.toString()+"[dept=" + dept + "]";
	}

	//getter setter
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
}
