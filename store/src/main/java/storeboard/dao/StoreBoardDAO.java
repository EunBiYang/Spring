package storeboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import storeboard.bean.StoreBoardDTO;

@Repository("dao")

public class StoreBoardDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;

	// 목록보기
	public List<StoreBoardDTO> storeboardList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList("mybatis.storeboardMapper.storeboardList",map);
	}

	// 전체 글수 구하기
	public int getTotalA() {
		return sqlSession.selectOne("mybatis.storeboardMapper.getTotalA");
	}

	// 글저장
	public int storeboardWrite(StoreBoardDTO dto) {
		return sqlSession.insert("mybatis.storeboardMapper.storeboardWrite", dto);
	}

	
}
