package test01;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class JdbcExample2 {
   public static void main(String[] args) {
      GenericXmlApplicationContext context = new GenericXmlApplicationContext("bean.xml");

      // 객체 얻기
      GoodsService goodsService = (GoodsService) context.getBean("goodsService");

      // 책 삭제하기
      String code = "p0001";  
      int result = goodsService.deleteGoods(code);

      if (result > 0) System.out.println("삭제 성공");
      else System.out.println("삭제 실패");

      // 책 목록보기
      List<GoodsVO> list = goodsService.getGoodsList();
      for (GoodsVO goodsVO : list) {
         System.out.println(goodsVO.toString());
      }

      context.close();
   }
}