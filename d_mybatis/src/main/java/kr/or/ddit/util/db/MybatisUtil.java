package kr.or.ddit.util.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	
	private static SqlSessionFactory sqlSessionFactory;

	// 설정파일을 읽어서 sqlSessionFactory 객체를 생성 (1회)
	// static 블록
	
	static {
		String resource = "kr/or/ddit/config/mybatis/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//		sqlSessionFactory.openSession();
		// openSession 객체를 통해서 실행.
	}
	
	// sqlSessionFactory openSession 메소드를 통해 sqlSession 객체를 얻어 sql을 실행
	
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	
}
