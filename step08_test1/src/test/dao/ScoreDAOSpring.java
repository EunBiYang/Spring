package test.dao;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import test.bean.ScoreVO;

@Repository("dao")
public class ScoreDAOSpring {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	public int insert_score(ScoreVO vo) {
		return sqlSessionTemplate.insert("mybatis.scoreMapper.insert_score",vo);
	}
	
	public int update_score(ScoreVO vo) {
		return sqlSessionTemplate.update("mybatis.scoreMapper.update_score",vo);
	}
	
	public int delete_score(String studNo) {
		return sqlSessionTemplate.delete("mybatis.scoreMapper.delete_score",studNo);
	}
	
	public ScoreVO get_score(String studNo) {
		return sqlSessionTemplate.selectOne("mybatis.scoreMapper.get_score",studNo);
	}
	
	public List<ScoreVO> get_scorelist() {
				
		return sqlSessionTemplate.selectList("mybatis.scoreMapper.get_scorelist");
	}

}
