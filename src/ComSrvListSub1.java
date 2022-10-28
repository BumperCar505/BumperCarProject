import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JButton;

public class ComSrvListSub1 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textFieldSrvName;
	private JTextField textFieldSrvPrice;
	private JLabel lblSrvName;
	private JLabel lblProvideTechnicianList;
	private JLabel lblSrvPrice;
	private JList listProvideTech;
	private JButton btnSrvReg;
	private JButton btnSrvSave;
	private final int FONT_SIZE = 20;
	
	public ComSrvListSub1 setFont() {
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
            btnSrvReg.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            btnSrvSave.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
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
					ComSrvListSub1 frame = new ComSrvListSub1();
					frame.setVisible(true);
					frame.setFont();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// 테스트 코드입니다.
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		
		if(obj == btnSrvReg || obj == btnSrvSave) {
			System.out.println("이벤트 작동함");
		}
	}
	
	/**
	 * Create the frame.
	 */
	public ComSrvListSub1() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 466, 518);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
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
		
		btnSrvReg = new JButton("추가");
		btnSrvReg.setBorder(new BevelBorder(BevelBorder.RAISED, Color.red, Color.red, Color.red, Color.red));
		btnSrvReg.setBackground(new Color(244, 204, 204));
		btnSrvReg.setBounds(150, 408, Size.BTN_S_W, Size.BTN_S_H);
		btnSrvReg.setVisible(false);
		btnSrvReg.addActionListener(this);
		contentPane.add(btnSrvReg);
		
		btnSrvSave = new JButton("저장");
		btnSrvSave.setBorder(new BevelBorder(BevelBorder.RAISED, Color.red, Color.red, Color.red, Color.red));
		btnSrvSave.setBackground(new Color(244, 204, 204));
		btnSrvSave.setBounds(150, 408, Size.BTN_S_W, Size.BTN_S_H);
		btnSrvSave.setVisible(false);
		btnSrvSave.addActionListener(this);
		contentPane.add(btnSrvSave);
	}
	
	// 서비스 목록 창에서 등록을 눌렀을때 이 생성자 호출
	public ComSrvListSub1(String titleName) {
		this();
		this.setTitle(titleName);
		btnSrvReg.setVisible(true);
	}
	
	// 테이블에서 셀 선택후 수정버튼을 클릭했을때 이 생성자 호출
	public ComSrvListSub1(String titleName, String srvName, String srvPrice, List<String> srvTechList) {
		this();
		this.setTitle(titleName);
		lblSrvName.setText(srvName);
		lblSrvPrice.setText(srvPrice);
		String[] list = (String[]) srvTechList.toArray();
		listProvideTech = new JList(list);
	}
}
