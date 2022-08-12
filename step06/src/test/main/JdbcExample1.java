package test.main;

import org.springframework.context.support.GenericXmlApplicationContext;
import java.util.List;

import test.bean.GoodsVO;
import test.service.GoodsService;

public class JdbcExample1 {
	public static void main(String[] args) {
		//spring 컨테이너 구동 : bean 객체 생성
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("bean.xml");
		
		//sevice 객체 얻기
		GoodsService goodsService = (GoodsService)context.getBean("goodsService");
		
		// 책 등록하기
		GoodsVO vo = new GoodsVO();
		vo.setCode("p0001");
		vo.setName("자바무따기");
		vo.setPrice(25000);
		vo.setMaker("공갈닷컴");
		
		int result = goodsService.insertGoods(vo);
		if(result>0) System.out.println("저장성공");
		else System.out.println("저장실패");
		System.out.println("-------------");
		
		
		//책 목록보기(확장 for문 사용)
		List<GoodsVO> list = goodsService.getGoodList();
		for(GoodsVO goodsVO : list) {
			System.out.println(goodsVO.toString());
		}
		context.close();
	}
}
