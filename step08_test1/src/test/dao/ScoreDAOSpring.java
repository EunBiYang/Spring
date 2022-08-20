package test.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import test.bean.ScoreVO;

@Repository("dao")
public class ScoreDAOSpring {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//성적 등록
	public int insertScore(ScoreVO vo) {		
		return sqlSession.insert("mybatis.scoreMapper.insertScore",vo);
	}
	//성적 수정
	public int updateScore(ScoreVO vo) {
		return sqlSession.update("mybatis.scoreMapper.updateScore", vo);
	}
	//성적 삭제
	public int deleteScore(String studNo) {
		return sqlSession.delete("mybatis.scoreMapper.deleteScore",studNo);
	}
	//성적 상세 조회
	public ScoreVO getScore(String studNo) {		
		return sqlSession.selectOne("mybatis.scoreMapper.getScore",studNo);		
	}
	//성적 목록 조회
	public List<ScoreVO> getScoreList() {
		return sqlSession.selectList("mybatis.scoreMapper.getScoreList");
	}
}
