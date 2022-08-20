package test.service;

import java.util.List;

import test.bean.ScoreVO;

public interface ScoreService {
	// 성적 등록
	public int insertScore(ScoreVO vo);

	// 성적 수정
	public int updateScore(ScoreVO vo);

	// 성적 삭제
	public int deleteScore(String studNo);

	// 성적 상세 조회
	public ScoreVO getScore(String studNo);

	// 성적 목록 조회
	public List<ScoreVO> getScoreList();

}
