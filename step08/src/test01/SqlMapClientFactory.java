package test01;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// SqlSessionFactory : mybatis 설정 파일을 읽어와서 초기화 시키는 클래스
// SqlSession : mybatis를 사용하는 클래스
public class SqlMapClientFactory {
	private static SqlSessionFactory factory = null;
	
	// static 초기화 : static 객체를 프로그램 시작시 초기화시키는 것
	static {
		try {
			String resource = "mybatis-config.xml";
			Reader reader = Resources.getResourceAsReader(resource);// xml 파일 읽어오기
			factory = new SqlSessionFactoryBuilder().build(reader); // xml 설정대로 초기화 작업을 수행함
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSession getSqlMapClientInstance() {
		return factory.openSession();
	}
}




