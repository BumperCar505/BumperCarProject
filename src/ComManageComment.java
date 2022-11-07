import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import javax.swing.JCheckBox;

enum TableHeaderNumber {
	NUMBER, CUS_NAME, VISITED_DATE, SRVICE_NAME, STAR, COMMENT;
}

// CommentManage
public class ComManageComment extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JTable tableCommentList;
	private JScrollPane scCommentList;
	private JLabel lblYellowCat;
	private JLabel lblScore;
	private JLabel lblEndDate;
	private JLabel lblStartDate;
	private JButton btnBackCommentMain;
	private JButton btnHideComment;
	private JButton btnSearchComment;
	private JCheckBox checkBox;
	private final int FONT_SIZE = 21;
	private Vector<String> headerNames = new Vector<>(Arrays.asList("번호", "고객명", "방문날짜", "서비스내용", "별점", "코멘트"));
	
	// model1 : 시작일, model2 : 종료일
	private UtilDateModel model1, model2;
	private JDatePanelImpl datePanel1, datePanel2;
	private JDatePickerImpl datePicker1, datePicker2;
	
	public ComManageComment setFont() {
		InputStream inputStream = null;
		
		// Font Setting
		try {
            String classPath = ComManageComment.class.getResource("").getPath();
            String path = URLDecoder.decode(classPath, "UTF-8");
            inputStream = new BufferedInputStream(
                    new FileInputStream(path + "/font/NanumBarunGothic.ttf"));

            Font font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            
            lblScore.setFont(font.deriveFont(Font.PLAIN, FONT_SIZE));
            lblScore.setFont(font.deriveFont(Font.PLAIN, FONT_SIZE));
            lblEndDate.setFont(font.deriveFont(Font.PLAIN, FONT_SIZE));
            lblStartDate.setFont(font.deriveFont(Font.PLAIN, FONT_SIZE));
            btnHideComment.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            btnBackCommentMain.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            btnSearchComment.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
    		// Table Font	
            tableCommentList.setFont(font.deriveFont(Font.PLAIN, FONT_SIZE));
            tableCommentList.getTableHeader().setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            checkBox.setFont(font.deriveFont(Font.BOLD, 18));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	if(inputStream != null) {
        		try {
            		inputStream.close();
        		} catch(Exception e2) { 
        			e2.printStackTrace();
        		}
        	}
        }
		
		return this;
	}
	
	private void setTableHeader(JTable table) {
		TableColumnModel columnModel = table.getColumnModel();
		String prefix = "<html><body><table><tr><td height=50>";
		String suffix = "</td></tr></table></body><html>";
		
		for (int col = 0; col < columnModel.getColumnCount(); col++) {
		    TableColumn column = columnModel.getColumn(col);
		    String text = prefix + columnModel.getColumn(col).getHeaderValue().toString() + suffix;
		    column.setHeaderValue(text);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		
		if(obj == btnHideComment) {
			int[] selectedRows = tableCommentList.getSelectedRows();
			
			if(selectedRows.length == 0) {
				DialogManager.createMsgDialog("선택된 셀이 없습니다.", "\\img\\information5.png",
						"에러", JOptionPane.PLAIN_MESSAGE);
				return;
			}
			
			int result = DialogManager.createMsgDialog("정말로 선택한 댓글을 숨길까요?", "\\img\\question6.png",
					"알림", JOptionPane.YES_NO_OPTION);
			if(result == 0) {
				DialogManager.createMsgDialog("정상적으로 처리되었습니다.", "\\img\\success1.png",
						"알림", JOptionPane.PLAIN_MESSAGE);
			} else {
				DialogManager.createMsgDialog("작업이 취소되었습니다.", "\\img\\information5.png",
						"알림", JOptionPane.PLAIN_MESSAGE);
			}
		} else if(obj == btnSearchComment) {
			boolean flag = false;
			int startYear = model1.getYear();
			int startMonth = model1.getMonth();
			int startDay = model1.getDay();
			int endYear = model2.getYear();
			int endMonth = model2.getMonth();
			int endDay = model2.getDay();
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			try {
				Date startDate = dateFormat.parse(String.valueOf(startYear) + startMonth + startDay);
				Date endDate = dateFormat.parse(String.valueOf(endYear) + endMonth + endDay);
				
				if(startDate.after(endDate)) {
					flag = true;
				}
			} catch(ParseException ex) {
				// ex.getMessage();
				DialogManager.createMsgDialog("달력 처리하는 과정에서 문제 발생", "\\img\\information5.png",
						"에러", JOptionPane.PLAIN_MESSAGE);
			}
			
			if(flag == true) {
				DialogManager.createMsgDialog("방문 종료일은 방문 시작일보다<br> 이전날짜가 될수없습니다.", "\\img\\information5.png",
						"에러", JOptionPane.PLAIN_MESSAGE);
			} else {
				DialogManager.createMsgDialog("검색이 완료되었습니다.", "\\img\\success1.png",
						"알림", JOptionPane.PLAIN_MESSAGE);
			}
		} else if(obj == checkBox) {
			if(checkBox.isSelected() == true) {
				datePicker1.setVisible(true);
				datePicker2.setVisible(true);
				model1.setSelected(true);
				model2.setSelected(true);
			} else {
				datePicker1.setVisible(false);
				datePicker2.setVisible(false);
				model1.setSelected(false);
				model2.setSelected(false);
			}
		} else if(obj == btnBackCommentMain) {
			new ComMyPage();
			this.dispose();
		}
	}
	
	// 조회된 데이터가(모든 컬럼) List<Vector<String>> 타입으로 반환됩니다.
	private List<Vector<String>> searchDbReviews() {
		// DB에서 데이터 전체 조회
		DBConnectionMgr mgr = DBConnectionMgr.getInstance();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<Vector<String>> datas = new ArrayList<Vector<String>>();
		String query = "SELECT re.rvwNum, re.rvwStar, re.rvwCont, re.rvwDate, re.rvwDelete, "
				+ "cus.cusName, ser.srvName "
				+ "FROM review AS re "
				+ "INNER JOIN maintenance AS main ON re.rvwMainNum = main.mainNum "
				+ "INNER JOIN customer AS cus ON main.mainCusNum = cus.cusNum "
				+ "INNER JOIN service AS ser ON main.mainSrvNum = ser.srvNum "
				+ "ORDER BY re.rvwNum ASC";
		
		try {
			conn = mgr.getConnection();
			psmt = conn.prepareStatement(query);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				int number = rs.getInt("rvwNum");
				int star = rs.getInt("rvwStar");
				String comment = rs.getString("rvwCont");
				String visitedDate = rs.getString("rvwDate");
				String delete = rs.getString("rvwDelete");
				String cusName = rs.getString("cusName");
				String srvName = rs.getString("srvName");
				
				Vector<String> data = new Vector<>();
				data.add(String.valueOf(number));
				data.add(cusName);
				data.add(visitedDate);
				data.add(srvName);
				data.add(String.valueOf(star));
				data.add(comment);
				
				if(delete.equals("Y")) {
					hideStar(data, TableHeaderNumber.STAR.ordinal());
					hideComment(data, TableHeaderNumber.COMMENT.ordinal());
				} else {
					showStar(data, TableHeaderNumber.STAR.ordinal());
				}
				
				datas.add(data);
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(this, ex.getMessage());
		} catch(Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(this, ex.getMessage());
		} finally {
			try {
				if(rs != null) {rs.close();}
				if(psmt != null) {psmt.close();}
				if(conn != null) {conn.close();}
			} catch(SQLException ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(this, ex.getMessage());
			}
		}
		
		return datas;
	}
	
	// 리뷰를 기간 한정해서 조회
	private List<Vector<String>> searchDbReviews(Calendar startDate, Calendar endDate) {
		SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		String sDate = simpleDateFormat.format(startDate.getTime());
		String eDate = simpleDateFormat.format(endDate.getTime());
		
		DBConnectionMgr mgr = DBConnectionMgr.getInstance();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<Vector<String>> datas = new ArrayList<Vector<String>>();
		String query = "SELECT re.rvwNum, re.rvwStar, re.rvwCont, re.rvwDate, re.rvwDelete, "
				+ "cus.cusName, ser.srvName "
				+ "FROM review AS re "
				+ "INNER JOIN maintenance AS main ON re.rvwMainNum = main.mainNum "
				+ "INNER JOIN customer AS cus ON main.mainCusNum = cus.cusNum "
				+ "INNER JOIN service AS ser ON main.mainSrvNum = ser.srvNum "
				+ "WHERE re.rvwDate >= ? AND re.rvwDate <= ? "
				+ "ORDER BY re.rvwNum ASC";
		
		try {
			conn = mgr.getConnection();
			psmt = conn.prepareStatement(query);
			psmt.setString(1, sDate);
			psmt.setString(2, eDate);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				int number = rs.getInt("rvwNum");
				int star = rs.getInt("rvwStar");
				String comment = rs.getString("rvwCont");
				String visitedDate = rs.getString("rvwDate");
				String delete = rs.getString("rvwDelete");
				String cusName = rs.getString("cusName");
				String srvName = rs.getString("srvName");
				
				Vector<String> data = new Vector<>();
				data.add(String.valueOf(number));
				data.add(cusName);
				data.add(visitedDate);
				data.add(srvName);
				data.add(String.valueOf(star));
				data.add(comment);
				
				if(delete.equals("Y")) {
					hideStar(data, TableHeaderNumber.STAR.ordinal());
					hideComment(data, TableHeaderNumber.COMMENT.ordinal());
				} else {
					showStar(data, TableHeaderNumber.STAR.ordinal());
				}
				
				datas.add(data);
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(this, ex.getMessage());
		} catch(Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(this, ex.getMessage());
		} finally {
			try {
				if(rs != null) {rs.close();}
				if(psmt != null) {psmt.close();}
				if(conn != null) {conn.close();}
			} catch(SQLException ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(this, ex.getMessage());
			}
		}
		
		return datas;
	}

	private double getDbAvgReviewScore() {
		// DB에서 평균점수 조회
		return 0;
	}
	
	private double getDbAvgReviewScore(Date startDate, Date endDate) {
		// DB에서 기간한정해서 평균점수 조회
		return 0;
	}
	
	private boolean hideDbReviews(int[] selectedNumbers) {
		// DB에 저장되어있는 리뷰중 선택한 리뷰들을 코멘트와 별점 안보이게 처리
		return true;
	}
	
	private boolean showDbReviews(int[] selectedNumbers) {
		// DB에 저장되어있는 리뷰중 선택한 리뷰들을 코멘트와 별점 보이게 변경
		return true;
	}
	
	private void showStar(Vector<String> data, int idx) {
		// 가져온 리뷰가 숨김처리가 아니라면 별점 표시
		String strStar = "";
		for(int i = 0; i < Integer.parseInt(data.get(idx)); ++i) {
			strStar += "★";
		}
		data.set(idx, strStar);
	}
	
	private void hideStar(Vector<String> data, int idx) {
		// 가져온 리뷰가 숨김처리라면 별점 대체
		data.set(idx, "");
	}
	
	private void hideComment(Vector<String> data, int idx) {
		// 가져온 리뷰가 숨김처리라면 문자열 대체
		data.set(idx, "숨김처리된 댓글입니다.");
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComManageComment frame = new ComManageComment();
					frame.setVisible(true);
					frame.setFont();
					
					// 리뷰 전체 들고오는 테스트 코드
					// frame.searchDbReviews();
					
					// 기간 한정해서 들고오는 부분 테스트 코드
					// Calendar startDate = Calendar.getInstance();
					// startDate.set(2022, 9, 10);
					// Calendar endDate = Calendar.getInstance();
					// endDate.set(2022, 10, 3);
					// frame.searchDbReviews(startDate, endDate);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ComManageComment() {
		setTitle("다고쳐카센터 - 코멘트관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, Size.SCREEN_W, Size.SCREEN_H);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null); // 이거 없으면 정상적으로 레이아웃 안그려진다..
		
		// 값은 임의로 집어넣은것으로 추후 DB에서 가져와야함
		Object[] columns = {"번호", "고객명", "방문날짜", "서비스내용", "별점", "코멘트"};
		Object[][] rowNames = {
				{"1", "홍길동", "2022-02-11", "타이어교체", "★★★", "수리하는데 시간이 너무 오래걸림"},
				{"2", "김홍도", "2022-02-13", "엔진오일교체", "★★★★★", "가성비있게 교체한 것 같습니다..."
						+ "위치도 좋구요~^^"}
		};
		
		// Text Align Center
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		render.setHorizontalAlignment(SwingConstants.CENTER);
		
		tableCommentList = new JTable(rowNames, columns);
		tableCommentList.setAutoCreateRowSorter(true);
		tableCommentList.setDefaultEditor(Object.class, null); // 테이블 값 수정 안되게
		tableCommentList.getTableHeader().setResizingAllowed(false);
		tableCommentList.getColumn("번호").setCellRenderer(render);
		tableCommentList.getColumn("고객명").setCellRenderer(render);
		tableCommentList.getColumn("방문날짜").setCellRenderer(render);
		tableCommentList.getColumn("서비스내용").setCellRenderer(render);
		tableCommentList.getColumn("별점").setCellRenderer(render);
		tableCommentList.getColumn("코멘트").setCellRenderer(render);
		
		// Column Not Move
		tableCommentList.getTableHeader().setReorderingAllowed(false);
		
		// Column Change Width
		tableCommentList.getColumn("서비스내용").setPreferredWidth(200);
		tableCommentList.getColumn("코멘트").setPreferredWidth(500);
		
		// Change Row Height 
		tableCommentList.setRowHeight(50);
		
		// Set Row Header
		setTableHeader(tableCommentList);
		
		// Table Set Area
		scCommentList = new JScrollPane(tableCommentList);
		scCommentList.setVisible(true);
		scCommentList.setBounds(100, 145, 1462, 750);
		
		contentPane.add(scCommentList);
		
		lblYellowCat = new JLabel("");
		lblYellowCat.setIcon(new ImageIcon(ComManageComment.class.getResource("/img/YellowCat.png")));
		lblYellowCat.setBounds(710, 50, 230, 80);
		contentPane.add(lblYellowCat);
		
		btnBackCommentMain = new JButton("돌아가기");
		btnBackCommentMain.setBackground(new Color(244, 204, 204));
		btnBackCommentMain.setBounds(670, 918, Size.BTN_B_W, Size.BTN_B_H);
		btnBackCommentMain.setBorder(new BevelBorder(BevelBorder.RAISED, Color.red, Color.red, 
				Color.red, Color.red));
		btnBackCommentMain.addActionListener(this);
		contentPane.add(btnBackCommentMain);
		
		btnHideComment = new JButton("댓글 숨기기");
		btnHideComment.setBackground(new Color(244, 204, 204));
		btnHideComment.setBounds(100, 70, Size.BTN_S_W, Size.BTN_S_H);
		btnHideComment.setBorder(new BevelBorder(BevelBorder.RAISED, Color.red, Color.red, 
				Color.red, Color.red));
		btnHideComment.addActionListener(this);
		contentPane.add(btnHideComment);
		
		lblScore = new JLabel("평균 별점 : 4.0");
		lblScore.setBounds(262, 74, 160, 42);
		contentPane.add(lblScore);
		
		btnSearchComment = new JButton("검색하기");
		btnSearchComment.setBorder(new BevelBorder(BevelBorder.RAISED, Color.red, Color.red, 
				Color.red, Color.red));
		btnSearchComment.setBackground(new Color(244, 204, 204));
		btnSearchComment.setBounds(1412, 70, 150, 50);
		btnSearchComment.addActionListener(this);
		contentPane.add(btnSearchComment);
		
		lblEndDate = new JLabel("방문 종료일");
		lblEndDate.setBounds(1160, 94, 110, 42);
		contentPane.add(lblEndDate);
		
		lblStartDate = new JLabel("방문 시작일");
		lblStartDate.setBounds(1160, 52, 110, 42);
		contentPane.add(lblStartDate);
		
		model1 = new UtilDateModel();
		model1.setSelected(false);
		datePanel1 = new JDatePanelImpl(model1);
		datePicker1 = new JDatePickerImpl(datePanel1);
		datePicker1.setBounds(1275, 61, 125, 40);
		datePicker1.setVisible(false);
		contentPane.add(datePicker1);
		
		model2 = new UtilDateModel();
		model2.setSelected(false);
		datePanel2 = new JDatePanelImpl(model2);
		datePicker2 = new JDatePickerImpl(datePanel2);
		datePicker2.setBounds(1275, 102, 125, 40);
		datePicker2.setVisible(false);
		contentPane.add(datePicker2);
		
		checkBox = new JCheckBox("범위 검색 사용");
		checkBox.setBounds(1155, 25, 135, 35);
		checkBox.addActionListener(this);
		contentPane.add(checkBox);
	}
}
