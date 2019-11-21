package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class T02_JdbcTest {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String userId = "pc16";
			String password = "java";
			
			conn = DriverManager.getConnection(url, userId, password);	// 접속 url 정보 입력
			
			stmt = conn.createStatement();
			
			
			String sql = "SELECT * FROM lprod";		// 실행할 SQL 문
/*───────────────────────────────────────────────────────────────────────────────────────────────────*/
			
			// 문제1) 사용자로부터 lprod_id 값을 입력받아 입력한 값보다 lprod_id가 큰 자료들을 출력하시오.
			
//			System.out.print("▷ id 값을 입력해주세요.: ");
//			sql += " where lprod_id > " + Integer.parseInt(scan.nextLine());
			
/*───────────────────────────────────────────────────────────────────────────────────────────────────*/
			
			// 문제2) lprod_id 값을 2개 입력받아 두 값 중 작은 값부터 큰 값 사이의 자료를 출력하시오.
			
			System.out.println("▷ id 값을 2개 입력해주세요.: ");
			int num1 = Integer.parseInt(scan.nextLine());
			int num2 = Integer.parseInt(scan.nextLine());
			int max = Math.max(num1, num2);
			int min = Math.min(num1, num2);
			sql += " WHERE lprod_id BETWEEN " + min + " AND " + max;
			
/*───────────────────────────────────────────────────────────────────────────────────────────────────*/
			
			rs = stmt.executeQuery(sql);
			
			System.out.println("실행한 쿼리문: " + sql);
			System.out.println("──────────────쿼리문 실행 결과───────────────");
			
			while(rs.next()) {
				System.out.println("lprod_id: " + rs.getInt("lprod_id"));
//				System.out.println("lprod_gu: " + rs.getString("lprod_gu"));
				System.out.println("lprod_gu: " + rs.getString(2));
				System.out.println("lprod_nm: " + rs.getString("lprod_nm"));
				System.out.println("────────────────────────────────────────");
			}
			
			System.out.println("▷ 출력 끝");
			

		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try { rs.close(); } catch(SQLException e) {}
			if(stmt != null) try { stmt.close(); } catch(SQLException e) {}
			if(conn != null) try { conn.close(); } catch(SQLException e) {}
			
		}
		
		
	}
}
