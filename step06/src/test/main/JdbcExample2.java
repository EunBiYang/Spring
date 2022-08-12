package test.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import test.service.GoodsService;

public class JdbcExample2 {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("bean.xml");
		
		//객체 얻기
		GoodsService gs = (GoodsService)context.getBean("goodsService");
		
		
		String code="p0001";
		int result = gs.deleteGoods(code);
		if(result>0) System.out.println(code+"교재가 삭제 되었습니다.");
		else System.out.println("삭제실패");
		
		
		context.close();
	}

}
