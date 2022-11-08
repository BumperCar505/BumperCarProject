
// db연결...
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.*;
import java.awt.event.ActionEvent;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.util.ArrayList;
import java.util.Vector;



public class RegTec extends JFrame {
	private DBConnectionMgr pool;

	private JPanel contentPane;
	private JTextField textField;
	
	private JTextField techComNum;

	private JTextField techName;
	private JTextField techTel;
	private JTextField techLv;
	private LineBorder LineBorderRegTec1;
	private LineBorder LineBorderRegTec2;
	private JTable table;
	private JTable listTech;
	private static int n;
	private int flag = 0;
	TextField tf = new TextField();
	private JTextField textField_1;
	
//	여기서부터
	 Connection conn = null;

	 Statement stmt = null;
	 
	 PreparedStatement pstmt = null;

	 ResultSet rs = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegTec frame = new RegTec();
//					frame.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public RegTec() {
		
		
		
		
		
		setVisible(true);
		pool = DBConnectionMgr.getInstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, Size.SCREEN_W, Size.SCREEN_H);
		
		
		
		
		
		contentPane = new JPanel();

		setContentPane(contentPane);
		

		
		

		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
//		panel.setForeground(new Color(255, 0, 0));
		panel.setBounds(57, 93, 535, 565);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(949, 139, 684, 745);

	
		
		textField = new JTextField();
		textField.setBounds(218, 37, 266, 62);
		textField.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		textField.setText("등록된 정비사 목록");
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(64, 113, 564, 576);
		panel_1.add(panel_2);
		contentPane.setLayout(null);
		
		
		
		
		
//		입력하는 부분들
		
		techComNum= new JTextField();
		techComNum.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		techComNum.setColumns(10);
		techComNum.setBounds(26, 10, 206, 31);
		panel.add(techComNum);
		
		techName = new JTextField();
		techName.setBounds(26, 99, 206, 31);
		techName.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		panel.add(techName);
		techName.setColumns(10);
		
		techLv = new JTextField();
		techLv.setBounds(26, 347, 206, 31);
		techLv.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		techLv.setColumns(10);
		panel.add(techLv);
		
		
		techTel = new JTextField();
		techTel.setBounds(26, 220, 206, 31);
		techTel.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		techTel.setColumns(10);
		panel.add(techTel);
		contentPane.add(panel);
		
		
//		라벨 모음
		
		
		JLabel lblNewLabel = new JLabel("정비사이름");
		lblNewLabel.setBounds(26, 45, 100, 25);
		lblNewLabel.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		panel.add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("정비사 전화번호");
		lblNewLabel_1.setBounds(26, 172, 145, 25);
		lblNewLabel_1.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		panel.add(lblNewLabel_1);
		
		
		JLabel lblNewLabel_2 = new JLabel("정비사 직급");
		lblNewLabel_2.setBounds(26, 291, 105, 25);
		lblNewLabel_2.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		panel.add(lblNewLabel_2);
		setLocationRelativeTo(null);
		
		
//		우측 표 삽입
	
	// 여기서 부터
		String header[]= { "사업자 등록 번호", "정비사 이름", "정비사전화번호", "정비사 직급"};
//
//
		DefaultTableModel model = new DefaultTableModel(header,0);
		JTable listTech = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
//
//		
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setAutoscrolls(true);
//		
		listTech.setBounds(994, 71, 548, 565);
		contentPane.add(listTech);
		JLabel lblRegTec = new JLabel("");
		lblRegTec.setFont(new Font("나눔바른고딕", Font.BOLD, 15));
//		
//		lblRegTec.setBorder(LineBorderRegTec1);    //원하는 라벨에 사용
//		lblRegTec.setBounds(57, 93, 535, 565);
//		contentPane.add(lblRegTec);
//		여기까지
//		
//		table.getColumnModel().getColumn(0).setPreferredWidth(39);
//		table.getColumnModel().getColumn(0).setMinWidth(20);
//		table.getColumnModel().getColumn(3).setResizable(false);
//		table.setRowHeight(40);
//		scrollpane.setLayout(null);
		
//		DefaultTableModel tm = new DefaultTableModel(String, Object);
		
		
		
//		새로운 도전
		
//		data = new Vector<>();
//		title = new Vector<>();
//		title.add("정비사 이름");
//		title.add("정비사 전화번호");
//		title.add("정비사 직급");
//		
//		model = new DefaultTableModel();
//		Vector result = selectAll();
//		model.setDataVector(result, title);
//	
		
		
		
//		고양이 이미지 삽입
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(655, 22, 357, 146);
		lblNewLabel_3.setIcon(new ImageIcon(RegTec.class.getResource("/img/YellowCat.png")));
		contentPane.add(lblNewLabel_3);
	
		
		
//		등록 버튼
		JButton btnTechReg = new JButton("등록");
		btnTechReg.setBounds(222, 451, 73, 33);
		btnTechReg.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		panel.add(btnTechReg);
		
//		삭제버튼
		JButton btnTechDel = new JButton("삭제");
		btnTechDel.setBounds(1459, 26, 83, 35);
		contentPane.add(btnTechDel);
		panel.setLayout(null);
		
		
		
//		다음버튼
		JButton btnTechNext = new JButton("다음");
		btnTechNext.setBounds(655, 611, 172, 49);
		btnTechNext.setFont(new Font("나눔바른고딕", Font.BOLD, 22));
		contentPane.add(btnTechNext);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(1542, 71, 17, 565);
		contentPane.add(scrollBar);
		
		JLabel lblNewLabel_4 = new JLabel("입력된 정비사");
		lblNewLabel_4.setFont(new Font("나눔바른고딕", Font.PLAIN, 21));
		lblNewLabel_4.setBounds(1184, 36, 140, 25);
		contentPane.add(lblNewLabel_4);
	
		
		
	

		
	

//		저장 버튼 누르면 옆에 저장되게
		btnTechReg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputStr[] = new String[4];
				
				inputStr[0] = techComNum.getText();
				inputStr[1] = techName.getText();
				inputStr[2] = techTel.getText();
				inputStr[3] = techLv.getText();
				 
				
				model.addRow(inputStr);
				
//				등록하고 난 뒤 다시 칸 비워주기
				techComNum.setText("");
				techName.setText("");
				techTel.setText("");
				techLv.setText("");
				
				String techCN = techComNum.getText();
				String techNM = techName.getText();
				String techTT = techTel.getText();
				String techLL = techLv.getText();
				
				

			}
		});
		
		
		
	
//		삭제 버튼 작동하기
		btnTechDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(listTech.getSelectedRow() == -1) {
					return;
				}
				else {
					model.removeRow(listTech.getSelectedRow());
				}
			}
		});
		
//		다음 버튼 누르면 서비스 등록페이지로 이동
		
		btnTechNext.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						setVisible(false); 
						new SrvReg();

					}
				});
	}


	
	
//	db연결 가즈아~!!
//      private void insertTec(String techComNum, String techName, String techTel, String techLv) throws Exception {
//
//		
//		
//		DBConnectionMgr MGR = DBConnectionMgr.getInstance();
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String sql = "INSERT INTO technician (techComNum,techName, techTel, techLv) VALUES (?,?,?,?) " ;
//		
//
//		
//		try {
//			conn = MGR.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, techComNum);
//			pstmt.setString(2, techName);
//			pstmt.setString(3, techTel);
//			pstmt.setString(4, techLv);
//			pstmt.executeUpdate();
//			
//			
//			
//		}
//		catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		finally {
//			if(conn != null) {conn.close();}
//			if(rs != null) {rs.close();}
//			if(pstmt != null) {pstmt.close();}
//			
//		}
//		
//	}
	
	
//	여기서
	
//	public Connection getConnection()
//
//	 {
//
//	  try {
//	
//	   conn=DriverManager.getConnection(url,"root","1234");
//
//	  } catch (SQLException e) {
//
//	   System.out.println("connection failed");
//
//	   e.printStackTrace();
//
//	  }
//
//	  return conn;
//
//	 }
//
//	
//	public void insertData(String ) {
//		try {
//			String sql = "INSERT INTO CRUD_TABLE(name, age) values(?, ?)";
//			// PrparedStatment객체 생성, 인자로 sql문이 주어짐
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, data.name);
//			pstmt.setInt(2, data.age);
//			// executeUpdate : insert, delete, update와 같이 값을 받아오지 않는 쿼리문 실행
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			dbClose();
//		}
//	}
	
		
		public void DBconnection() {
			
		
			try {
		 
//		 String driver="com.mysql.cj.jdbc.Driver";
//		 Class.forName("mysql.jdbc.driver.mysqlDriver");
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 String user = "root";
		 String url="jdbc:mysql://127.0.0.1:3306/cardb";
		 String pw = "1234";
		
		 conn = DriverManager.getConnection(url, user, pw);
		 System.out.println("연결성공");

		}
		catch (ClassNotFoundException cnfe) {
			System.out.println("DB 드라이버 로딩 실패 :" + cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB 접속실패 : " + sqle.toString());
		} catch (Exception e) {
			System.out.println("Unkonwn error");
			e.printStackTrace();
		 }
		finally {
			
		}
	
	}

	 

			public void insertData(String techComNum, String techName, String techTel, String techLv) {
				
////				Connection conn = DBconnection();
				try {
					String sql = "INSERT INTO technician (techComNum,techName, techTel, techLv) VALUES (?, ?, ?, ?) " ;
					// PrparedStatment객체 생성, 인자로 sql문이 주어짐
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, techComNum);
					pstmt.setString(2, techName);
					pstmt.setString(3, techTel);
					pstmt.setString(4, techLv);
					pstmt.executeUpdate();
					
					
					pstmt.executeUpdate();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} finally {
					
				}
//			
}
}
//	


	

		