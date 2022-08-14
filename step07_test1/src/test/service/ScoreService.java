package test.service;

import java.util.List;

import test.bean.ScoreVO;

public interface ScoreService {
	public int insert_score(ScoreVO vo);
	public int update_score(ScoreVO vo);
	public int delete_score(String studNo);
	public List<ScoreVO> get_scorelist();
}
