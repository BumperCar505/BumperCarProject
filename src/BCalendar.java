import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class BCalendar extends JFrame {

	BMain bMain;
	ArrayList<BCell> cell_list = new ArrayList<BCell>();
	JPanel p_north, p_center, p_south;
	JButton prev, next;
	JLabel la_month;
	JPanel[] p_dayOfWeek = new JPanel[7];
	JLabel[] la_dayOfWeek = new JLabel[7];
	
	String[] dayOfWeek = { "일", "월", "화", "수", "목", "금", "토" };

	Calendar cal = Calendar.getInstance();
	
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH);
	int days = 0;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BCalendar frame = new BCalendar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BCalendar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, Size.SCREEN_W, Size.SCREEN_H);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BCalendar.class.getResource("/img/YellowCat.png")));
		lblNewLabel.setBounds(594, 31, 285, 86);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(83, 140, 1261, 661);
		contentPane.add(panel);
		
		p_north = new JPanel();
		p_north.setBounds(0, 0, 0, 0);
		panel.add(p_north);
		prev = new JButton("이전 달");
		prev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (month > 0) {
					month--;
				} else {
					year--;
					month = 11;
				}
				setCal();
			}
			
		});
		
		next = new JButton("다음 달");
		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (month < 11) {
					month ++;
				} else {
					year++;
					month = 0;
				}
				setCal();
			}
		});
		
		la_month = new JLabel();
		la_month.setHorizontalAlignment(JLabel.CENTER);
		
		p_north.setLayout(new BorderLayout());
		p_north.add(la_month, BorderLayout.CENTER);
		p_north.add(prev, BorderLayout.WEST);
		p_north.add(next, BorderLayout.EAST);
		
		p_north.setPreferredSize(new Dimension(800, 50));
		p_center = new JPanel();
		p_center.setBounds(0, 0, 0, 0);
		panel.add(p_center);
		
		p_center.setLayout(new GridLayout(1, 7));
		p_center.setPreferredSize(new Dimension(800, 50));
		p_south = new JPanel();
		p_south.setBounds(0, 0, 800, 1012);
		panel.add(p_south);
		p_south.setLayout(new GridLayout(6, 7));
		p_south.setPreferredSize(new Dimension(800, 420));
		
		JButton btnBackCusMain = new JButton("돌아가기");
		btnBackCusMain.setFont(new Font("NanumBarunGothic", Font.PLAIN, 21));
		btnBackCusMain.setBounds(566, 813, Size.BTN_B_W, Size.BTN_B_H);
		contentPane.add(btnBackCusMain);
		
		initCal();
		setCal();
		setWeek();
	}
	
	public void setWeek() {
		for (int i=0; i< p_dayOfWeek.length; i++) {
			p_dayOfWeek[i] = new JPanel();
			la_dayOfWeek[i] = new JLabel("");
			
			la_dayOfWeek[i].setText(dayOfWeek[i]);
			if (i == 0) {  // 일요일 
				la_dayOfWeek[i].setForeground(Color.RED);
			}
			if (i == 6) {  // 토요일 
				la_dayOfWeek[i].setForeground(Color.BLUE);
			}
			p_dayOfWeek[i].add(la_dayOfWeek[i]);
			p_dayOfWeek[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			p_center.add(p_dayOfWeek[i]);
		}
	}
	
	public void initCal() {
		for (int i = 0; i < 42; i++) {
			BCell p_day = new BCell();
			cell_list.add(p_day);
			p_south.add(cell_list.get(i));
		}
	}
	
	public void setCal() {
		for (int i = 0; i < cell_list.size(); i++) {
			BCell tmpCell = cell_list.get(i);
			tmpCell.labelDel();
		}
		days = 0;
		
		la_month.setText(year + "년 " + (month + 1) + "월");
		la_month.setFont(new Font("NanumBarunGothic", Font.BOLD, 21));
		cal.set(year, month, 1);
		
		int startday = cal.get(Calendar.DAY_OF_WEEK);
		int lastday = cal.getActualMaximum(Calendar.DATE);
		
		for (int i = 0; i < 42; i++) {
			BCell tmp_cell = cell_list.get(i);
			if((i + 1) >= startday && days < lastday) {
				days++;
				tmp_cell.setCellDate(year, month, days);
				tmp_cell.setMonthDay();
			}
			else {
				tmp_cell.setCellDate(0, 0, 0);
				tmp_cell.setOtherMonthDay();
			}
			
			if ((i % 7) == 6) {
				cell_list.get(i).la_day.setForeground(Color.BLUE);
			}
			else if ((i % 7) == 0) {
				cell_list.get(i).la_day.setForeground(Color.RED);
			}
		}
	}
}
