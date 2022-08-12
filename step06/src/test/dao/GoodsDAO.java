package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import test.bean.GoodsVO;

@Repository("dao")
public class GoodsDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// SQL문
	private String goods_insert = "insert into goods values (?, ?, ?, ?)";
	private String goods_update = "update goods set name=?, price=?, maker=? "
								+ " where code=?";
	private String goods_delete = "delete goods where code=?";
	private String goods_get = "select * from goods where code=?";
	private String goods_list = "select * from goods order by code asc";
	
	// 책 등록
	public int insertGoods(GoodsVO vo) {
		int result = 0;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(goods_insert);
			pstmt.setString(1, vo.getCode());
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, vo.getPrice());
			pstmt.setString(4, vo.getMaker());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
		return result;
	}
	
	// 책 수정
	public int updateGoods(GoodsVO vo) {
		int result = 0;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(goods_delete);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getMaker());
			pstmt.setString(4, vo.getCode());
			
			result= pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
		return result;  
		}
	
	//책 삭제
	public int deleteGoods(String code) {
		int result = 0;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(goods_delete);
			pstmt.setString(1, code);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
		return result;
	}
	
	//책 상세 조회
	public GoodsVO getGoods(String code) {
		GoodsVO vo = null;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(goods_get);
			pstmt.setString(1, code);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				vo=new GoodsVO();
				vo.setCode(rs.getString("code"));
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getInt("price"));
				vo.setMaker(rs.getString("maker"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return vo;
	}
	
	//책 목록 조회
	public List<GoodsVO> getGoodList(){
		List<GoodsVO> list = new ArrayList<GoodsVO>();
		conn = JDBCUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(goods_list);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				GoodsVO vo = new GoodsVO();
				vo.setCode(rs.getString("code"));
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getInt("price"));
				vo.setMaker(rs.getString("maker"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	 
}










