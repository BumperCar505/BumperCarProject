import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

// 날짜 정보가 들어있는 
public class BCell extends JPanel {

	BCalendar bCalendar;
	BSchedule schedule;
	BMain bMain;
	PlanCount planCount;
	ArrayList<JLabel> plan_list = new ArrayList<JLabel>();
	JLabel la_day, plan_count;
	String printDay;
	JPanel p_center;
	int year, month, days;
	
	
	public BCell() {
		la_day = new JLabel();
		plan_count = new JLabel();
		plan_count.setPreferredSize(new Dimension(110, 13));
		p_center = new JPanel();
		setLayout(new BorderLayout());
		add(la_day, BorderLayout.NORTH);
		add(p_center);
		p_center.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 1));
		
		setPreferredSize(new Dimension(60, 60));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));

	}
	

	public void setCellDate(int year, int month, int days) {
		this.year = year;
		this.month = month;
		this.days = days;
		
//		if (year > 0) {
//			setSchedule();
//		}
	}
	
	public void setCellColor(Color color) { p_center.setBackground(color); }
	
	public void setOtherMonthDay() {
		setCellColor(Color.GRAY);
		la_day.setText("");
	}
	
	public void setMonthDay() {
		setCellColor(null);
		la_day.setText("" + days);
	}
	
//	public void showPlan() {
//		bMain.bMainFrame.showPage(BMainFrame.SCHEDULE);
//	}
	
	public void labelDel() {
		for (int i = 0; i < plan_list.size(); i++) {
			p_center.remove(plan_list.get(i));
		}
		
		while (plan_list.size() > 0) {
			plan_list.remove(0);
		}
		this.updateUI();
	}
	
//	public void setSchedule() {
//		Connection conn = bMain.getConn();
//		
////		String sql = "";
//		
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		String now_date = year + "-" + (month + 1) + "-" + days;
//		
//		try {
//			pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//			pstmt.setString(1, now_date);
//			
//			rs = pstmt.executeQuery();
//			rs.last();
//			int total = rs.getRow();
//			rs.beforeFirst();
//			
//			planCount.removeData();
//			if (total > 3) {
//				for (int i = 0; i < total; i++) {
//					rs.next();
//					int schedule_no = rs.getInt("schedule_no");
//					// DB
//					
////					PlanInfo tmpLabel = new PlanInfo()
//					
//					plan_list.add(tmpLabel);
//					if (plan_list.size() < 3) {
//						p_center.add(tmpLabel);
//					}
//					else {
//					planCount.addData(tmpLabel);
//					plan_count.setText("+" + (plan_list.size() - 2) + "...");  // 일정이 많으면 +숫자로 표시 
//					plan_count.addMouseListener(new MouseAdapter() {
//						public void mouseClicked(MouseEvent e) { planCount.setVisible(true); }
//					});
//				}
//			}
//			p_center.add(plan_count);
//			plan_list.add(plan_count);
//			} else if (total < 4) {
//				for (int i = 0; i < total; i++) {
//					rs.next();
//					int schedule_no;
//					// DB
////					PlanInfo tmpLabel = new PlanInfo();
//					plan_list.add(tmpLabel);
//					p_center.add(tmpLabel);
//				}
//			}
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		} finally {
//			bMain.closeDB(pstmt, rs);
//		}
//		
//	}
}
