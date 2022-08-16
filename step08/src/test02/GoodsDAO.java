package test02;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class GoodsDAO {
	// sql문을 읽어와서, 미완성 부분을 완성시킨후, db에 처리를 요청하고, 응답온 데이터를 처리하는 클래스
	// => PreparedStatement 클래스와 비슷한 동작을 함
	@Autowired
	private SqlSessionTemplate sqlSession;		
	
	// 책 등록
	public int insertGoods(GoodsVO vo) {		
		return sqlSession.insert("mybatis.goodsMapper.insertGoods", vo);
	}
	
	// 책 수정
	public int updateGoods(GoodsVO vo) {		
		return sqlSession.update("mybatis.goodsMapper.updateGoods", vo);
	}
	
	// 책 삭제
	public int deleteGoods(String code) {
		return sqlSession.delete("mybatis.goodsMapper.deleteGoods", code);
	}
	
	// 책 상세 조회
	public GoodsVO getGoods(String code) {
		return sqlSession.selectOne("mybatis.goodsMapper.getGoods", code);
	}
	
	// 책 목록 조회
	public List<GoodsVO> getGoodsList() {
		return sqlSession.selectList("mybatis.goodsMapper.getGoodsList");
	}
}
