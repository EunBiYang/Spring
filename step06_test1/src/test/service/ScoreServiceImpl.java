package test.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.bean.ScoreVO;
import test.dao.ScoreDAO;

@Service("scoreService")
public class ScoreServiceImpl implements ScoreService{
	
	@Autowired
	ScoreDAO dao;//= new GoodsDAO()

	@Override
	public int insert_score(ScoreVO vo) {
		dao.insert_score(vo);
		return 0;
	}

	@Override
	public List<ScoreVO> get_scorelist() {
		dao.get_scorelist();
		return null;
	}

	@Override
	public int update_score(ScoreVO vo) {
		dao.update_score(vo);
		return 0;
	}

	@Override
	public int delete_score(String studNo) {
		dao.delete_score(studNo);
		return 0;
	}






	
	

}
