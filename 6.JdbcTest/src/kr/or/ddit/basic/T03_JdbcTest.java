package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

// Insert 예제
public class T03_JdbcTest {

	/*	lprod_id: 101, lprod_gu: N101, lprod_nm: 농산물
	 	lprod_id: 102, lprod_gu: N102, lprod_nm: 수산물
	 	lprod_id: 103, lprod_gu: N103, lprod_nm: 축산물
	 	
	 	위 3개의 자료를 추가하기	 */
	
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try {
			// 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// Connection 객체 생성
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe",
					"pc16",
					"java"
					);
			
/*───────────────────────────────────────────────────────────────────────────────────────────────────*/
			
			// Statement 객체를 이용한 자료 추가 방법
			stmt = conn.createStatement();
			
//			String sql = "INSERT INTO lprod (lprod_id, lprod_gu, lprod_nm) VALUES (101, 'N101', '농산물')";
//			String sql = "INSERT INTO lprod VALUES (101, 'N101', '농산물')";
//			
//			// SQL 문이 SELECT 문이 아닐 경우에는 executeUpdate()메서드를 사용한다.
//			// executeUpdate()메서드는 실행에 성공한 레코드 수를 반환한다.
//			
//			int cnt = stmt.executeUpdate(sql);
//			System.out.println("▷ 첫 번째 반환값: " + cnt);
//			
//			/*─────────────────────────────────────────────────────────────────────*/
//			
////			sql = "INSERT INTO lprod (lprod_id, lprod_gu, lprod_nm) VALUES (102, 'N102', '수산물')";
//			sql = "INSERT INTO lprod VALUES (102, 'N102', '수산물')";
//			cnt = stmt.executeUpdate(sql);
//			System.out.println("▷ 두 번째 반환값: " + cnt);
//			
			/*─────────────────────────────────────────────────────────────────────*/
//			
////		sql = "INSERT INTO lprod (lprod_id, lprod_gu, lprod_nm) VALUES (103, 'N103', '축산물')";
//			sql = "INSERT INTO lprod VALUES (103, 'N103', '축산물')";
//			cnt = stmt.executeUpdate(sql);
//			System.out.println("▷ 세 번째 반환값: " + cnt);
			
/*───────────────────────────────────────────────────────────────────────────────────────────────────*/
			
			// PreparedStatement 객체를 이용한 자료 추가 방법
			
			// SQL문 작성 (데이터가 들어갈 자리에 물음표(?)를 넣는다.)
			
//			String sql = "INSERT INTO lprod (lprod_id, lprod_gu, lprod_nm) VALUES (?, ?, ?)";
			String sql = "INSERT INTO lprod VALUES (?, ?, ?)";
			// 나중에 데이터가 들어오면 그때 처리를 해라.
			
			
			// PreparedStatement 객체를 생성할 때 SQL문을 넣어서 생성한다.
			pstmt = conn.prepareStatement(sql);
			
			// 쿼리문의 물음표(?) 자리에 들어갈 데이터를 세팅한다.
			// 형식) pstmt.set자료형이름(물음표순번, 데이터);
			//		물음표 순번은 1번부터 시작한다.
				// 작은 따옴표로 감싸주는 구문
				// PreparedStatement는 보안이 강하다. statement는 들어갈 구절을 일일이 다 써줘야 함.
			pstmt.setInt(1, 101);
			pstmt.setString(2, "N101");
			pstmt.setString(3, "농산물");
			
			// 데이터를 세팅한 후 쿼리문을 실행한다.
			int cnt = pstmt.executeUpdate();
			System.out.println("▷ 첫 번째 반환값: " + cnt);
			
			/*─────────────────────────────────────────────────────────────────────*/
			
			pstmt.setInt(1, 102);
			pstmt.setString(2, "N201");
			pstmt.setString(3, "수산물");
			
			// 데이터를 세팅한 후 쿼리문을 실행한다.
			cnt = pstmt.executeUpdate();
			System.out.println("▷ 두 번째 반환값: " + cnt);
			
			/*─────────────────────────────────────────────────────────────────────*/
			
			pstmt.setInt(1, 103);
			pstmt.setString(2, "N301");
			pstmt.setString(3, "축산물");
			
			// 데이터를 세팅한 후 쿼리문을 실행한다.
			cnt = pstmt.executeUpdate();
			System.out.println("▷ 세 번째 반환값: " + cnt);

/*───────────────────────────────────────────────────────────────────────────────────────────────────*/
			
			System.out.println();
			System.out.println("▶ 작업 끝");
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) try { conn.close(); } catch(SQLException e) {}
			if(stmt != null) try { stmt.close(); } catch(SQLException e) {}
			if(pstmt != null) try { pstmt.close(); } catch(SQLException e) {}
		}
		
		
		
	}
	
	
	
	
}
















