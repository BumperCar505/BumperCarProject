

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.UIManager;

import com.mysql.cj.xdevapi.Statement;

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
	private JLabel lblNewLabel_2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CusMgr_add window = new CusMgr_add();
//					window.frame.setVisible(true);
					
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

		initialize();
		frame.setVisible(true);
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
		panel.setBounds(680, 0, 822, 1007);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		// 저장버튼
		JButton btnCusSave = new JButton("저장");
		btnCusSave.setFont(new Font("나눔바른고딕", Font.BOLD, 30));
		btnCusSave.setBounds(248, 743, 162, 61);
		panel.add(btnCusSave);
		
		//텍스트필드
		cusName = new JTextField();
		cusName.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		cusName.setBounds(304, 10, 246, 54);
		panel.add(cusName);
		cusName.setColumns(10);
		
		cusCarNum = new JTextField();
		cusCarNum.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		cusCarNum.setColumns(10);
		cusCarNum.setBounds(304, 96, 246, 54);
		panel.add(cusCarNum);
		
		cusCarBrand = new JTextField();
		cusCarBrand.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		cusCarBrand.setColumns(10);
		cusCarBrand.setBounds(304, 176, 246, 54);
		panel.add(cusCarBrand);
		
		cusCarType = new JTextField();
		cusCarType.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		cusCarType.setColumns(10);
		cusCarType.setBounds(304, 250, 246, 54);
		panel.add(cusCarType);
		
		cusKm = new JTextField();
		cusKm.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		cusKm.setColumns(10);
		cusKm.setBounds(304, 330, 246, 54);
		panel.add(cusKm);
		
		cusZip = new JTextField();
		cusZip.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		cusZip.setColumns(10);
		cusZip.setBounds(304, 405, 246, 54);
		panel.add(cusZip);
		
		cusAddr = new JTextField();
		cusAddr.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		cusAddr.setColumns(10);
		cusAddr.setBounds(304, 479, 365, 54);
		panel.add(cusAddr);
		
		cusTel = new JTextField();
		cusTel.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		cusTel.setColumns(10);
		cusTel.setBounds(304, 561, 365, 54);
		panel.add(cusTel);
		
		cusDate = new JTextField();
		cusDate.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		cusDate.setColumns(10);
		cusDate.setBounds(304, 632, 365, 54);
		panel.add(cusDate);
		
		JLabel lblCusName = new JLabel("고객이름");
		lblCusName.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		lblCusName.setBounds(66, 10, 122, 72);
		panel.add(lblCusName);
		
		JLabel lblCarNum = new JLabel("차 번호");
		lblCarNum.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		lblCarNum.setBounds(66, 86, 122, 72);
		panel.add(lblCarNum);
		
		JLabel lblCarBrand = new JLabel("브랜드");
		lblCarBrand.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		lblCarBrand.setBounds(66, 166, 122, 72);
		panel.add(lblCarBrand);
		
		JLabel lblCarType = new JLabel("차종");
		lblCarType.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		lblCarType.setBounds(66, 240, 122, 72);
		panel.add(lblCarType);
		
		JLabel lblCusKm = new JLabel("주행거리");
		lblCusKm.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		lblCusKm.setBounds(66, 320, 122, 72);
		panel.add(lblCusKm);
		
		JLabel lblCusZip = new JLabel("우편번호");
		lblCusZip.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		lblCusZip.setBounds(66, 395, 122, 72);
		panel.add(lblCusZip);
		
		JLabel lblCusAddr = new JLabel("주소");
		lblCusAddr.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		lblCusAddr.setBounds(76, 469, 122, 72);
		panel.add(lblCusAddr);
		
		lblCusTel = new JLabel("전화번호");
		lblCusTel.setBounds(63, 551, 122, 72);
		panel.add(lblCusTel);
		lblCusTel.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		
		JLabel lblCusDate = new JLabel("가입날짜");
		lblCusDate.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		lblCusDate.setBounds(66, 622, 122, 72);
		panel.add(lblCusDate);
		
		JButton btnBackCusMain = new JButton("돌아가기");
		btnBackCusMain.setBounds(274, 940, 290, 65);
		btnBackCusMain.setFont(new Font("나눔바른고딕", Font.BOLD, 30));
		frame.getContentPane().add(btnBackCusMain);
		
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
		
//		저장 버튼을 눌렀을 때
		btnCusSave.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	MemberMgr mgr = new MemberMgr();
	            	MemberBean bean = new MemberBean();
	            	
	            	bean.setCusName(cusName.getText());
	            	bean.setCusCarNum(cusCarNum.getText());
	            	bean.setCusCarBrand(cusCarBrand.getText());
	            	bean.setCusCarType(cusCarType.getText());
	            	bean.setCusKm (Integer.parseInt(cusKm.getText().toString()));
	            	bean.setCusZip (Integer.parseInt(cusZip.getText().toString()));
	            	bean.setCusAddr(cusAddr.getText());
	            	bean.setCusTel(cusTel.getText());
	            	bean.setCusDate(cusDate.getText());
	            	
	            	mgr.insertCusMgr(bean);
	            	
	            }
	           
	            
	        });
	}
}
