package test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.bean.GoodsVO;
import test.dao.GoodsDAO;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService{
	
	@Autowired
	GoodsDAO dao;//= new GoodsDAO() ,@Autowired사용으로 생략 가능
	
	@Override
	public int insertGoods(GoodsVO vo) {
		return dao.insertGoods(vo);
	}

	@Override
	public int updateGoods(GoodsVO vo) {
		return dao.updateGoods(vo);
	}

	@Override
	public int deleteGoods(String code) {
		return dao.deleteGoods(code);
	}

	@Override
	public GoodsVO getGoods(String code) {
		return dao.getGoods(code);
	}

	@Override
	public List<GoodsVO> getGoodList() {
		return dao.getGoodList();
	}

}
