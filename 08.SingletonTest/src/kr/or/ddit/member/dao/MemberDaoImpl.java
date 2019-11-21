package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.util.DBUtil2;
import kr.or.ddit.util.DBUtil3;

public class MemberDaoImpl implements IMemberDao {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	// 싱글턴
	private static IMemberDao dao;
	
	private MemberDaoImpl() {}
	
	public static IMemberDao getIntance() {
		if(dao == null) {
			dao = new MemberDaoImpl();
		}
		return dao;
	}

	
	// 자원 반납
	private void disConnect() {
		if(rs!=null) try{ rs.close(); }catch(SQLException e){}
		if(pstmt!=null) try{ pstmt.close(); }catch(SQLException e){}
		if(stmt!=null) try{ stmt.close(); }catch(SQLException e){}
		if(conn!=null) try{ conn.close(); }catch(SQLException e){}
	}

	@Override
	public int insertMember(MemberVO mv) {
		
		int cnt = 0;
		
		try {
			conn = DBUtil2.getConnection();

			String sql = "INSERT INTO mymember (mem_id, mem_name, mem_tel, mem_addr) VALUES (?, ?, ?, ?) ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getMem_id());
			pstmt.setString(2, mv.getMem_name());
			pstmt.setString(3, mv.getMem_tel());
			pstmt.setString(4, mv.getMem_addr());

			cnt = pstmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();	// 자원 반납 메서드 생성
		}
		
		return cnt;
	}

	@Override
	public boolean getMember(String memId) {
		
		boolean chk = false;

		try {
			conn = DBUtil2.getConnection();
			String sql = "SELECT count(*) cnt FROM mymember WHERE mem_id = ? ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memId);

			rs = pstmt.executeQuery();
			int cnt = 0;
			if(rs.next()) {
				cnt = rs.getInt("cnt");	
			}
			if(cnt > 0) {
				chk = true;
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}

		return chk;
		
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		
		ArrayList<MemberVO> memList = new ArrayList<MemberVO>();
		
		try {

			conn = DBUtil2.getConnection();

			String sql = "SELECT * FROM mymember";

			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				
				// VO에 담아서 ADD 시켜준다.
				MemberVO mv = new MemberVO();
				mv.setMem_id(rs.getString("mem_id"));
				mv.setMem_name(rs.getString("mem_name"));
				mv.setMem_tel(rs.getString("mem_tel"));
				mv.setMem_addr(rs.getString("mem_addr"));
				
				memList.add(mv);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		
		return memList;
	}

	@Override
	public int updateMember(MemberVO mv) {
		
		int cnt = 0;
		
		try {
			conn = DBUtil2.getConnection();
			
			String sql = "UPDATE mymember SET mem_name = ?, mem_tel = ?, mem_addr = ? WHERE mem_id = ? ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mv.getMem_name());
			pstmt.setString(2, mv.getMem_tel());
			pstmt.setString(3, mv.getMem_addr());
			pstmt.setString(4, mv.getMem_id());
			
			cnt = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		
		return cnt;
		
	}

	@Override
	public int deleteMember(String memId) {
		
		int cnt = 0;
		
		try {
			conn = DBUtil2.getConnection();
			
			String sql = "DELETE FROM mymember WHERE mem_id = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			cnt = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		
		return cnt;
	}

	@Override
	public List<MemberVO> getSearchMember(MemberVO mv) {
		
		List<MemberVO> memList = new ArrayList<>();
		
		try {
			
			conn = DBUtil3.getConnection();
			
			String sql = "SELECT * FROM mymember WHERE 1 = 1 ";
			// 1=1을 넣어주는 이유는 AND를 붙이는 다음 조건들을 보다 편히 사용하기 위해서.
			
			// 사용자의 입력값에 따라 조건이 바뀌어야 하기 떄문에 동적으로 조건을 변경해주는 부분
			if(mv.getMem_id() != null && !mv.getMem_id().equals("")) {	// 아이디가 존재하고, "" 값이 아닌 경우
				sql += " AND mem_id = ?";
			}
			if(mv.getMem_name() != null && !mv.getMem_name().equals("")) {
				sql += " AND mem_name = ?";
			}
			if(mv.getMem_tel() != null && !mv.getMem_tel().equals("")) {
				sql += " AND mem_tel = ?";
			}
			if(mv.getMem_addr() != null && !mv.getMem_addr().equals("")) {
				sql += " AND mem_addr Likd '%' || ? || '%' ";
			}
			
			pstmt = conn.prepareStatement(sql);
			
			int index = 1;
			if(mv.getMem_id() != null && !mv.getMem_id().equals("")) {
				pstmt.setString(index++, mv.getMem_id());
			}
			if(mv.getMem_name() != null && !mv.getMem_name().equals("")) {
				pstmt.setString(index++, mv.getMem_name());
			}
			if(mv.getMem_tel() != null && !mv.getMem_tel().equals("")) {	
				pstmt.setString(index++, mv.getMem_tel());
			}
			if(mv.getMem_addr() != null && !mv.getMem_addr().equals("")) {	
				pstmt.setString(index++, mv.getMem_addr());
			}
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				MemberVO mv2 = new MemberVO();
				mv2.setMem_id(rs.getString("mem_id"));
				mv2.setMem_name(rs.getString("mem_name"));
				mv2.setMem_tel(rs.getString("mem_tel"));
				mv2.setMem_addr(rs.getString("mem_addr"));
				
				memList.add(mv2);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		
		return memList;
	}

}
