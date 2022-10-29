import java.awt.EventQueue;
import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLDecoder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.BevelBorder;

public class ComSrvListSub2 extends JFrame {

	private JPanel contentPane;
	private JLabel lblDelQuestion;
	private JButton btnDelSrvY;
	private JButton btnDelSrvN;
	private final int FONT_SIZE = 20;

	public ComSrvListSub2 setFont() {
		InputStream inputStream = null;
		
		// Font Setting
		try {
            String classPath = ComSrvListSub2.class.getResource("").getPath();
            String path = URLDecoder.decode(classPath, "UTF-8");
            inputStream = new BufferedInputStream(
                    new FileInputStream(path + "/font/NanumBarunGothic.ttf"));

            Font font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            
            lblDelQuestion.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            btnDelSrvY.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            btnDelSrvN.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
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
		
		return this;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComSrvListSub2 frame = new ComSrvListSub2();
					frame.setVisible(true);
					frame.setFont();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ComSrvListSub2() {
		setTitle("서비스 목록 삭제");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblDelQuestion = new JLabel("정말 삭제하시겠습니까?");
		lblDelQuestion.setBounds(120, 72, 200, 50);
		contentPane.add(lblDelQuestion);
		
		btnDelSrvY = new JButton("예");
		btnDelSrvY.setBorder(new BevelBorder(BevelBorder.RAISED, Color.red, Color.red, 
				Color.red, Color.red));
		btnDelSrvY.setBackground(new Color(244, 204, 204));
		btnDelSrvY.setBounds(52, 165, Size.BTN_S_W, Size.BTN_S_H);
		contentPane.add(btnDelSrvY);
		
		btnDelSrvN = new JButton("아니오");
		btnDelSrvN.setBorder(new BevelBorder(BevelBorder.RAISED, Color.red, Color.red, 
				Color.red, Color.red));
		btnDelSrvN.setBackground(new Color(244, 204, 204));
		btnDelSrvN.setBounds(224, 165, Size.BTN_S_W, Size.BTN_S_H);
		contentPane.add(btnDelSrvN);
	}
}
