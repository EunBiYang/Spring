package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


import test.bean.ScoreVO;

@Repository("dao")
public class ScoreDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// SQL문
	private String score_insert = "insert into score values (?, ?, ?, ?, ?, ?, ?, sysdate)";
	private String score_list = "select * from score order by studNo asc";
	private String score_update = "update score set name=?,kor=?,eng=?,mat=?, tot=?, avg=? where studNo=?";
	private String score_delete = "delete score where studNo= ?";
	
	
	// 등록
	public int insert_score(ScoreVO vo) {
		int result = 0;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(score_insert);
			pstmt.setString(1, vo.getStudNo());
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, vo.getKor());
			pstmt.setInt(4, vo.getEng());
			pstmt.setInt(5, vo.getMat());
			pstmt.setInt(6, vo.getTot());
			pstmt.setDouble(7, vo.getAvg());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
		return result;
	}
	
	// 출력
	public List<ScoreVO> get_scorelist(){
			List<ScoreVO> list = new ArrayList<ScoreVO>();
			conn = JDBCUtil.getConnection();
			
			try {
				pstmt = conn.prepareStatement(score_list);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					ScoreVO vo = new ScoreVO();
					vo.setStudNo(rs.getString("studNo"));
					vo.setName(rs.getString("name"));
					vo.setKor(rs.getInt("kor"));
					vo.setEng(rs.getInt("eng"));
					vo.setMat(rs.getInt("mat"));
					vo.setTot(rs.getInt("tot"));
					vo.setAvg(rs.getDouble("avg"));
					vo.setLogtime(rs.getString("logtime"));
					list.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
	
	//수정
	public int update_score(ScoreVO vo) {
		int result = 0;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(score_update);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());
			pstmt.setInt(5, vo.getTot());
			pstmt.setDouble(6, vo.getAvg());
			pstmt.setString(7, vo.getStudNo());

			result= pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
		return result;  
		}
	
	
	//삭제
	public int delete_score(String studNo) {
		int result = 0;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(score_delete);
			pstmt.setString(1, studNo);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
		return result;
	}
	
}










