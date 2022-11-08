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
			sql = "select * from customer where cusNum = ? " ;
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cusNum);
			rs = pstmt.executeQuery();
			if(rs.next()){
				bean.setCusNum(rs.getInt("cusNum"));
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
			sql = "insert into customer(cusComNum, cusName, cusCarNum, cusCarBrand, cusCarType, cusZip, cusAddr, cusTel,cusKm,cusDate) values(1112233333,?,?,?,?,?,?,?,?,?) " ;
			pstmt = con.prepareStatement(sql);

//			데이터베이스에 값을 넣어줘야 하니까.set을 사용해야 한다.
			
			pstmt.setString(1, bean.getCusName());
			pstmt.setString(2, bean.getCusCarNum());
			pstmt.setString(3, bean.getCusCarBrand());
			pstmt.setString(4, bean.getCusCarType());
			pstmt.setInt(5, bean.getCusZip());
			pstmt.setString(6, bean.getCusAddr());
			pstmt.setString(7, bean.getCusTel());
			pstmt.setInt(8, bean.getCusKm());
			pstmt.setString(9, bean.getCusDate());
			
			
			pstmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	
	
//	cusMgr 수정
	
	public boolean updateCusMgr(MemberBean bean, int cusNum){
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
			if(cnt==1) flag = true; 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	
//	선택한 열 값 가져오기 위해
	public MemberBean select_(int cusNum){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		MemberBean bean = new MemberBean();
		try {
			con = pool.getConnection();
			sql = "select * from customer where cusNum=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cusNum);
			rs = pstmt.executeQuery();
			if(rs.next()){
				bean.setCusNum(rs.getInt("cusNum"));
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
	
//	cusMgr 삭제
//	public MemberBean deleteCusMgr(MemberBean bean){
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		String sql = null;
//		
//		try {
//			con = pool.getConnection();
////			프로시저 명령어
////			프로시저 날려야 
////			지금 maintenance테이블과 pk,fk로 묶여있어서 이렇게 안하면 데이터 삭제가 안됨.
////			pstmt.execute("SET foreign_key_checks =0");
//			sql =  "SET foreign_key_checks =0 DELETE from customer WHERE cusNum = ? SET foreign_key_checks = 1 ";
//			pstmt = con.prepareStatement(sql);
//
//			
//			
//			
//			pstmt.setInt(1, bean.getCusNum());
//			pstmt.executeUpdate();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			pool.freeConnection(con, pstmt);
//		}
//
//		return bean;
//	}
	
	
	
}









