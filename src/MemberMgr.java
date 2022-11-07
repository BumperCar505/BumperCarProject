//set은 값을 입력하는 것, get은 저장된 값을 불러오는 것.

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
	public MemberBean select(int id){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		MemberBean bean = new MemberBean();
		try {
			con = pool.getConnection();
			sql = "select * from tblMember where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setPhone(rs.getString("phone"));
				bean.setTeam(rs.getString("team"));
				bean.setAddress(rs.getString("address"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	
	public boolean update(MemberBean bean){
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "update tblMember set name=?,phone=?,team=?,address=? "
					+ "where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getPhone());
			pstmt.setString(3, bean.getTeam());
			pstmt.setString(4, bean.getAddress());
			pstmt.setInt(5, bean.getId());
			int cnt = pstmt.executeUpdate();
			if(cnt==1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	
	
//	 CusMgr 모든 값 가져오기(화면에 전체 값 보여주기)
	public MemberBean showCusMgr(int cusNum){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		MemberBean bean = new MemberBean();
		try {
			con = pool.getConnection();
			sql = "select * from tblMember where cusNum = ? " ;
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cusNum);
			rs = pstmt.executeQuery();
			if(rs.next()){
				bean.setCusName(rs.getString("cusName"));
				bean.setCusCarNum(rs.getString("cusCarNum"));
				bean.setCusCarBrand(rs.getString("cusCarBrand"));
				bean.setCusCarType(rs.getString("cusCarType"));
				bean.setCusZip(rs.getInt("cusZip"));
				bean.setCusAddr(rs.getString("cusAddr"));
				bean.setCusTel(rs.getString("cusTel"));
				bean.setCusDate(rs.getString("cusDate"));
				bean.setCusKm(rs.getInt("cusKm"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	
	
//	cusMgr 추가
	
	public MemberBean insertCusMgr(MemberBean bean){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
//		MemberBean bean = new MemberBean();
		try {
			con = pool.getConnection();
			sql = "insert into customer values(?,?,?,?,?,?,?,?,?) " ;
			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, );
//			rs = pstmt.executeQuery();
//			if(rs.next()){
			
//			추가할 때는 bean을 사용할 필요없다. pstmt.setString을 사용.
//				bean.setCusName(rs.getString("cusName"));
//				bean.setCusCarNum(rs.getString("cusCarNum"));
//				bean.setCusCarBrand(rs.getString("cusCarBrand"));
//				bean.setCusCarType(rs.getString("cusCarType"));
//				bean.setCusZip(rs.getInt("cusZip"));
//				bean.setCusAddr(rs.getString("cusAddr"));
//				bean.setCusTel(rs.getString("cusTel"));
//				bean.setCusDate(rs.getString("cusDate"));
//				bean.setCusKm(rs.getInt("cusKm"));
//			데이터베이스에 값을 넣어줘야 하니까.set을 사용해야 한다.
			
			pstmt.setString(1, bean.getCusName());
			pstmt.setString(2, bean.getCusCarNum());
			pstmt.setString(3, bean.getCusCarBrand());
			pstmt.setString(4, bean.getCusCarType());
			pstmt.setInt(5, bean.getCusZip());
			pstmt.setString(6, bean.getCusAddr());
			pstmt.setString(7, bean.getCusTel());
			pstmt.setString(8, bean.getCusDate());
			pstmt.setInt(9, bean.getCusKm());
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	
	
//	cusMgr 수정
	
	public boolean updateCusMgr(MemberBean bean){
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "update customer set cusName=?,cusCarNum=?,CusCarBrand=?,CusCarType=?"
					+ " cusZip=?, cusAddr=?,cusTel=?,cusDate=?,cusKm=? "
					+ "where cusNum=?";
			pstmt.setString(1, bean.getCusName());
			pstmt.setString(2, bean.getCusCarNum());
			pstmt.setString(3, bean.getCusCarBrand());
			pstmt.setString(4, bean.getCusCarType());
			pstmt.setInt(5, bean.getCusZip());
			pstmt.setString(6, bean.getCusAddr());
			pstmt.setString(7, bean.getCusTel());
			pstmt.setString(8, bean.getCusDate());
			pstmt.setInt(9, bean.getCusKm());
			int cnt = pstmt.executeUpdate();
			if(cnt==1) flag = true; //flag 전환
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	
//	cusMgr 삭제
	public boolean deleteCusMgr(MemberBean bean){
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "DELETE from customer WHERE cusNum=? " ;
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bean.getCusNum());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	
	
	
}









