import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class TechListEdit extends JFrame {

	
	
	private JPanel contentPane;
	private JTable table;
	private JButton btnEditTech;
	private JButton btnDelTech;
	private JButton btnBackMain;
	
/////////////////////////////////////////////
	//MemberMgr mgr;
	//MemberBean bean;
	
////////////////////////////////////////////////
	public String selectedSrvName;
	

	//Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TechListEdit frame = new TechListEdit();
					frame.setVisible(true);
					//frame.reload();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the frame.
	 */
	
	public void reload() {
		
	}
	
	public TechListEdit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, Size.SCREEN_W, Size.SCREEN_H);
		contentPane = new JPanel();
		contentPane.setEnabled(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));


//		폼 창이 화면 가운데서 뜨게 하는 기능
		setLocationRelativeTo(null); //--
		setContentPane(contentPane);
		
		
//		테이블 생성
		
		//db데이터 select, update 하는 클래스
		MemberMgr mgr = new MemberMgr(); 
		
		//db에 넣을 데이터 저장하는 클래스
		
		MemberBean bean =  mgr.lastNum();
		int techIndexNum = bean.getTechNum();
		
		

		String header[] = {"techNum","정비사 이름","전화번호","직급"};
		String contents[][] = new String[techIndexNum][4]; 
			
			
		for(int i = 0; i < techIndexNum; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				bean =  mgr.select(i + 1);
				
				if(j == 0)
				{
					contents[i][j] = Integer.toString(bean.getTechNum());	
				}
				else if(j == 1)
				{
					contents[i][j] = bean.getTechName();
				}
				else if(j == 2)
				{
					contents[i][j] = bean.getTechTel();
				}
				else if (j == 3)
				{
					contents[i][j] = bean.getTechLv();
				}
				
			}
			
		}
		
		
		
		DefaultTableModel model = new DefaultTableModel(contents, header);
		JTable table = new JTable(model);
		table.setAutoCreateRowSorter(true);

		table.getColumnModel().getColumn(0).setPreferredWidth(39);
		table.getColumnModel().getColumn(0).setMinWidth(20);
		table.getColumnModel().getColumn(3).setResizable(false);
		contentPane.setLayout(null);

		table.setBounds(247, 231, 1170, 671);
//		테이블에 열 제목 나오게 하는 코드. 참고 : https://yyman.tistory.com/550
		JScrollPane scrollPane = new JScrollPane(table);
		//--
		scrollPane.setBounds(239, 236, 1186, 533);
		scrollPane.setAutoscrolls(true);
		contentPane.add (scrollPane) ; 
//		테이블 행 높이 조절
		table.setRowHeight(40);

		
		JButton btnAddTech = new JButton("추가");
		btnAddTech.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		btnAddTech.setBounds(239, 174, Size.BTN_S_W, Size.BTN_S_H);
		contentPane.add(btnAddTech);
		
		btnEditTech = new JButton("수정");
		btnEditTech.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		btnEditTech.setBounds(401, 174, 150, 50);
		contentPane.add(btnEditTech);
		
		btnDelTech = new JButton("삭제");
		btnDelTech.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		btnDelTech.setBounds(563, 174, 150, 50);
		contentPane.add(btnDelTech);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TechListEdit.class.getResource("/img/YellowCat.png")));
		lblNewLabel.setBounds(704, 29, 255, 112);
		contentPane.add(lblNewLabel);
		
		// 돌아가기 버튼
		btnBackMain = new JButton("돌아가기");
		btnBackMain.setFont(new Font("나눔바른고딕", Font.PLAIN, 21));
		btnBackMain.setBounds(687, 824, Size.BTN_B_W, Size.BTN_B_H);
		contentPane.add(btnBackMain);
		
		
		
		
		//추가 버튼 누르면 실행됨 -> 새 폼 띄우기
		btnAddTech.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TechListEdit_add add = new TechListEdit_add();
				add.setVisible(true);
			}
		});
		
		
		
		
		// 수정 버튼 누르면 실행됨 -> 새 폼 띄우기 
		btnEditTech.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int editIndex = table.getSelectedRow();
				//String s1 = Integer.toString(editIndex);
				
				//System.out.println(s1);
				
				
				 //String selectedSrvName = table.getValueAt(editIndex, 1).toString();
				TechListEdit_edit edit = new TechListEdit_edit(editIndex);
				
				if(editIndex == -1){
		            JOptionPane.showConfirmDialog(null, "셀을 선택하지 않으셨습니다.", "삭제", JOptionPane.DEFAULT_OPTION);
		        }
				else {
					edit.setVisible(true);
					dispose();
					
				}
				
				
			}
		});
		
		
		
		
		
		// 삭제 버튼 누르면 실행됨
		btnDelTech.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = table.getSelectedRow();
				
				if(index == -1){
		            JOptionPane.showConfirmDialog(null, "셀을 선택하지 않으셨습니다.", "삭제", JOptionPane.DEFAULT_OPTION);
		        }
				
		        else {
		        	try {
		        		int result = DialogManager.createMsgDialog("<html><h3>삭제하시겠습니까?</h3>", "/img/trash.png", "삭제", JOptionPane.YES_NO_OPTION);
   
			            if (result == 0) {
			            	model.removeRow(index);
			            	DialogManager.createMsgDialog("<html><h3>삭제되었습니다.</h3>", "/img/success1.png", "삭제", JOptionPane.CLOSED_OPTION);
			            } else if (result == 1) {
			            	   
			            	}
			            } catch(Exception ex) {

			      }
		       }
			}
		});
		
		// 돌아가기 버튼 누르면 실행됨 -> 현재 화면 닫고 메인화면 띄우기
		btnBackMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 메인화면은 visible true, 현재화면은 false

			}
		});
		
		
		
		
		
				
		
	}
	
	
}




