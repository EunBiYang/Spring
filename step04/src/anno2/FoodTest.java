package anno2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class FoodTest {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("anno2/bean1.xml");
		
		MyFoodMgr mgr = (MyFoodMgr) context.getBean("myFood1");
		System.out.println(mgr.toString());
		System.out.println("-----------------");
		
		MyFoodMgr mgr2 = (MyFoodMgr) context.getBean("myFood2");
		System.out.println(mgr2.toString());
		
		context.close();
	}
}
