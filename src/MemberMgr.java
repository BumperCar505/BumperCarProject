

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class MemberMgr {
	
	private DBConnectionMgr pool;
	
	public MemberMgr() {
		//DBConnection 객체 10개 미리 생성
		pool = DBConnectionMgr.getInstance();
	}

	
	//한개의 레코드
	
	public MemberBean select(int techNum){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		MemberBean bean = new MemberBean();
		try {
			con = pool.getConnection();
			sql = "select * from technician where techNum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, techNum);
			rs = pstmt.executeQuery();
			if(rs.next()){
				bean.setTechNum(rs.getInt("techNum"));
				bean.setTechComNum(rs.getString("techComNum"));
				bean.setTechName(rs.getString("techName"));
				bean.setTechTel(rs.getString("techTel"));
				bean.setTechLv(rs.getString("techLv"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	
	
	public boolean update(MemberBean bean,int index){
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "update technician set techName=?,techTel=?,techLv=? "
					+ "where techNum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getTechName());
			pstmt.setString(2, bean.getTechTel());
			pstmt.setString(3, bean.getTechLv());
			pstmt.setInt(4, index);
			
			int cnt = pstmt.executeUpdate();
			if(cnt==1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	//"select MAX(techNum) from technician; ";
	// 마지막 techNum 찾기
	
	  public MemberBean lastNum(){ Connection con = null; PreparedStatement pstmt =
	  null; ResultSet rs = null; String sql = null; MemberBean bean = new
	  MemberBean(); try { con = pool.getConnection(); sql =
	  "select MAX(techNum) from technician "; 
	  sql = "select * from technician ORDER BY ROWID LIMIT 1 "; 
	  pstmt = con.prepareStatement(sql); rs = pstmt.executeQuery();
	  
	  if(rs.next()){ bean.setTechNum(rs.getInt("MAX(techNum)")); }
	  
	  
	  } catch (Exception e) { e.printStackTrace(); } finally {
	  pool.freeConnection(con, pstmt, rs); } return bean; }
	 
	
	// 추가 기능
	public MemberBean add(MemberBean bean){
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			con = pool.getConnection();
			sql = "INSERT INTO technician (techNum, techComNum, techName, techTel, techLv) VALUES (NULL, '8885577777', ?, ?, ?) ";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, bean.getTechName());
			pstmt.setString(2, bean.getTechTel());
			pstmt.setString(3, bean.getTechLv());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return bean;
	}
	
	// DELETE FROM 테이블이름 WHERE 필드이름=데이터값
	// DELETE FROM technician WHERE techNum=?
	// 삭제 기능
	public MemberBean delete(MemberBean bean){
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			con = pool.getConnection();
			sql = "DELETE FROM technician WHERE techNum = ? ";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, bean.getTechNum());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return bean;
	}
}









