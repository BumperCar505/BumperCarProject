import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLDecoder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JButton;

public class ComSrvListSub1 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSrvName;
	private JTextField textFieldSrvPrice;
	private JLabel lblSrvName;
	private JLabel lblProvideTechnicianList;
	private JLabel lblSrvPrice;
	private JList listProvideTech;
	private JButton btnSrvReg; // 등록
	private JButton btnSrvSave; // 저장
	private final int FONT_SIZE = 20;
	
	public void setFont() {
		InputStream inputStream = null;
		
		// Font Setting
		try {
            String classPath = ComSrvListSub1.class.getResource("").getPath();
            String path = URLDecoder.decode(classPath, "UTF-8");
            inputStream = new BufferedInputStream(
                    new FileInputStream(path + "/font/NanumBarunGothic.ttf"));

            Font font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            
            textFieldSrvName.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            textFieldSrvPrice.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            lblSrvName.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            lblProvideTechnicianList.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            lblSrvPrice.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            listProvideTech.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
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
					ComSrvListSub1 frame = new ComSrvListSub1();
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
	public ComSrvListSub1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 518);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblSrvName = new JLabel("서비스 명");
		lblSrvName.setBounds(40, 18, 100, 40);
		contentPane.add(lblSrvName);
		
		lblProvideTechnicianList = new JLabel("제공된 정비사 목록");
		lblProvideTechnicianList.setBounds(40, 88, 200, 40);
		contentPane.add(lblProvideTechnicianList);
		
		lblSrvPrice = new JLabel("서비스 가격");
		lblSrvPrice.setBounds(40, 337, 100, 40);
		contentPane.add(lblSrvPrice);
		
		textFieldSrvName = new JTextField();
		textFieldSrvName.setBounds(208, 17, 200, 40);
		textFieldSrvName.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSrvName.setColumns(10);
		contentPane.add(textFieldSrvName);
		
		String[] tempDatas = new String[] {"홍길동", "박나나"};
		listProvideTech = new JList(tempDatas);
		listProvideTech.setBounds(207, 97, 200, 200);
		listProvideTech.setVisible(true);
		contentPane.add(listProvideTech);
		
		textFieldSrvPrice = new JTextField();
		textFieldSrvPrice.setColumns(10);
		textFieldSrvPrice.setBounds(208, 337, 200, 40);
		textFieldSrvPrice.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(textFieldSrvPrice);
	}
}
