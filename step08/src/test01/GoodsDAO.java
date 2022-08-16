package test01;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class GoodsDAO {
	//SqlSession = sql문을 읽어와서, 미완성 부분 완성시킨 후, DB에 처리를 요청하고. 응답 온 데이터를 처리하는 클래스
	//pstmt와 비슷한 동작을 한다고 이해하면됨!
	private SqlSession sqlSession;

	public GoodsDAO() {
		sqlSession = SqlMapClientFactory.getSqlMapClientInstance();
	}

	// 책 등록
	public int insertGoods(GoodsVO vo) {
		//						 ↓goods-mapping.xml에서 가져온다.
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
	public List<GoodsVO> getGoodList() {
		return sqlSession.selectList("mybatis.goodsMapper.getGoodList");
	}
}
