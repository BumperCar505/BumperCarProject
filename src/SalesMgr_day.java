
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

import javax.management.modelmbean.ModelMBean;
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
//            
//    		// Table Font
////            tableSalesD.setFont(font.deriveFont(Font.PLAIN, FONT_SIZE));
//
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
//	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesMgr_day frame = new SalesMgr_day();
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
		
		String header[] = {"Num", "직원명", "고객명", "서비스명", "건수", "총 금액", "내용","금액"};
		String contents[][] = {
				{"1", "김가나", "이나라", "타이어교체", "2건","50000","볼트구입","30000"}

		};

		
		DefaultTableModel model = new DefaultTableModel(contents, header);
		JTable tableSalesD = new JTable(model);
		JScrollPane scrollpane = new JScrollPane(table);
		
		
//		 Text Align Center
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		render.setHorizontalAlignment(SwingConstants.CENTER);
	
	
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
	
			    try {
			    	
//			    	 * 매개변수 : 레이블의 내용, 레이블의 아이콘, 다이얼로그 제목, 다이얼로그 옵션
//			    	 * 반환값1 : -2(비정상적으로 작동했을때 반환하는 값)
//			    	 * 반환값2 : -1(확인 버튼만 있는 다이얼로그 클릭시 반환값, 예 & 아니오 다이얼로그에서 X 버튼 클릭시 반환값)
//			    	 * 반환값3 : 0(예, 아니오 다이얼로그에서 예 클릭시 반환값)
//			    	 * 반환값4 : 1(예, 아니오 다이얼로그에서 아니오 클릭시 반환값)
			    	DialogManager.createMsgDialog("삭제하시겠습니까","\\img\\YellowCat.png", "삭제",JOptionPane.YES_NO_OPTION);
			    	
			    	if(table.getSelectedRow() == -1) {
			    		DialogManager.createMsgDialog("셀을 선택하지 않았습니다.","\\img\\YellowCat.png", "오류",JOptionPane.PLAIN_MESSAGE);
					} 
			    	else if(){
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