

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class RegTec extends JFrame {
//	여기에도 삭제, 수정 버튼이 있어야 할 것같다..

	private JPanel contentPane;
	private JTextField textField;
	private JTextField techName;
	private JTextField tecTel;
	private JTextField tecLv;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegTec frame = new RegTec();
					frame.setVisible(true);
//					String header[] = {"정비사 이름","정비사 전화번호","정비사직급"};
//					
//					String contents[][] = {
//							{"백호왕","90","87"},
//							{"왈숙이","100","99"},
//							{"대장장이","30","25"}
//					};
////					
//					DefaultTableModel model = new DefaultTableModel(contents, header);
//					JTable table = new JTable(model);
//					JScrollPane scrollpane = new JScrollPane(table);
					
//					JPanel panel = new JPanel();
//					panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
//					
//					
//					
//					JTextField nameField = new JTextField(5);
//					JTextField sbj1 = new JTextField(3);
//					JTextField sbj2 = new JTextField(3);
////					JTextField sbj3 = new JTextField(3);
//					
//					panel.add(nameField);
//					panel.add(sbj1);
//					panel.add(sbj2);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegTec() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, Size.SCREEN_W, Size.SCREEN_H);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(57, 93, 535, 565);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(949, 139, 684, 745);
		
		JButton btnTechNext = new JButton("다음");
		btnTechNext.setBounds(696, 943, 380, 72);
		btnTechNext.setFont(new Font("나눔바른고딕", Font.PLAIN, 21));
		panel_1.setLayout(null);
		
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
		//
		
		
//		table = new JTable();
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{"a", "a"},
//				{"a", null},
//			},
//			new String[] {
//				"정비사명", "정비사 전화번호"
//			}
//		));
		table.setBounds(934, 109, 574, 537);
		contentPane.add(table);
//		panel.setLayout(null);
		
		
		String header[] = {"정비사 이름","정비사 전화번호","정비사 직급"};
		String contents[][] = {
				{"김지훈","010-222-2222","대리"},
				{"이태하","010-3333-3333","과장"}
		};
		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		
		
		
		
		//
		
		JButton btnTechReg = new JButton("등록");
		btnTechReg.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		btnTechReg.setBounds(247, 631, 182, 77);
		panel.add(btnTechReg);
		
		techName = new JTextField();
		techName.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		techName.setBounds(30, 98, 354, 60);
		panel.add(techName);
		techName.setColumns(10);
		
		tecTel = new JTextField();
		tecTel.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		tecTel.setColumns(10);
		tecTel.setBounds(30, 240, 426, 60);
		panel.add(tecTel);
		
		tecLv = new JTextField();
		tecLv.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		tecLv.setColumns(10);
		tecLv.setBounds(30, 375, 426, 60);
		panel.add(tecLv);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("정비사이름");
		lblNewLabel.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		lblNewLabel.setBounds(30, 46, 175, 42);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("정비사 전화번호");
		lblNewLabel_1.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		lblNewLabel_1.setBounds(30, 188, 189, 42);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("정비사 직급");
		lblNewLabel_2.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		lblNewLabel_2.setBounds(30, 323, 175, 42);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("등록");
		btnNewButton.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(153, 455, 150, 51);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(RegTec.class.getResource("/img/YellowCat.png")));
		lblNewLabel_3.setBounds(655, 22, 357, 146);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("다음");
		btnNewButton_1.setFont(new Font("나눔바른고딕", Font.BOLD, 22));
		btnNewButton_1.setBounds(655, 611, 172, 49);
		contentPane.add(btnNewButton_1);
		
//		Vector<String> tec = new Vector<>();
//		tec.addElement("정비사 이름");
//		tec.addElement("정비사 전화번호");
//		tec.addElement("정비사 직급");
//		

		
	
		
	

	
	}
}
