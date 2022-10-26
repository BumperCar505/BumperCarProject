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
import javax.swing.JTextField;
import javax.swing.JList;

public class ComSrvListSub1 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSrvName;
	private JTextField textFieldSrvPrice;
	private JLabel lblSrvName;
	private JLabel lblProvideTechnicianList;
	private JLabel lblSrvPrice;
	private JList listProvideTechnician;
	private final int FONT_SIZE = 21;
	
	public void setFont() {
		InputStream inputStream = null;
		
		// Font Setting
		try {
            String classPath = ComSrvList.class.getResource("").getPath();
            String path = URLDecoder.decode(classPath, "UTF-8");
            inputStream = new BufferedInputStream(
                    new FileInputStream(path + "/font/NanumBarunGothic.ttf"));

            Font font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            
            textFieldSrvName.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            textFieldSrvPrice.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            lblSrvName.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            lblProvideTechnicianList.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            lblSrvPrice.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            listProvideTechnician.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
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
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblSrvName = new JLabel("서비스 명");
		lblSrvName.setBounds(102, 49, 57, 15);
		contentPane.add(lblSrvName);
		
		lblProvideTechnicianList = new JLabel("제공된 정비사 목록");
		lblProvideTechnicianList.setBounds(102, 135, 57, 15);
		contentPane.add(lblProvideTechnicianList);
		
		lblSrvPrice = new JLabel("서비스 가격");
		lblSrvPrice.setBounds(102, 374, 57, 15);
		contentPane.add(lblSrvPrice);
		
		textFieldSrvName = new JTextField();
		textFieldSrvName.setBounds(268, 46, 116, 21);
		contentPane.add(textFieldSrvName);
		textFieldSrvName.setColumns(10);
		
		listProvideTechnician = new JList();
		listProvideTechnician.setBounds(284, 259, 166, -134);
		contentPane.add(listProvideTechnician);
		
		textFieldSrvPrice = new JTextField();
		textFieldSrvPrice.setColumns(10);
		textFieldSrvPrice.setBounds(268, 371, 116, 21);
		contentPane.add(textFieldSrvPrice);
	}
}
