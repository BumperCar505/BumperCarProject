import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.Color;

import javax.swing.table.DefaultTableCellRenderer;

// ComServiceList
public class ComSrvList extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JTable tableSrvList;
	private JScrollPane scSrvList;
	private JButton btnAddsrv;
	private JButton btnEditSrv;
	private JButton btnDelSrv;
	private JButton btnBackMain;
	private JLabel lblYellowCat;
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
            
            btnAddsrv.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            btnEditSrv.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            btnDelSrv.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            btnBackMain.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            
    		// Table Font
    		tableSrvList.setFont(font.deriveFont(Font.PLAIN, FONT_SIZE));

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
					ComSrvList frame = new ComSrvList();
					frame.setVisible(true);
					frame.setFont();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
//	@Override
//	public void paint(Graphics g) {
//		Toolkit tool = Toolkit.getDefaultToolkit();
//		Image img = tool.getImage("img/grayCat.png");
//		g.drawImage(img, 770, 50, 305, 153, this);
//		tableSrvList.updateUI();
//		btnAddsrv.updateUI();
//		btnEditSrv.updateUI();
//		btnDelSrv.updateUI();
//	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		
		if(obj == btnAddsrv) {
			new ComSrvListSub1("신규 서비스 등록").setFont();
		} else if(obj == btnEditSrv) {
			ArrayList<String> techList = new ArrayList<>();
			techList.add("정비사1");
			techList.add("정비사2");
			techList.add("정비사3");
			// new ComSrvListSub1("기존 서비스 수정", "테스트 서비스", "테스트 가격", techList).setFont();
		} else if(obj == btnDelSrv) {
			new ComSrvListSub2().setFont();
		}
	}
	
	/**
	 * Create the frame.
	 */
	public ComSrvList() {
		setTitle("다고쳐카센터 - 서비스 목록");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, Size.SCREEN_W, Size.SCREEN_H);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Num, Service Name, Provide Technician, Service Price
		Object[] columns = {"Num", "서비스 명", "제공 정비사", "서비스 가격"};
		Object[][] rowNames = {
				{"1", "타이어 교체", "김하하, 박나나", "공임비2"},
				{"2", "엔진오일 교체", "김하하, 조마마", "공임비1"},
		};
		
		// Text Align Center
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		render.setHorizontalAlignment(SwingConstants.CENTER);
		
		tableSrvList = new JTable(rowNames, columns);
		tableSrvList.getColumn("Num").setCellRenderer(render);
		tableSrvList.getColumn("서비스 명").setCellRenderer(render);
		tableSrvList.getColumn("제공 정비사").setCellRenderer(render);
		tableSrvList.getColumn("서비스 가격").setCellRenderer(render);
		
		// Column Not Move
		tableSrvList.getTableHeader().setReorderingAllowed(false);
		
		// Column Change Width
		tableSrvList.getColumn("서비스 명").setPreferredWidth(200);
		tableSrvList.getColumn("제공 정비사").setPreferredWidth(350);
		
		// Row Change Height 
		tableSrvList.setRowHeight(50);
		
		// Table Set Area
		scSrvList = new JScrollPane(tableSrvList);
		scSrvList.setVisible(true);
		scSrvList.setBounds(100, 145, 1462, 750);
		
		contentPane.add(scSrvList);
		
		// Button Create
		btnAddsrv = new JButton("추가");
		btnAddsrv.setBackground(new Color(244, 204, 204));
		btnAddsrv.setBounds(100, 70, Size.BTN_S_W, Size.BTN_S_H);
		btnAddsrv.setBorder(new BevelBorder(BevelBorder.RAISED, Color.red, Color.red, 
				Color.red, Color.red));
		btnAddsrv.addActionListener(this);
		contentPane.add(btnAddsrv);
		
		btnEditSrv = new JButton("수정");
		btnEditSrv.setBackground(new Color(244, 204, 204));
		btnEditSrv.setBounds(275, 70, Size.BTN_S_W, Size.BTN_S_H);
		btnEditSrv.setBorder(new BevelBorder(BevelBorder.RAISED, Color.red, Color.red, 
				Color.red, Color.red));
		btnEditSrv.addActionListener(this);
		contentPane.add(btnEditSrv);
		
		btnDelSrv = new JButton("삭제");
		btnDelSrv.setBackground(new Color(244, 204, 204));
		btnDelSrv.setBounds(450, 70, Size.BTN_S_W, Size.BTN_S_H);
		btnDelSrv.setBorder(new BevelBorder(BevelBorder.RAISED, Color.red, Color.red, 
				Color.red, Color.red));
		btnDelSrv.addActionListener(this);
		contentPane.add(btnDelSrv);
		
		btnBackMain = new JButton("돌아가기");
		btnBackMain.setBackground(new Color(244, 204, 204));
		btnBackMain.setBounds(690, 918, Size.BTN_B_W, Size.BTN_B_H);
		btnBackMain.setBorder(new BevelBorder(BevelBorder.RAISED, Color.red, Color.red, 
				Color.red, Color.red));
		contentPane.add(btnBackMain);
		
		lblYellowCat = new JLabel("");
		lblYellowCat.setIcon(new ImageIcon(ComSrvList.class.getResource("/img/YellowCat.png")));
		lblYellowCat.setBounds(710, 50, 230, 80);
		contentPane.add(lblYellowCat);
	}
}
