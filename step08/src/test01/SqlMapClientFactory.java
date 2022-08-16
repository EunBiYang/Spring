package test01;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//SqlMapClientFactory : mybatis 설정파일을 읽어와서 초기화 시키는 클래스
//SqlSession : mybatis를 사용한는 클래스
public class SqlMapClientFactory {
	// 1>2>3 순서로 실행
	//1.SqlSessionFactory 생성
	private static SqlSessionFactory factory = null;
	
	//2.static초기화 : static 객체를 프로그램 시작시 초기화 시키는 것.
	static {
		try {
			String resource = "mybatis-config.xml";
			Reader reader = Resources.getResourceAsReader(resource);//xml 파일 읽어오기
			factory = new SqlSessionFactoryBuilder().build(reader);//xml 설정대로 초기화 작업을 수행함
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//3. SqlSession객채 생성
	//goods-mapping.xml에 설정된 값을 불러와서 사용할수 있게 한다?
	public static SqlSession getSqlMapClientInstance() {
		return factory.openSession();
	}

}
