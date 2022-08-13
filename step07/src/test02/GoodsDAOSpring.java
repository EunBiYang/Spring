package test02;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class GoodsDAOSpring {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;	
	
	// SQL문
	private String goods_insert = "insert into goods values (?, ?, ?, ?)";
	private String goods_update = "update goods set name=?, price=?, maker=? where code=?";
	private String goods_delete = "delete goods where code=?";
	private String goods_get = "select * from goods where code=?";
	private String goods_list = "select * from goods order by code asc";
	
	// 책 등록
	public int insertGoods(GoodsVO vo) {
		/*방법 1
		int result = jdbcTemplate.update(goods_insert, vo.getCode(),vo.getName(),
				vo.getPrice(), vo.getMaker());						*/
		
		//방법 2
		Object[] args = {vo.getCode(),vo.getName(),vo.getPrice(), vo.getMaker()};
		int result = jdbcTemplate.update(goods_insert, args);
		
		return result;
	}
	
	// 책 수정
	public int updateGoods(GoodsVO vo) {
		int result = jdbcTemplate.update(goods_update, vo.getName(), vo.getPrice(),
										vo.getMaker(), vo.getCode());
		return result;
	}
	
	//책 삭제
	public int deleteGoods(String code) {
		int result = jdbcTemplate.update(goods_delete, code);
		return result;
	}
	
	//select 구문은 다양한 키가 있다. 교재 참조
	//책 상세 조회
	public GoodsVO getGoods(String code) {
		Object[] args = {code};
		return jdbcTemplate.queryForObject(goods_get, args, new GoodsRowMapper());
	}
	
	//책 목록 조회
	public List<GoodsVO> getGoodList(){
		return jdbcTemplate.query(goods_list, new GoodsRowMapper());
	}

}









