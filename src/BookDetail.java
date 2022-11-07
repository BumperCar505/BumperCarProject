import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class BookDetail extends JFrame {

	private JPanel contentPane;
	private JTextField cusName;
	private JTextField cusCarNum;
	private JTextField cusCarBrand;
	private JTextField cusTel;
	private JTextField cusBookTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookDetail frame = new BookDetail();
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
	public BookDetail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 764);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStatus = new JButton("");
		btnStatus.setBounds(35, 660, Size.BTN_S_W, Size.BTN_S_H);
		contentPane.add(btnStatus);
		
		JButton btnBook = new JButton("");
		btnBook.setBounds(220, 660, 150, 50);
		contentPane.add(btnBook);
		
		JButton btnBookCancel = new JButton("예약 취소");
		btnBookCancel.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		btnBookCancel.setBounds(405, 660, 150, 50);
		contentPane.add(btnBookCancel);
		
		JLabel lblNewLabel = new JLabel("고객명");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		lblNewLabel.setBounds(54, 27, 144, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("차번호");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(54, 127, 144, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("브랜드");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		lblNewLabel_2.setBounds(54, 231, 144, 36);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("전화번호");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		lblNewLabel_3.setBounds(54, 335, 144, 36);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("서비스");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		lblNewLabel_4.setBounds(54, 443, 144, 36);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("예약 시간");
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		lblNewLabel_5.setBounds(54, 543, 144, 36);
		contentPane.add(lblNewLabel_5);
		
		cusName = new JTextField();
		cusName.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		cusName.setBounds(55, 65, 289, 50);
		contentPane.add(cusName);
		cusName.setColumns(10);
		
		cusCarNum = new JTextField();
		cusCarNum.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		cusCarNum.setColumns(10);
		cusCarNum.setBounds(55, 169, 289, 50);
		contentPane.add(cusCarNum);
		
		cusCarBrand = new JTextField();
		cusCarBrand.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		cusCarBrand.setColumns(10);
		cusCarBrand.setBounds(55, 273, 289, 50);
		contentPane.add(cusCarBrand);
		
		cusTel = new JTextField();
		cusTel.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		cusTel.setColumns(10);
		cusTel.setBounds(55, 372, 289, 50);
		contentPane.add(cusTel);
		
		cusBookTime = new JTextField();
		cusBookTime.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		cusBookTime.setColumns(10);
		cusBookTime.setBounds(55, 591, 289, 50);
		contentPane.add(cusBookTime);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(55, 481, 289, 50);
		contentPane.add(comboBox);
	}
}
