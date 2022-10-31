

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					
//					window.frame.setVisible(true); 위에 있는 걸 아래로 옮기고 수정했다아아
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
//		frame.setLocationRelativeTo(null);
		initialize();
		frame.setVisible(true); //이거 연결한다고 내가 진짜아ㅏ.. 이렇게 하면 창 연결된다아아아
		frame.setLocationRelativeTo(null); //화면 가운데에 뜨기
//		main();
	
	}

	/**
	 * Initialize the contents of the frame.s
	 */
	public void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1300, Size.SCREEN_H);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnEditComInfo = new JButton("업체정보 수정");
		btnEditComInfo.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		btnEditComInfo.setBounds(498, 114, Size.BTN_B_W, 45);
		frame.getContentPane().add(btnEditComInfo);
		
		JButton btnEditTechList = new JButton("정비사 목록 수정");
		btnEditTechList.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		btnEditTechList.setBounds(498, 177, Size.BTN_B_W, 45);
		frame.getContentPane().add(btnEditTechList);
		
		
		JButton btnEditSrvInfo = new JButton("서비스 목록 수정");
		btnEditSrvInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditSrvInfo.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		btnEditSrvInfo.setBounds(498, 246, Size.BTN_B_W, 45);
		frame.getContentPane().add(btnEditSrvInfo);
		
		JButton btnMgrUnitStock = new JButton("부품 재고 관리");
		btnMgrUnitStock.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		btnMgrUnitStock.setBounds(498, 308, Size.BTN_B_W, 45);
		frame.getContentPane().add(btnMgrUnitStock);
		
		JButton btnMgrBook = new JButton("예약 관리");
		btnMgrBook.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		btnMgrBook.setBounds(498, 363, Size.BTN_B_W, 45);
		frame.getContentPane().add(btnMgrBook);
		
		JButton btnMgrCustomer = new JButton("고객 관리");
		btnMgrCustomer.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		btnMgrCustomer.setBounds(498, 418,Size.BTN_B_W, 45);
		frame.getContentPane().add(btnMgrCustomer);
		
		JButton btnMgrSales = new JButton("매출 관리");
		btnMgrSales.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		btnMgrSales.setBounds(498, 473,Size.BTN_B_W, 45);
		frame.getContentPane().add(btnMgrSales);
		
		JButton btnMgrComment = new JButton("코멘트 관리");
		btnMgrComment.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		btnMgrComment.setBounds(498, 538, Size.BTN_B_W, 45);
		frame.getContentPane().add(btnMgrComment);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/img/YellowCat.png")));
		lblNewLabel.setBounds(524, 24, 237, 80);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		// 페이지 이동 가즈아~!!!
		
//		고객관리페이지로
		   btnMgrCustomer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false); 
				new CusMgr();

			}
		});
		   
//			매출관리페이지로
		   btnMgrSales.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false); 
				new SalesMgr();

			}
		});
	}
	
	
}
