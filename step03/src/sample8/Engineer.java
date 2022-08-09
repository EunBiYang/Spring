package sample8;

public class Engineer {
	private Emp emp;
	private String dept;
	
	public Engineer(Emp emp, String dept) {
		super();
		this.emp = emp;
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Engineer [emp=" + emp + ", dept=" + dept + "]";
	}
	
}
