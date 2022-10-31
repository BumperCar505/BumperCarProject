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
	BMain bMain;
	BSchedule schedule;
	PlanCount planCount;
	int get_schedule_no;
	String mon;
	String day;
	Date this_date;
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	public PlanInfo(String name, String title, int schedule_no, BMain bMain, String start_date, int year, int month,
			int days, PlanCount planCount) {
		this.get_schedule_no = schedule_no;
		this.bMain = bMain;
		this.planCount = planCount;

		setOpaque(true);
		setBackground(getColor(schedule_no));
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
		if (start_date.equals(thisDay) || dayofweek == 1) {// dayofweek가 1이라는게 그날이 일요일이라는것
			setText(name + "-" + title);
		} else {
			setText("  ");
		}
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				move(schedule_no);
				planCount.setVisible(false);
			}
		});

		setPreferredSize(new Dimension(110, 13));
	}

	public void move(int schedule_no) {
		Connection con = bMain.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		bMain.mainFrame.showPage(MainFrame.SCHEDULE);// 패널누르면 일정등록페이지
		schedule = (BSchedule) bMain.mainFrame.getPages(MainFrame.SCHEDULE);

		String sql = "select member.name,schedule.title,schedule.start_date,schedule.end_date,schedule.content,schedule.schedule_no,schedule.writer_no,schedule_step_info.step "
				+ "from member inner join schedule on member.member_no = schedule.writer_no "
				+ "inner join schedule_step_info on schedule.step_no = schedule_step_info.schedule_step_no "
				+ "where schedule.schedule_no = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, get_schedule_no);

			rs = pstmt.executeQuery();
			rs.next();
			String title = rs.getString("title");
			String start_date = rs.getString("start_date");
			String end_date = rs.getString("end_date");
			String name = rs.getString("name");
			String step = rs.getString("step");
			String content = rs.getString("content");
			int writer_no = rs.getInt("writer_no");
			schedule.setSchedule(schedule_no, title, start_date, end_date, name, step, content, writer_no);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			bMain.closeDB(pstmt, rs);
		}

	}

	// db에서 색상 가져와 반환하는 메서드
	public Color getColor(int schedule_no) {
		Connection con = bMain.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int r = 0;
		int g = 0;
		int b = 0;

		String sql = "select color_r,color_g,color_b from schedule where schedule_no=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, get_schedule_no);

			rs = pstmt.executeQuery();
			rs.next();
			r = rs.getInt("color_r");
			g = rs.getInt("color_g");
			b = rs.getInt("color_b");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			bMain.closeDB(pstmt, rs);
		}

		Color c = new Color(r, g, b);

		return c;

	}

}