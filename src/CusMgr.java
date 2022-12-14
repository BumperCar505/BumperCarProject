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
import javax.swing.table.DefaultTableModel;

// ComServiceList
public class CusMgr extends JFrame {
	private JTable table;
	private JPanel getContentPane;
	private JPanel addPanel;
	private JTable tableCusList;
	private JScrollPane scCusList;
	private JButton btnAddCus;
	private JButton btnEditCus;
	private JButton btnDelCus;
	private JButton btnBackCusMain;
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
            
            btnAddCus.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            btnEditCus.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            btnDelCus.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            btnBackCusMain.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            
//    		// Table Font
//            tableCusList.setFont(font.deriveFont(Font.PLAIN, FONT_SIZE));

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
//				        int result = JOptionPane.showConfirmDialog(jFrame, "????????????????????????");
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

	/**
	 * Create the frame.
	 */
	
	
	
	
	public CusMgr() {
		setVisible(true);
		setTitle("?????????????????????");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, Size.SCREEN_W, Size.SCREEN_H);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		
		getContentPane = new JPanel();
		getContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(getContentPane);
		TextField tf = new TextField();
		
//		addPanel = new JPanel(); ?????? ???????????? ???????? ????????? ?????? ??????????????? ??????.
//		addPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(addPanel);
		
//		addPanel.setLayout(null);
//		new TextField();
//	
		
		// Num, Service Name, Provide Technician, Service Price
//		??????????????? ?????? ?????????.
//		Object[] columns = {"Num", "????????????", "?????????", "?????????", "??????", "????????????","????????????","??????","????????????", "????????????"};
//		Object[][] rowNames = {
//				{"1", "?????????", "63??? 2234", "??????","?????????","3000km","11223","???????????????","010-1111-1111","2022-02-23"}
////				{"2", "???????????? ??????", "?????????, ?????????", "?????????1"},
//		};
//		
//		// Text Align Center
//		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
//		render.setHorizontalAlignment(SwingConstants.CENTER);
//		
//		tableCusList = new JTable(rowNames, columns);
//		tableCusList.setModel(new DefaultTableModel(
//			new Object[][] {
//				{"1", "\uAE40\uB561\uB561", "63\uD558 2234", "\uD604\uB300", "\uC18C\uB098\uD0C0", "3000km", "11223", "\uBD80\uC0B0\uAD11\uC5ED\uC2DC", "010-1111-1111", "2022-02-23"},
//			},
//			new String[] {
//				"Num", "\uACE0\uAC1D\uC774\uB984", "\uCC28\uBC88\uD638", "\uBE0C\uB79C\uB4DC", "\uCC28\uC885", "\uC8FC\uD589\uAC70\uB9AC", "\uC6B0\uD3B8\uBC88\uD638", "\uC8FC\uC18C", "\uC804\uD654\uBC88\uD638", "\uAC00\uC785\uB0A0\uC9DC"
//			}
//		) {
//			boolean[] columnEditables = new boolean[] {
//				false, false, false, false, false, false, false, false, false, false
//			};
//			public boolean isCellEditable(int row, int column) {
//				return columnEditables[column];
//			}
//		});
//		tableCusList.getColumn("Num").setCellRenderer(render);
//		tableCusList.getColumn("????????????").setCellRenderer(render);
//		tableCusList.getColumn("?????????").setCellRenderer(render);
//		tableCusList.getColumn("?????????").setCellRenderer(render);
//		tableCusList.getColumn("??????").setCellRenderer(render);
//		tableCusList.getColumn("????????????").setCellRenderer(render);
//		tableCusList.getColumn("????????????").setCellRenderer(render);
//		tableCusList.getColumn("??????").setCellRenderer(render);
//		tableCusList.getColumn("????????????").setCellRenderer(render);
//		tableCusList.getColumn("????????????").setCellRenderer(render);
//		
//		// Column Not Move
//		tableCusList.getTableHeader().setReorderingAllowed(false);
//		
//		// Column Change Width
//		tableCusList.getColumn("????????????").setPreferredWidth(200);
//		tableCusList.getColumn("????????????").setPreferredWidth(200);
//		
//		// Row Change Height 
//		tableCusList.setRowHeight(50);
		
		
		
		
//		??????????????? ????????? ?????? ??????
		String header[]= { "num", "????????????", "?????????","?????????","??????","????????????","????????????","??????","????????????","????????????"};
		String contents[][] = {
				{ "1", "?????????", "63???2234","??????","?????????","3000km","11223","???????????????","010-2222-2222","2010-12-30"}
			
		};
		DefaultTableModel model = new DefaultTableModel(contents,header);
		JTable tableCusList = new JTable(model);
		JScrollPane scrollpane = new JScrollPane(table);
//		tableCusList.setBounds(994, 71, 548, 506);
		getContentPane.add(tableCusList);
		JLabel lblRegTec = new JLabel("");
		lblRegTec.setFont(new Font("??????????????????", Font.BOLD, 20));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// Table Set Area
		scCusList = new JScrollPane(tableCusList);
		scCusList.setBounds(100, 145, 1462, 750);
		scCusList.setVisible(true);
		getContentPane.setLayout(null);
		
		getContentPane.add(scCusList);
		
		// Button Create
		btnAddCus = new JButton("??????");
		btnAddCus.setBounds(100, 70, 150, 50);

		getContentPane.add(btnAddCus);
		
		btnEditCus = new JButton("??????");
		btnEditCus.setBounds(275, 70, 150, 50);
		getContentPane.add(btnEditCus);
		
		btnDelCus = new JButton("??????");
		btnDelCus.setBounds(450, 70, 150, 50);
		getContentPane.add(btnDelCus);
		
		btnBackCusMain = new JButton("????????????");
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
	
		//?????????????????? ??? ?????? ?????????! ?????? private JTable = table; ???????????? ?????????!
//		DefaultTableModel tableModel = new DefaultTableModel() {
//
//		    @Override
//		    public boolean isCellEditable(int row, int column) {
//		       //all cells false
//		       return false;
//		    }
//		};
//
//		table.setModel(tableModel);
		
		//instance table model
//		DefaultTableModel tableModel = new DefaultTableModel() {
//
//		   @Override
//		   public boolean isCellEditable(int row, int column) {
//		       //Only the third column
//		       return column == 3;
//		   }
//		};
//
//		table.setModel(tableModel);
		
	
//		btnDelCus.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				int result = JOptionPane.showConfirmDialog(null, "?????????????????????????","??????", JOptionPane.YES_NO_OPTION);
//				
//				if(result == JOptionPane.CLOSED_OPTION)
//					tf.setText("Just Closed");
//				else if(result == JOptionPane.YES_OPTION)
////					tf.setText("Y");
//					System.out.println("Y");
//				else
////					tf.setText("N");
//					System.out.println("N");
//			}
//		}); 
		
		//???????????? ?????? ????????? ?????????????????? ??????.
		btnBackCusMain.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false); 
				new ComMyPage();

			}
		});
		
		
		//??????.. ?????? ??? ?????????...
//		btnAddCus.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//				new CusMgr_add();
//				
//			}
//		});
		
//		???????????? ????????? ????????? ???????????? ok!
		btnAddCus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new CusMgr_add();
				
			}
		});
		
//		?????? ?????? ??????
//		btnTechDel.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if(listTech.getSelectedRow() == -1) {
//					return;
//				}
//				else {
//					model.removeRow(listTech.getSelectedRow());
//				}
//			}
//		});
//		btnDelCus.addActionListener(new ActionListener() {				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					int result = JOptionPane.showConfirmDialog(null, "?????????????????????????","??????", JOptionPane.YES_NO_OPTION);
//					
//					if(result == JOptionPane.CLOSED_OPTION)
//						tf.setText("Just Closed");
//					else if(result == JOptionPane.YES_OPTION) {
//						
//						if(tableCusList.getSelectedRow() == -1) {
//							return;
//					}
//						
//				}
//					else {
////						tf.setText("N");
//						System.out.println("N");
//						model.removeRow(tableCusList.getSelectedRow());
//				}
//				}
//			}); 
		
			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if(tableCusList.getSelectedRow() == -1) {
//					return;
//				}
//				else {
//					model.removeRow(tableCusList.getSelectedRow());
//				}
//			}
//		});
		
		
		
		
		
			
		
			
			
	}
}