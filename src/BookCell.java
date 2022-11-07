import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

// 날짜 정보가 들어있는 
public class BookCell extends JPanel {

	BookCalendar bookCalendar;
	BookSchedule schedule;
	BookDetail detail;
	BookMain bMain;
	PlanCount planCount;
	ArrayList<JLabel> plan_list = new ArrayList<JLabel>();
	JLabel la_day, plan_count;
	String printDay;
	JPanel p_center, lday;
	int year, month, days;
	
	
	public BookCell() {
		lday = new JPanel();
		la_day = new JLabel();
		lday.add(la_day);
		
		plan_count = new JLabel();
		plan_count.setPreferredSize(new Dimension(110, 13));
		p_center = new JPanel();
		
		setLayout(new BorderLayout());
		add(lday, BorderLayout.NORTH);
		add(p_center);
		p_center.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 1));
		
		setPreferredSize(new Dimension(60, 60));

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
		lday.setBackground(null);
		setCellColor(null);
		setBorder(BorderFactory.createEmptyBorder());
		la_day.setText("");
	}
	
	public void setMonthDay() {
		lday.setBackground(Color.WHITE);  // 날짜부분 배경
		setCellColor(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		la_day.setText("" + days);
		
		
		p_center.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				// cell 클릭
				JFrame f = new JFrame((month+1) + "월 " + days + "일");
				f.setLayout(null);
				f.setSize(500,500);
				f.setLocationRelativeTo(null);
				
				JLabel l = new JLabel();
				l.setHorizontalAlignment(JLabel.CENTER);
				l.setBounds(193, 10, 98, 36);
				l.setText((month+1) + "월 " + days + "일");
				l.setFont(new Font("NanumBarunGothic", Font.BOLD, 21));
				f.add(l);
//				f.add(l, BorderLayout.NORTH);
				
				JButton btnAdd = new JButton("추가");
				btnAdd.setBounds(192, 401, 100, 50);
				btnAdd.setFont(new Font("NanumBarunGothic", Font.BOLD, 16));
				f.add(btnAdd);
				
				f.show();
				
				btnAdd.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						BookDetail detail = new BookDetail();
						detail.setVisible(true);
					}
				});
				
			}
		});
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
	
	public void setSchedule() {
		Connection conn = bMain.getConn();
		
		String sql = "SELECT mainNum, customer.cusName, service.srvName, mainStartDay, mainStartDate "
				+ "FROM maintenace "
				+ "JOIN customer "
				+ "ON customer.cusNum = maintenance.mainCusNum "
				+ "JOIN service "
				+ "ON service.srvNum = maintenance.mainSrvNum "
				+ "WHERE mainStartDay = ? ";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String now_date = year + "-" + (month + 1) + "-" + days;
		
		try {
			pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			pstmt.setString(1, now_date);
			
			rs = pstmt.executeQuery();
			rs.last();
			int total = rs.getRow();
			rs.beforeFirst();
			
			planCount.removeData();
			if (total > 3) {
				for (int i = 0; i < total; i++) {
					rs.next();
					int mainNum = rs.getInt("mainNum");
					String cusName = rs.getString("cusName");
					String cusCarNum = rs.getString("cusCarNum");
					String srvName = rs.getString("srvName");
					String cusTel = rs.getString("cusTel");
					String mainStartDate = rs.getString("mainStartDate");
					String mainEndDate = rs.getString("mainEndDate");
					// DB
					
					PlanInfo tmpLabel = new PlanInfo(mainNum, cusName, cusCarNum, srvName, cusTel, bMain, mainStartDate, mainEndDate, year, month,
							 days, planCount);
					
					plan_list.add(tmpLabel);
					if (plan_list.size() < 3) {
						p_center.add(tmpLabel);
					}
					else {
					planCount.addData(tmpLabel);
					plan_count.setText("+" + (plan_list.size() - 2) + "...");  // 일정이 많으면 +숫자로 표시 
					plan_count.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) { planCount.setVisible(true); }
					});
				}
			}
			p_center.add(plan_count);
			plan_list.add(plan_count);
			} else if (total < 4) {
				for (int i = 0; i < total; i++) {
					rs.next();
					int mainNum = rs.getInt("mainNum");
					String cusName = rs.getString("cusName");
					String cusCarNum = rs.getString("cusCarNum");
					String srvName = rs.getString("srvName");
					String cusTel = rs.getString("cusTel");
					String mainStartDate = rs.getString("mainStartDate");
					String mainEndDate = rs.getString("mainEndDate");
					// DB
					PlanInfo tmpLabel = new PlanInfo(mainNum, cusName, cusCarNum, srvName, cusTel, bMain, mainStartDate, mainEndDate, year, month,
							 days, planCount);
					plan_list.add(tmpLabel);
					p_center.add(tmpLabel);
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			bMain.closeDB(pstmt, rs);
		}
		
	}
}