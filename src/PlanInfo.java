//계획 작성자하고 이름으로 나타나고 누르면 계획을 보여줌

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;

//import org.apache.poi.hssf.util.HSSFColor.PALE_BLUE;


public class PlanInfo extends JLabel {
	BookMain bMain;
//	BookSchedule schedule;
	BookDetail detail;
	PlanCount planCount;
	int get_maintenance_num;
	String mon;
	String day;
	Date this_date;
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	public PlanInfo(int mainNum, String cusName, String cusCarNum, String srvName, String cusTel, BookMain bMain, String mainStartDate, String mainEndDate, int year, int month,
			int days, PlanCount planCount) {
//		this.get_schedule_no = schedule_no;
		this.get_maintenance_num = mainNum;
		this.bMain = bMain;
		this.planCount = planCount;

		setOpaque(true);
//		setBackground(getColor(schedule_no));
		if (month < 10) {
			mon = "0" + (month + 1);
		}
		if (days < 10) {
			day = "0" + days;
		} else {
			day = Integer.toString(days);
		}
		String thisDay = year + "-" + mon + "-" + day;
		try {
			this_date = formatter.parse(thisDay);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		cal.setTime(this_date);
		int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
		if (mainStartDate.equals(thisDay) || dayofweek == 1) {// dayofweek가 1이라는게 그날이 일요일이라는것
			setText(cusName + "-" + srvName);
		} else {
			setText("  ");
		}
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				move(mainNum);
				planCount.setVisible(false);
			}
		});

		setPreferredSize(new Dimension(110, 13));
	}

	public void move(int mainNum) {
		Connection con = bMain.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//		bMain.mainFrame.showPage(MainFrame.SCHEDULE);// 패널누르면 일정등록페이지
//		schedule = (BookSchedule) bMain.mainFrame.getPages(MainFrame.SCHEDULE);

		String sql = "SELECT customer.cusName, customer.cusCarNum, customer.cusCarBrand, customer.cusCarType, customer.cusTel, service.srvName, mainStartDate, mainEndDate "
				+ "FROM maintenance "
				+ "JOIN customer "
				+ "ON customer.cusNum = maintenance.mainCusNum "
				+ "JOIN service "
				+ "ON service.srvNum = maintenance.mainSrvNum "
				+ "WHERE maintenance.mainNum = ? ";
		

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, get_maintenance_num);

			rs = pstmt.executeQuery();
			rs.next();
			String cusName = rs.getString("cusName");
			String cusCarNum = rs.getString("cusCarNum");
			String cusCarBrand = rs.getString("cusCarBrand");
			String cusCarType = rs.getString("cusCarType");
			String cusTel = rs.getString("cusTel");
			String srvName = rs.getString("srvName");
			String mainStartDate = rs.getString("mainStartDate");
			String mainEndDate = rs.getString("mainEndDate");
			detail.setSchedule(mainNum, cusName, cusCarNum, cusCarBrand, cusCarType, cusTel, srvName, mainStartDate, mainEndDate);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			bMain.closeDB(pstmt, rs);
		}

	}

//	// db에서 색상 가져와 반환하는 메서드
//	public Color getColor(int schedule_no) {
//		Connection con = bMain.getConn();
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		int r = 0;
//		int g = 0;
//		int b = 0;
//
//		String sql = "select color_r,color_g,color_b from schedule where schedule_no=?";
//
//		try {
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, get_schedule_no);
//
//			rs = pstmt.executeQuery();
//			rs.next();
//			r = rs.getInt("color_r");
//			g = rs.getInt("color_g");
//			b = rs.getInt("color_b");
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			bMain.closeDB(pstmt, rs);
//		}
//
//		Color c = new Color(r, g, b);
//
//		return c;
//
//	}

}