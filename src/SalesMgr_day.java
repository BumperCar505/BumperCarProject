
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
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import java.awt.Color;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;

// ComServiceList
public class SalesMgr_day extends JFrame {
	private JPanel getContentPane;
	private JTable tableSalesD;
	private JTable table;
	private JScrollPane scSalesDList;
	private JButton btnAddSalesD;
	private JButton btnEditSalesD;
	private JButton btnDelSalesD;
	private JButton btnBackSales;
	private JLabel lblYellowCat;
	private final int FONT_SIZE = 21;
	
	public void setFont() {
		InputStream inputStream = null;
		
		// Font Setting
		try {
            String classPath = SalesMgr_day.class.getResource("").getPath();
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
					SalesMgr_day frame = new SalesMgr_day();
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
		
		
		

		Object[] columns = {"Num", "직원명", "고객명", "서비스명", "건수", "총 금액", "내용","금액"};
		Object[][] rowNames = {
				{"1", "김가나", "이나라", "타이어교체", "2건","50000","볼트구입","30000"}

		};
//		DefaultTableModel model = new DefaultTableModel(columns, rowNames);
//		JTable table = new Jtable(model);
//		JScrollPane scrollpane = new JScrollPane(table);
		
//		 Text Align Center
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		render.setHorizontalAlignment(SwingConstants.CENTER);
		
//		tableSalesD = new JTable(rowNames, columns);
//		tableSalesD.setModel(new DefaultTableModel(
//			new Object[][] {
//				{"1", "\uAE40\uAC00\uB098", "\uC774\uB098\uB77C", "\uD0C0\uC774\uC5B4\uAD50\uCCB4", "2\uAC74", "50000", "\uBCFC\uD2B8\uAD6C\uC785", "30000"},
//			},
//			new String[] {
//				"Num", "\uC9C1\uC6D0\uBA85", "\uACE0\uAC1D\uBA85", "\uC11C\uBE44\uC2A4\uBA85", "\uAC74\uC218", "\uCD1D \uAE08\uC561", "\uB0B4\uC6A9", "\uAE08\uC561"
//			}
//		) {
//			boolean[] columnEditables = new boolean[] {
//				false, false, false, false, false, false, false, false
//			};
//			public boolean isCellEditable(int row, int column) {
//				return columnEditables[column];
//			}
//		});
//		tableSalesD.setFont(new Font("나눔바른고딕", Font.PLAIN, 20));
//		tableSalesD.getColumn("Num").setCellRenderer(render);
//		tableSalesD.getColumn("직원명").setCellRenderer(render);
//		tableSalesD.getColumn("고객명").setCellRenderer(render);
//		tableSalesD.getColumn("서비스명").setCellRenderer(render);
//		tableSalesD.getColumn("건수").setCellRenderer(render);
//		tableSalesD.getColumn("총 금액").setCellRenderer(render);
//		tableSalesD.getColumn("내용").setCellRenderer(render);
//		tableSalesD.getColumn("금액").setCellRenderer(render);

//		
//		
//		// Column Not Move
//		tableSalesD.getTableHeader().setReorderingAllowed(false);
		
		
		
		
		
		
		// Column Change Width
//		tableSalesD.getColumn("전화번호").setPreferredWidth(200);
//		tableSalesD.getColumn("가입날짜").setPreferredWidth(200);
		
		// Row Change Height 
		tableSalesD.setRowHeight(50);
		
		// Table Set Area
		scSalesDList = new JScrollPane(tableSalesD);
		scSalesDList.setBounds(100, 145, 1462, 462);
		scSalesDList.setVisible(true);
		getContentPane.setLayout(null);
		
		getContentPane.add(scSalesDList);
		
		// 버튼모음
		btnAddSalesD = new JButton("추가");
		btnAddSalesD.setBounds(100, 70, Size.BTN_S_W, Size.BTN_S_H);
		getContentPane.add(btnAddSalesD);
		
		btnEditSalesD = new JButton("수정");
		btnEditSalesD.setBounds(275, 70, Size.BTN_S_W, Size.BTN_S_H);
		getContentPane.add(btnEditSalesD);
		
		btnDelSalesD = new JButton("삭제");
		btnDelSalesD.setBounds(450, 70, Size.BTN_S_W, Size.BTN_S_H);
		getContentPane.add(btnDelSalesD);
		
		btnBackSales = new JButton("돌아가기");
		btnBackSales.setBounds(648, 635, Size.BTN_B_W, Size.BTN_B_H);
		getContentPane.add(btnBackSales);
		
		lblYellowCat = new JLabel("");
		lblYellowCat.setBounds(710, 50, 230, 80);
		lblYellowCat.setIcon(new ImageIcon(CusMgr.class.getResource("/img/YellowCat.png")));
		getContentPane.add(lblYellowCat);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(1558, 145, 17, 463);
		getContentPane.add(scrollBar);
//		JFrame.getContentPanel().add(addPanel);
		
		
	
		   btnDelSalesD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				과정...
//				int result = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?","삭제", JOptionPane.YES_NO_OPTION);
//				Font f1 = new Font("맑은 고딕", Font.PLAIN, 24); 
//				UIManager.put("result.messageFont", f1);
//				UIManager.put("result.buttonFont", f1);

//				은비언니가 찾아준 알림창 중앙배열
//				String message = "<html><body><div width='100px' align='center'>삭제하시겠습니까</div></body></html>";
//				JLabel messageLabel = new JLabel(message);
//				JOptionPane.showConfirmDialog(null, messageLabel, "삭제", JOptionPane.PLAIN_MESSAGE);
//				
			    try {
		               JLabel label = new JLabel("<html><center><br>XXX님 환영합니다.");
		               String classPath = SalesMgr_day.class.getResource("").getPath();
		                  String path = URLDecoder.decode(classPath, "UTF-8");
		                  path += "\\img\\YellowCat.png";
		                  ImageIcon icon = new ImageIcon(path);
		               label.setIcon(icon);
		               label.setHorizontalAlignment(SwingConstants.CENTER);
		               int answer = JOptionPane.showConfirmDialog(null, label, "title",//라벨에 이미지와 글을 넣음.
		               JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
		               
		               if(answer ==JOptionPane.YES_OPTION) {
		            	   model.removeRow(table.getSelectedRow());
		               }
		            } catch(Exception ex) {
		               
		            }
				
			}
		}); 
		
		
		btnBackSales.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false); 
				new SalesMgr();

			}
		});
		
		btnAddSalesD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

				
			}
		});
			
			
	}
}