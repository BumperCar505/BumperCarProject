
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLDecoder;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.Color;

import javax.swing.table.DefaultTableCellRenderer;

// ComServiceList
public class SalesMgr_day extends JFrame {
	private JPanel getContentPane;
	private JPanel addPanel;
	private JTable tableSalesD;
	private JScrollPane scCusList;
	private JButton btnAddSalesD;
	private JButton btnEditSalesD;
	private JButton btnDelSalesD;
	private JButton btnBackSales;
	private JLabel lblYellowCat;
	private final int FONT_SIZE = 21;
	private JPanel mainPanel;
	
	public void setFont() {
		InputStream inputStream = null;
		
		// Font Setting
		try {
            String classPath = CusMgr.class.getResource("").getPath();
            String path = URLDecoder.decode(classPath, "UTF-8");
            inputStream = new BufferedInputStream(
                    new FileInputStream(path + "/font/NanumBarunGothic.ttf"));

            Font font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            
            btnAddSalesD.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            btnEditSalesD.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            btnDelSalesD.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            btnBackSales.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            
    		// Table Font
            tableSalesD.setFont(font.deriveFont(Font.PLAIN, FONT_SIZE));

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
					CusMgr frame = new CusMgr();
//					frame.setVisible(true);
					frame.setFont();
//					 JFrame jFrame = new JFrame();
//				        int result = JOptionPane.showConfirmDialog(jFrame, "삭제하시겠습니까");
//
//				        if (result == 0)
//				            System.out.println("Yes");
//				        else 
//				            System.out.println("NO");
					
					
				       
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	


	/**
	 * Create the frame.
	 */
	
	
	
	
	public SalesMgr_day() {
		setVisible(true);
		setTitle("일일 매출관리페이지");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, Size.SCREEN_W, Size.SCREEN_H);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		getContentPane = new JPanel();
		getContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(getContentPane);
		TextField tf = new TextField();
		
		addPanel = new JPanel();
//		addPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(addPanel);
		
//		addPanel.setLayout(null);
//		new TextField();
//	
		
		// Num, Service Name, Provide Technician, Service Price
		Object[] columns = {"Num", "직원명", "고객명", "서비스명", "건수", "총 금액", "내용","금액"};
		Object[][] rowNames = {
				{"1", "김가나", "이나라", "타이어교체", "2건","50000","볼트구입","30000"}
//				{"2", "엔진오일 교체", "김하하, 조마마", "공임비1"},
		};
		
		// Text Align Center
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		render.setHorizontalAlignment(SwingConstants.CENTER);
		
		tableSalesD = new JTable(rowNames, columns);
		tableSalesD.setFont(new Font("나눔바른고딕", Font.PLAIN, 20));
		tableSalesD.getColumn("Num").setCellRenderer(render);
		tableSalesD.getColumn("직원명").setCellRenderer(render);
		tableSalesD.getColumn("고객명").setCellRenderer(render);
		tableSalesD.getColumn("서비스명").setCellRenderer(render);
		tableSalesD.getColumn("건수").setCellRenderer(render);
		tableSalesD.getColumn("총 금액").setCellRenderer(render);
		tableSalesD.getColumn("내용").setCellRenderer(render);
		tableSalesD.getColumn("금액").setCellRenderer(render);
//		tableCusList.getColumn("주소").setCellRenderer(render);
//		tableCusList.getColumn("전화번호").setCellRenderer(render);
//		tableCusList.getColumn("가입날짜").setCellRenderer(render);
		
		// Column Not Move
		tableSalesD.getTableHeader().setReorderingAllowed(false);
		
		// Column Change Width
		tableSalesD.getColumn("전화번호").setPreferredWidth(200);
		tableSalesD.getColumn("가입날짜").setPreferredWidth(200);
		
		// Row Change Height 
		tableSalesD.setRowHeight(50);
		
		// Table Set Area
		scCusList = new JScrollPane(tableSalesD);
		scCusList.setBounds(100, 145, 1462, 750);
		scCusList.setVisible(true);
		getContentPane.setLayout(null);
		
		getContentPane.add(scCusList);
		
		// Button Create
		btnAddCus = new JButton("추가");
		btnAddCus.setBounds(100, 70, 150, 50);

		getContentPane.add(btnAddCus);
		
		btnEditCus = new JButton("수정");
		btnEditCus.setBounds(275, 70, 150, 50);
		getContentPane.add(btnEditCus);
		
		btnDelCus = new JButton("삭제");
		btnDelCus.setBounds(450, 70, 150, 50);
		getContentPane.add(btnDelCus);
		
		btnBackCusMain = new JButton("돌아가기");
		btnBackCusMain.setBounds(690, 918, 290, 65);
		getContentPane.add(btnBackCusMain);
		
		lblYellowCat = new JLabel("");
		lblYellowCat.setBounds(710, 50, 230, 80);
		lblYellowCat.setIcon(new ImageIcon(CusMgr.class.getResource("/img/YellowCat.png")));
		getContentPane.add(lblYellowCat);
		
		JPanel addPanel = new JPanel();
		addPanel.setBounds(22, 75, 10, 10);
		getContentPane.add(addPanel);
		
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 10, 1666, 1027);
		getContentPane.add(mainPanel);
		mainPanel.setLayout(null);
//		JFrame.getContentPanel().add(addPanel);
		
		
		//팝업창으로 삭제버튼 넣기. 받은 값으로 삭제 여부 결정 가능해 보임.
//		이겁니다 여러분!!!!! 이거 복사해가세요!!
		btnDelCus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?","삭제", JOptionPane.YES_NO_OPTION);
				
				if(result == JOptionPane.CLOSED_OPTION)
					tf.setText("Just Closed");
				else if(result == JOptionPane.YES_OPTION)
//					tf.setText("Y");
					System.out.println("Y");
				else
//					tf.setText("N");
					System.out.println("N");
			}
		}); 
		
		
		btnBackCusMain.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false); 
				new Main();

			}
		});
		
		btnAddCus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
//				new 
				
			}
		});
			
			
	}
}