package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

	/*	<< JDBC를 이용한 데이터베이스 처리순서 >>
 	
	 	 순서: JDBC 드라이버 로딩 → 해당 DB 접속 → 질의 (SQL 명령을 수행한다.) → 질의 결과를 받아서 처리한다. → 종료(자원반납)
	 	 
	 	 1. JDBC 드라이버 로딩 (오라클 기준)
	 	 	→ JDBC 드라이버는 DB를 만든 회사에서 제공한다.
	 	 	Class.forName("oracle.jdbc.driver.OracleDriver"); // 클래스이름
	 	 		// 실행 후 무반응이면 성공.
	 	 
	 	 2. 접속하기: 접속이 성공하면 Connection 객체가 생성된다.
	 	  	DriverManager.getConection()메서드를 이용한다.
	 	  	
	 	 3. 질의: Statement 객체 또는 PreparedStatement 객체를 이용하여 SQL 문장을 실행한다.
	 	 
	 	 4. 결과:
	 	 	1) SQL문이 select일 경우 → ResultSet 객체가 만들어진다.
	 	 	   ResultSet 객체에는 select 한 결과가 저장된다.
	 	    2) SQL문이 insert, update, delete 일 경우 → 정수값을 반환한다.
	 	       (정수값은 보통 실행에 성공한 레코드 수를 말한다.)		*/
	

public class T01_JdbcTest {
	public static void main(String[] args) {
		
		// DB 작업에 필요한 객체변수 선언
		
		Connection conn = null;
		Statement stmt = null;		// 쿼리를 날려주는 역할
		ResultSet rs = null;		// 쿼리문이 select 일 경우 필요함.
									// 이 외엔 안 쓰인다.
		
		try {
			// 1. 드라이버 로딩(옵션)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. DB에 접속(Connection 객체 생성)
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String userId = "pc16";
			String password = "java";
			
			// 실제적으로 OracleDriver가 사용되는 부분
			conn = DriverManager.getConnection(url, userId, password);	// 접속 url 정보 입력
			
			// 3. Statement 객체 생성 → Connection 객체를 이용한다.
			stmt = conn.createStatement();
			
			// 4. SQL 문을 Statement 객체를 이용하여 실행하고 실행결과를 ResultSet 객체에 저장한다.
			String sql = "select * from lprod";		// 실행할 SQL 문
			rs = stmt.executeQuery(sql);
			// SQL문이 select일 경우에는 executeQuery()메서드를 사용하고,
			// SQL문이 insert, update, delete일 경우에는 executeUpdate()메서드를 사용한다.
				// executeQuery / executeUpdate = int 타입
				// rs에 해당 쿼리(테이블)이 담긴다.
			
			// 5. ResultSet 객체에 저장되어 있는 자료를 반복문과 next() 메서드를 이용하여 차례로 읽어와 처리한다.
			System.out.println("실행한 쿼리문: " + sql);
			System.out.println("──────────────쿼리문 실행 결과───────────────");
			
			// rs.next() → ResultSet객체의 데이터를 가리키는 포인터를 다음 레코드로 이동시키고 그곳에 자료가 있으면 true, 없으면 false를 반환한다.
			while(rs.next()) {
				// 컬럼의 자료를 가져오는 방법
				// 방법1) rs.get자료형이름("컬럼명")	// 쓰는건 이게 보기 좋다.
				// 방법2) rs.get자료형이름(컬럼번호) → 번호는 1부터 시작
				System.out.println("lprod_id: " + rs.getInt("lprod_id"));
				System.out.println("lprod_gu: " + rs.getString("lprod_gu"));
				System.out.println("lprod_nm: " + rs.getString("lprod_nm"));
				System.out.println("────────────────────────────────────────");
			}
			
			System.out.println("▷ 출력 끝");
			

		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			// 6. 종료 (사용했던 자원을 모두 반납한다.)
				// 오라클 상에서 세션이 할당되고 있는데 회수를 하지 않으면 누적되어서 오라클 서버가 다운될 수 있다.
			if(rs != null) try { rs.close(); } catch(SQLException e) {}
			if(stmt != null) try { stmt.close(); } catch(SQLException e) {}
			if(conn != null) try { conn.close(); } catch(SQLException e) {}
			
		}

	}
}



