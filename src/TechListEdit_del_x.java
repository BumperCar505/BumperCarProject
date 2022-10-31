import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class TechListEdit_del_x extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TechListEdit_del_x frame = new TechListEdit_del_x();
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
	public TechListEdit_del_x() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// 삭제하시겠습니까? 폼
		JLabel lblDelForm = new JLabel("삭제하시겠습니까?");
		lblDelForm.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		lblDelForm.setBounds(127, 49, 179, 60);
		contentPane.add(lblDelForm);
		
		// "예"
		JButton btnDelUnitStockY = new JButton("예");
		btnDelUnitStockY.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		btnDelUnitStockY.setBounds(47, 153, 153, 47);
		contentPane.add(btnDelUnitStockY);
		
		// "아니오"
		JButton btnDelUnitStockN = new JButton("아니오");
		btnDelUnitStockN.setFont(new Font("나눔바른고딕", Font.BOLD, 21));
		btnDelUnitStockN.setBounds(236, 153, 153, 47);
		contentPane.add(btnDelUnitStockN);
	}
}
