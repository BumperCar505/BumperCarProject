import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLDecoder;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

// ComLogin
public class ComLogin extends JFrame implements ActionListener, CaretListener {
	private JPanel contentPane;
	private JTextField comId;
	private JPasswordField comPw;
	private JButton btnComLogin;
	private JButton btnComJoin;

	public void setFont() {
		InputStream inputStream = null;
		
		// Font Setting
		try {
            String classPath = ComLogin.class.getResource("").getPath();
            String path = URLDecoder.decode(classPath, "UTF-8");
            inputStream = new BufferedInputStream(
                    new FileInputStream(path + "/font/NanumBarunGothic.ttf"));
            
            Font font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            
            comPw.setFont(font.deriveFont(Font.BOLD, 24));
            comId.setFont(font.deriveFont(Font.BOLD, 24));
            btnComLogin.setFont(font.deriveFont(Font.BOLD, 24));
            btnComJoin.setFont(font.deriveFont(Font.BOLD, 24));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	if(inputStream != null) {
        		try {
            		inputStream.close();
        		} catch(Exception e2) { 
        			e2.printStackTrace();
        		}
        	}
        }
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComLogin frame = new ComLogin();
					frame.setVisible(true);
					frame.setFont();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		boolean loginFlag = false; // ????????????
		
		if(obj == btnComLogin) {
			if(loginFlag == true) {
				DialogManager.createMsgDialog("???????????? ??????????????????.", "\\img\\YellowCat.png",
						"??????", JOptionPane.PLAIN_MESSAGE);
				// ????????? ?????? ??????
			} else {
				DialogManager.createMsgDialog("???????????? ??????????????????.<br>???????????? ????????? ???????????????.", 
						"\\img\\YellowCat.png", "??????", JOptionPane.PLAIN_MESSAGE);
			}
		}
	}
	
	@Override
	public void caretUpdate(CaretEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		
		if(obj == comId && comId.getText().equals("?????????")) {
			comId.setText("");
		} else if(obj == comPw && String.valueOf(comPw.getPassword()).equals("????????????")) {
			comPw.setText("");
		}
	}
	
	/**
	 * Create the frame.
	 */
	public ComLogin() {
		setTitle("?????????????????? - ?????????");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, Size.SCREEN_W, Size.SCREEN_H);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comId = new JTextField();
		comId.setBounds(638, 333, 404, 66);
		comId.setText("?????????");
		comId.setHorizontalAlignment(SwingConstants.CENTER);
		comId.setColumns(10);
		comId.setBorder(new BevelBorder(BevelBorder.RAISED, Color.red, Color.red, 
				Color.red, Color.red));
		comId.addCaretListener(this);
		contentPane.add(comId);
		
		comPw = new JPasswordField();
		comPw.setBounds(638, 409, 404, 66);
		comPw.setText("????????????");
		comPw.setHorizontalAlignment(SwingConstants.CENTER);
		comPw.setColumns(10);
		comPw.setBorder(new BevelBorder(BevelBorder.RAISED, Color.red, Color.red, 
				Color.red, Color.red));
		comPw.addCaretListener(this);
		contentPane.add(comPw);
		
		btnComLogin = new JButton("?????????");
		btnComLogin.setBounds(638, 530, 404, 71);
		btnComLogin.setForeground(new Color(0, 0, 0));
		btnComLogin.setBackground(new Color(244, 204, 204));
		btnComLogin.setBorder(new BevelBorder(BevelBorder.RAISED, Color.red, Color.red, 
				Color.red, Color.red));
		btnComLogin.addActionListener(this);
		contentPane.add(btnComLogin);
		
		btnComJoin = new JButton("????????????");
		btnComJoin.setBounds(638, 611, 404, 71);
		btnComJoin.setBackground(new Color(244, 204, 204));
		btnComJoin.setBorder(new BevelBorder(BevelBorder.RAISED, Color.red, Color.red, 
				Color.red, Color.red));
		contentPane.add(btnComJoin);
		
		JLabel lblYellowCat = new JLabel("");
		lblYellowCat.setIcon(new ImageIcon(ComLogin.class.getResource("/img/YellowCat.png")));
		lblYellowCat.setBounds(714, 215, 230, 80);
		contentPane.add(lblYellowCat);
	}
}
