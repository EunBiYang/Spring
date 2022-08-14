package test.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import test.bean.ScoreVO;

@Repository("dao")
public class ScoreDAOSpring {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String score_insert = "insert into score values (?, ?, ?, ?, ?, ?, ?, sysdate)";
	private String score_update = "update score set name=?, kor=?, eng=?, mat=?, tot=?, avg=? where studNo=?";
	private String score_delete = "delete score where studNo=?";
	private String score_list = "select * from score order by studNo asc";
	
	public int insert_score(ScoreVO vo) {
		Object[] args = {vo.getStudNo(), vo.getName(),vo.getKor(), vo.getEng(), vo.getMat(),vo.getTot(), vo.getAvg()};
		int result = jdbcTemplate.update(score_insert, args);
		
		return result;
	}
	
	public int update_score(ScoreVO vo) {
		Object[] args = {vo.getName(),vo.getKor(), vo.getEng(), vo.getMat(),vo.getTot(), vo.getAvg(), vo.getStudNo()};
		int result = jdbcTemplate.update(score_update, args);
		
		return result;
	}
	
	public int delete_score(String studNo) {
		int result = jdbcTemplate.update(score_delete, studNo);
		return result;
	}
	
	public List<ScoreVO> get_scorelist() {
				
		return jdbcTemplate.query(score_list, new ScoreRowMapper());
	}

}
