package test01;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("goodsService")
public class GoodsServiceImpl implements GoodsService{
	
	@Autowired
	GoodsDAO dao;
	
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
