package test02;

import java.util.List;

// 목차 역할
public interface GoodsService {
	// 책 등록
	public int insertGoods(GoodsVO vo);
	// 책 수정
	public int updateGoods(GoodsVO vo);
	// 책 삭제
	public int deleteGoods(String code);
	// 책 상세 조회
	public GoodsVO getGoods(String code);
	// 책 목록 조회
	public List<GoodsVO> getGoodsList();
}
