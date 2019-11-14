package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Scanner;

	/*	<< LPROD 테이블에 새로운 데이터를 추가하기 >> 

	 	lprod_gu와 lprod_nm은 직접 입력받아 처리하고
	 	lprod_id는 현재의 lprod_id들 중 제일 큰 값보다 1 증가된 값으로 한다.
	 	(기타사항: lprod_gu도 중복되는지 검사한다.	 */

public class T04_JdbcTest {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Connection 객체 생성
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe",
					"pc16",
					"java"
					);


			// Statement 객체를 이용한 자료 추가 방법

			String sql2 = "SELECT * FROM lprod";		// 실행할 SQL 문
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql2);

			String input = "";


			try {
				outer : while(true) {
					System.out.print("▷ 제품 번호를 입력해주세요(lprod_gu): ");
					input = s.nextLine();

					while(rs.next()) {
						if(input.equals(rs.getString("lprod_gu"))) {
							System.out.println("▷ 제품 번호가 중복됩니다. 다시 입력해주세요.");
							break;
						}else {
							break outer;
						}
					}
				}
			}catch(SQLIntegrityConstraintViolationException e) {
				System.out.println("▷ 제품 번호가 중복됩니다. 다시 입력해주세요.");
			}

			int cnt = 1;

			while(rs.next()) {
				//rs.getInt("lprod_id");
				cnt++;
			}
			System.out.println(cnt);

			System.out.print("▷ 제품명을 입력해주세요(lprod_nm): ");
			String input2 = s.nextLine();

			String sql = "INSERT INTO lprod VALUES (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, (cnt + 1));
			pstmt.setString(2, input);
			pstmt.setString(3, input2);

			int cnt2 = pstmt.executeUpdate();
//			System.out.println("▷ 반환값: " + cnt);

			System.out.println();
			System.out.println("▷ 제품 추가 완료");
			System.out.println("▶ 작업 끝");



		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) try { conn.close(); } catch(SQLException e) {}
			if(pstmt != null) try { pstmt.close(); } catch(SQLException e) {}
		}

	}

}
















