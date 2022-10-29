

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class CusMgr_add {

	private JFrame frame;
	private JTextField cusName;
	private JTextField cusCarNum;
	private JTextField cusCarBrand;
	private JTextField cusCarType;
	private JTextField cusKm;
	private JTextField cusZip;
	private JTextField cusAddr;
	private JTextField cusTel;
	private JTextField cusDate;
	private JLabel lblCusTel;
	private JLabel lblCusDate;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CusMgr_add window = new CusMgr_add();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CusMgr_add() {
//		frame.setVisible(true);
//		frame.setVisible(true);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, Size.SCREEN_W, Size.SCREEN_H);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(685, 10, 822, 1007);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnCusSave = new JButton("저장");
		btnCusSave.setFont(new Font("나눔바른고딕", Font.BOLD, 30));
		btnCusSave.setBounds(352, 919, 162, 61);
		panel.add(btnCusSave);
		
		cusName = new JTextField();
		cusName.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		cusName.setBounds(304, 49, 246, 54);
		panel.add(cusName);
		cusName.setColumns(10);
		
		cusCarNum = new JTextField();
		cusCarNum.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		cusCarNum.setColumns(10);
		cusCarNum.setBounds(304, 144, 246, 54);
		panel.add(cusCarNum);
		
		cusCarBrand = new JTextField();
		cusCarBrand.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		cusCarBrand.setColumns(10);
		cusCarBrand.setBounds(304, 236, 246, 54);
		panel.add(cusCarBrand);
		
		cusCarType = new JTextField();
		cusCarType.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		cusCarType.setColumns(10);
		cusCarType.setBounds(304, 324, 246, 54);
		panel.add(cusCarType);
		
		cusKm = new JTextField();
		cusKm.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		cusKm.setColumns(10);
		cusKm.setBounds(304, 424, 246, 54);
		panel.add(cusKm);
		
		cusZip = new JTextField();
		cusZip.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		cusZip.setColumns(10);
		cusZip.setBounds(304, 526, 246, 54);
		panel.add(cusZip);
		
		cusAddr = new JTextField();
		cusAddr.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		cusAddr.setColumns(10);
		cusAddr.setBounds(304, 627, 365, 54);
		panel.add(cusAddr);
		
		cusTel = new JTextField();
		cusTel.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		cusTel.setColumns(10);
		cusTel.setBounds(304, 725, 365, 54);
		panel.add(cusTel);
		
		cusDate = new JTextField();
		cusDate.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		cusDate.setColumns(10);
		cusDate.setBounds(304, 815, 365, 54);
		panel.add(cusDate);
		
		JLabel lblCusName = new JLabel("고객이름");
		lblCusName.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		lblCusName.setBounds(63, 49, 122, 72);
		panel.add(lblCusName);
		
		JLabel lblCarNum = new JLabel("차 번호");
		lblCarNum.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		lblCarNum.setBounds(66, 132, 122, 72);
		panel.add(lblCarNum);
		
		JLabel lblCarBrand = new JLabel("브랜드");
		lblCarBrand.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		lblCarBrand.setBounds(66, 218, 122, 72);
		panel.add(lblCarBrand);
		
		JLabel lblCarType = new JLabel("차종");
		lblCarType.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		lblCarType.setBounds(66, 306, 122, 72);
		panel.add(lblCarType);
		
		JLabel lblCusKm = new JLabel("주행거리");
		lblCusKm.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		lblCusKm.setBounds(66, 408, 122, 72);
		panel.add(lblCusKm);
		
		JLabel lblCusZip = new JLabel("우편번호");
		lblCusZip.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		lblCusZip.setBounds(66, 508, 122, 72);
		panel.add(lblCusZip);
		
		JLabel lblCusAddr = new JLabel("주소");
		lblCusAddr.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		lblCusAddr.setBounds(63, 617, 122, 72);
		panel.add(lblCusAddr);
		
		lblCusTel = new JLabel("전화번호");
		lblCusTel.setBounds(63, 707, 122, 72);
		panel.add(lblCusTel);
		lblCusTel.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		
		lblCusDate = new JLabel("가입날짜");
		lblCusDate.setBounds(63, 829, 122, 72);
		panel.add(lblCusDate);
		lblCusDate.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		
//		JButton btnBackCusMain = new JButton("돌아가기");
//		btnBackCusMain.setBounds(274, 940, 290, 65);
//		btnBackCusMain.setFont(new Font("나눔바른고딕", Font.BOLD, 30));
//		frame.getContentPane().add(btnBackCusMain);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(CusMgr_add.class.getResource("/img/YellowCat.png")));
		lblNewLabel_2.setBounds(231, 38, 235, 80);
		frame.getContentPane().add(lblNewLabel_2);
		

		
		btnCusSave.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false); 
			new CusMgr();

		}
	});
		
		
//		btnBackCusMain.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				setVisible(false); 
//				new Main();
//
//			}
//		});
		
	}
}
