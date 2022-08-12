package test.service;



import java.util.List;

import test.bean.ScoreVO;

//목차 역활
public interface ScoreService {
	// 등록
	public int insert_score(ScoreVO vo);

	// 출력
	public List<ScoreVO> get_scorelist();

	// 수정
	public int update_score(ScoreVO vo);

	// 삭제
	public int delete_score(String studNo);

	

}
