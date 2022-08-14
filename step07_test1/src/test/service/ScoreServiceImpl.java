package test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.bean.ScoreVO;
import test.dao.ScoreDAOSpring;

@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {
	@Autowired
	ScoreDAOSpring dao;
	
	@Override
	public int insert_score(ScoreVO vo) {
		return dao.insert_score(vo);
	}

	@Override
	public int update_score(ScoreVO vo) {
		return dao.update_score(vo);
	}

	@Override
	public int delete_score(String studNo) {
		return dao.delete_score(studNo);
	}

	@Override
	public List<ScoreVO> get_scorelist() {
		return dao.get_scorelist();
	}

}
