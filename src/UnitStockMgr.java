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

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class UnitStockMgr extends JFrame {

	protected static final String model = null;
	private JPanel contentPane;
	private JTable table;
	private JButton btnEditUnitStock;
	private JButton btnDelUnitStock;
	private JButton btnBackUnitStockMain;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnitStockMgr frame = new UnitStockMgr();
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
	public UnitStockMgr() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, Size.SCREEN_W, Size.SCREEN_H);
		contentPane = new JPanel();
		contentPane.setEnabled(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

//		폼 창이 화면 가운데서 뜨게 하는 기능
		setLocationRelativeTo(null); //--
		setContentPane(contentPane);
		
//		테이블 생성

		String header[] = {"No","부품번호","부품명","벤더", "부품수량"};
		String contents[][] = {
				{"1", "abb01", "타이어", "한국타이어", "22"},
				{"2", "gdd54", "타이어", "금호타이어", "17"},
				{"3","kr-oil", "엔진오일", "SK", "30"},
				{"4","goil20", "엔진오일", "GS칼텍스", "16"},
		};
		
		DefaultTableModel model = new DefaultTableModel(contents, header);
		JTable table = new JTable(model);
		
		table.setFont(new Font("나눔바른고딕", Font.PLAIN, 21));

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

		
		JButton btnAddUnitStock = new JButton("추가");
		btnAddUnitStock.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		btnAddUnitStock.setBounds(239, 174, Size.BTN_S_W, Size.BTN_S_H);
		contentPane.add(btnAddUnitStock);
		
		btnEditUnitStock = new JButton("수정");
		btnEditUnitStock.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		btnEditUnitStock.setBounds(401, 174, 150, 50);
		contentPane.add(btnEditUnitStock);
		
		btnDelUnitStock = new JButton("삭제");
		btnDelUnitStock.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		btnDelUnitStock.setBounds(563, 174, 150, 50);
		contentPane.add(btnDelUnitStock);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(UnitStockMgr.class.getResource("/img/YellowCat.png")));
		lblNewLabel.setBounds(704, 29, 255, 112);
		contentPane.add(lblNewLabel);
		
		// 돌아가기 버튼
		btnBackUnitStockMain = new JButton("돌아가기");
		btnBackUnitStockMain.setFont(new Font("나눔바른고딕", Font.PLAIN, 21));
		btnBackUnitStockMain.setBounds(687, 824, Size.BTN_B_W, Size.BTN_B_H);
		contentPane.add(btnBackUnitStockMain);
		
		// 구매 이력 버튼
		JButton btnUnitBuyHistory = new JButton("구매 이력");
		btnUnitBuyHistory.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		btnUnitBuyHistory.setBounds(1275, 174, 150, 50);
		contentPane.add(btnUnitBuyHistory);
		
		
		// 구매 이력 버튼 누르면 실행 됨 -> 새 폼 띄우기
		btnUnitBuyHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UnitBuyHistory history = new UnitBuyHistory();
				history.setVisible(true);
			}
		});
		
		
		
		
		//추가 버튼 누르면 실행됨 -> 새 폼 띄우기
		btnAddUnitStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UnitStockMgr_add add = new UnitStockMgr_add();
				add.setVisible(true);
			}
		});
		
		// 수정 버튼 누르면 실행됨 -> 새 폼 띄우기 
		btnEditUnitStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UnitStockMgr_edit edit = new UnitStockMgr_edit();
				edit.setVisible(true);
						
			}
		});
		
		// 삭제 버튼 누르면 실행됨
		btnDelUnitStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = table.getSelectedRow();
				
				if(index == -1){
		            JOptionPane.showConfirmDialog(null, "셀을 선택하지 않으셨습니다.", "삭제", JOptionPane.DEFAULT_OPTION);
		        }
				
		        else {
		        	try {
		        		JLabel label = new JLabel("<html><center><br>삭제하시겠습니까?");
			            String classPath = UnitStockMgr.class.getResource("").getPath();
			            String path = URLDecoder.decode(classPath, "UTF-8");
			            path += "\\img\\YellowCat.png";
			            ImageIcon icon = new ImageIcon(path);
			            label.setIcon(icon);
			            label.setHorizontalAlignment(SwingConstants.CENTER);
			            
			            int result = JOptionPane.showConfirmDialog(null, label, "삭제", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
			            if (result == 0) {
			            	model.removeRow(index);
			            } else if (result == 1) {
			            	   
			            	}
			            } catch(Exception ex) {
			            	
			      }
		       }
			}
		});
		
		// 돌아가기 버튼 누르면 실행됨 -> 현재 화면 닫고 메인화면 띄우기
		btnBackUnitStockMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 메인화면은 visible true, 현재화면은 false

			}
		});
		
	}



	
	
}




