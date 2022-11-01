

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.TextField;
import java.awt.event.ActionListener;
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


	private JPanel contentPane;
	private JTextField textField;
	private JTextField techName;
	private JTextField techTel;
	private JTextField techLv;
	private LineBorder LineBorderRegTec1;
//	private LineBorder LineBorderRegTec2;
	private JTable table;
	private JTable listTech;
	private static int n;
	private int flag = 0;
	TextField tf = new TextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegTec frame = new RegTec();
					frame.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public RegTec() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, Size.SCREEN_W, Size.SCREEN_H);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
//		좌측부분 라벨 사용해서 외곽에 선 넣어주기
//		LineBorderRegTec1 = new LineBorder(Color.black, 1, true);
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(958, 93, 545, 545);		
		
		
		
//		우측은 잠시 보류... 막혔다. 할 게 많으니까 좀 있다가 도전 하기로..
//		LineBorderRegTec2 = new LineBorder(Color.black, 1, true);
//		
		
		JPanel panel = new JPanel();
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
		
		
		
//		우측 표 삽입
	

		String header[]= { "정비사 이름", "정비사전화번호", "정비사 직급"};
		String contents[][] = {
				{ "이이이", "010-111-1111", "대리"}
			
		};
		DefaultTableModel model = new DefaultTableModel(contents,header);
		JTable listTech = new JTable(model);
//		JTable listTech = new JTable(new DefaultTableModel(
//			new Object[][] {
//				{"\uC774\uC774\uC774", "010-111-1111", "\uB300\uB9AC"},
//			},
//			new String[] {
//				"\uC815\uBE44\uC0AC \uC774\uB984", "\uC815\uBE44\uC0AC\uC804\uD654\uBC88\uD638", "\uC815\uBE44\uC0AC \uC9C1\uAE09"
//			}
//		) {
//			boolean[] columnEditables = new boolean[] {
//				false, false, false
//			};
//			public boolean isCellEditable(int row, int column) {
//				return columnEditables[column];
//			}
//		});
		
		JScrollPane scrollpane = new JScrollPane(table);
		listTech.setBounds(994, 71, 548, 506);
		contentPane.add(listTech);
		JLabel lblRegTec = new JLabel("");
		lblRegTec.setFont(new Font("나눔바른고딕", Font.BOLD, 15));
		
		lblRegTec.setBorder(LineBorderRegTec1);    //원하는 라벨에 사용
		lblRegTec.setBounds(57, 93, 535, 565);
		contentPane.add(lblRegTec);
		
//		DefaultTableModel tm = new DefaultTableModel(String, Object);
	
		
		
		
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
		
//		혹시나 해서 삭제 버튼(필요할 수도 있으니꺄아아)
		JButton btnTechDel = new JButton("삭제");
		btnTechDel.setBounds(1198, 587, Size.BTN_S_W, Size.BTN_S_H);
		contentPane.add(btnTechDel);
		panel.setLayout(null);
		
		
//		다음버튼
		JButton btnTechNext = new JButton("다음");
		btnTechNext.setBounds(655, 611, 172, 49);
		btnTechNext.setFont(new Font("나눔바른고딕", Font.BOLD, 22));
		contentPane.add(btnTechNext);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(1542, 71, 17, 506);
		contentPane.add(scrollBar);
		
	


	
		
		
//		다른 블로그에서 도전!
//		저장 버튼 누르면 옆에 저장되게
		btnTechReg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputStr[] = new String[3];
				
				inputStr[0] = techName.getText();
				inputStr[1] = techTel.getText();
				inputStr[2] = techLv.getText();
				
				model.addRow(inputStr);
				
//				등록하고 난 뒤 다시 칸 비워주기
				techName.setText("");
				techTel.setText("");
				techLv.setText("");

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

	}
}

