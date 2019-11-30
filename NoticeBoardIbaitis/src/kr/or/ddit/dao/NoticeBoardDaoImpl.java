package kr.or.ddit.dao;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.vo.NoticeBoardVO;

public class NoticeBoardDaoImpl implements NoticeBoardDao {
	
//	private Connection conn;
//	private Statement stmt;
//	private PreparedStatement pstmt;
//	private ResultSet rs;
	
	private SqlMapClient smc;
	
	private static NoticeBoardDao dao;
	
	private NoticeBoardDaoImpl() {

		// ibatis
		Reader rd;

		try {
			Charset charset = Charset.forName("UTF-8");	
			Resources.setCharset(charset);

			rd = Resources.getResourceAsReader("SqlMapConfig.xml");

			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		}catch(IOException e) {
			System.out.println("▶ SqlMapClient 객체 생성 실패");
			e.printStackTrace();
		}

	}

	public static NoticeBoardDao getIntance() {
		if(dao == null) {
			dao = new NoticeBoardDaoImpl();
		}
		return dao;
	}
	
	// 자원 반납
//	private void disConnect() {
//		if(rs!=null) try{ rs.close(); }catch(SQLException e){}
//		if(pstmt!=null) try{ pstmt.close(); }catch(SQLException e){}
//		if(stmt!=null) try{ stmt.close(); }catch(SQLException e){}
//		if(conn!=null) try{ conn.close(); }catch(SQLException e){}
//	}

	@Override
	public int insertMember(NoticeBoardVO nbo) {
		
//		try {
//			conn = DBUtil3.getConnection();
//
//			String sql = "INSERT INTO jdbc_board (board_no, board_title, board_writer, board_date, board_content)"
//					+ " VALUES (board_seq.NEXTVAL, ?, ?, sysdate, ?) ";
//			
//			// 쿼리를 파라미터로 넣어줘야 함.
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, nbo.getBoard_title());
//			pstmt.setString(2, nbo.getBoard_writer());
//			pstmt.setString(3, nbo.getBoard_content());
//			
//			cnt = pstmt.executeUpdate();
//
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			disConnect();	
//		}
		
		int cnt = 0;
		
		try {
			Object obj = smc.insert("NoticeBoardTest.insertMember", nbo);
			if(obj == null) {
				cnt = 1;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public boolean getMember(String boardTitle) {
		
		boolean chk = false;
		
		int cnt = 0;
		
		try {
//			conn = DBUtil3.getConnection();
//			String sql = "SELECT count(*) cnt FROM jdbc_board WHERE board_no = ? ";
//
//			pstmt = conn.prepareStatement(sql);
//
//			// 물음표를 채워주자.
//			pstmt.setString(1, boardTitle);
//
//			rs = pstmt.executeQuery();
			
			cnt = (int) smc.queryForObject("NoticeBoardTest.getMember", boardTitle);
//			if(rs.next()) {
//				cnt = rs.getInt("cnt");	
//			}
			if(cnt > 0) {
				chk = true;
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		/*finally {
			disConnect();
		}*/

		return chk;
	}

	@Override
	public List<NoticeBoardVO> getAllMemberList() {
		
		List<NoticeBoardVO> noticeList = new ArrayList<NoticeBoardVO>();
		
		try {
			noticeList = smc.queryForList("NoticeBoardTest.getMemberAll");
//			conn = DBUtil2.getConnection();
//			String sql = "SELECT * FROM jdbc_board";
//			stmt = conn.prepareStatement(sql);
//			rs = stmt.executeQuery(sql);
//
//			while(rs.next()) {
//				NoticeBoardVO nbo = new NoticeBoardVO();
//				nbo.setBoard_no(rs.getString("board_no"));
//				nbo.setBoard_writer(rs.getString("board_writer"));
//				nbo.setBoard_title(rs.getString("board_title"));
//				nbo.setBoard_content(rs.getString("board_content"));
//				nbo.setBoard_date(rs.getString("board_date"));
//				
//				noticeList.add(nbo);
//			
//			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
//		finally {
//			disConnect();
//		}
		return noticeList;
	}

	@Override
	public int modifyMember(NoticeBoardVO nbo) {
		
		int cnt = 0;
		
		try {
			cnt = smc.update("NoticeBoardTest.modifyMember", nbo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*try {
			conn = DBUtil3.getConnection();
			
			String sql = "UPDATE jdbc_board SET board_title = ?, board_writer = ?,"
					+ "board_date = TO_CHAR(SYSDATE, 'YYYY-MM-DD'), board_content = ? WHERE board_no = ? ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, nbo.getBoard_title());
			pstmt.setString(2, nbo.getBoard_writer());
			pstmt.setString(3, nbo.getBoard_content());
			pstmt.setString(4, nbo.getBoard_no());
			
			cnt = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		*/
		return cnt;
	}

	@Override
	public int deleteMember(String boardTitle) {
		
		int cnt = 0;
		
		try {
			cnt = smc.delete("NoticeBoardTest.deleteMember", boardTitle);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*try {
			conn = DBUtil3.getConnection();
			
			String sql = "DELETE FROM jdbc_board WHERE board_title = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardTitle);
			
			cnt = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}*/
		
		return cnt;
	}

	@Override
	public List<NoticeBoardVO> getSearchWrite(String boardTitle) {
		
		ArrayList<NoticeBoardVO> noticeList = new ArrayList<NoticeBoardVO>();
		
		try {

			conn = DBUtil3.getConnection();

			String sql = "SELECT * FROM jdbc_board WHERE board_title = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardTitle);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				
				NoticeBoardVO nbo = new NoticeBoardVO();
				
				
				nbo.setBoard_no(rs.getString("board_no"));
				nbo.setBoard_writer(rs.getString("board_writer"));
				nbo.setBoard_title(rs.getString("board_title"));
				nbo.setBoard_content(rs.getString("board_content"));
				nbo.setBoard_date(rs.getString("board_date"));
				
				noticeList.add(nbo);

			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		
		return noticeList;
	}

}
