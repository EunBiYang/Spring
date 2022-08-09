package sample2;

public class Foo implements InterFoo {
	public Foo() {
		System.out.println("Foo() 호출");
		System.out.println("-------------");
	}

	public Foo(String str) {
		System.out.println("Foo(String str) 호출");
		System.out.println("str = "+ str);
		System.out.println("-------------");
	}

	public Foo(int num, String str) {
		System.out.println("Foo(int num, String str) 호출");
		System.out.println("num = "+ num);
		System.out.println("str = "+ str);
		System.out.println("-------------");
	}

	public Foo(int num, String str, boolean flag) {
		System.out.println("Foo(int num, String str, boolean flag) 호출");
		System.out.println("num = "+ num);
		System.out.println("str = "+ str);
		System.out.println("flag = "+ flag);
		System.out.println("--------------");
	}
	
	public Foo(Bar bar) {
		System.out.println("Foo(Bar bar) 호출");
		System.out.println("bar = "+ bar);
		System.out.println("--------------");
	}
}
