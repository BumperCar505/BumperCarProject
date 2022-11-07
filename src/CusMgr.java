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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

import com.mysql.cj.xdevapi.Statement;

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
		setTitle("고객관리페이지");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, Size.SCREEN_W, Size.SCREEN_H);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		
		getContentPane = new JPanel();
		getContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(mainPanel);

		setContentPane(getContentPane);
		TextField tf = new TextField();
		
//		addPanel = new JPanel(); 이거 필요없지 않나?? 나중에 보고 삭제하도록 하자.
//		addPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(addPanel);
		
//		addPanel.setLayout(null);
//		new TextField();
//	
		
		// Num, Service Name, Provide Technician, Service Price
//		여기서부터 잠깐 놔둔다.
//		Object[] columns = {"Num", "고객이름", "차번호", "브랜드", "차종", "주행거리","우편번호","주소","전화번호", "가입날짜"};
//		Object[][] rowNames = {
//				{"1", "김땡땡", "63하 2234", "현대","소나타","3000km","11223","부산광역시","010-1111-1111","2022-02-23"}
////				{"2", "엔진오일 교체", "김하하, 조마마", "공임비1"},
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
//		tableCusList.getColumn("고객이름").setCellRenderer(render);
//		tableCusList.getColumn("차번호").setCellRenderer(render);
//		tableCusList.getColumn("브랜드").setCellRenderer(render);
//		tableCusList.getColumn("차종").setCellRenderer(render);
//		tableCusList.getColumn("주행거리").setCellRenderer(render);
//		tableCusList.getColumn("우편번호").setCellRenderer(render);
//		tableCusList.getColumn("주소").setCellRenderer(render);
//		tableCusList.getColumn("전화번호").setCellRenderer(render);
//		tableCusList.getColumn("가입날짜").setCellRenderer(render);
//		
//		// Column Not Move
//		tableCusList.getTableHeader().setReorderingAllowed(false);
//		
//		// Column Change Width
//		tableCusList.getColumn("전화번호").setPreferredWidth(200);
//		tableCusList.getColumn("가입날짜").setPreferredWidth(200);
//		
//		// Row Change Height 
//		tableCusList.setRowHeight(50);
		
		
		
		
//		여기서부터 테이블 수정 부분
		String data[][] = new String [][]{
				{ "1", "김땡땡", "63하2234","현대","소나타","3000km","11223","부산광역시","010-2222-2222","2010-12-30"}};
			
		String header[]= new String[]{ "num", "고객이름", "차번호","브랜드","차종","주행거리","우편번호","주소","전화번호","가입날짜"};
//		Jtable table1 = new Jtable(data,header);

		table.setRowHeight(FONT_SIZE);
		DefaultTableModel model = new DefaultTableModel(data,header);//이것도 잠시 주석
		JTable tableCusList = new JTable(model); //잠시주석
		
		
		
		JScrollPane scrollpane = new JScrollPane(table);
//		tableCusList.setBounds(994, 71, 548, 506);
		getContentPane.add(tableCusList);
		JLabel lblRegTec = new JLabel("");
		lblRegTec.setFont(new Font("나눔바른고딕", Font.BOLD, 20));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// Table Set Area
		scCusList = new JScrollPane(tableCusList);
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
		
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 1666, 1037);
		getContentPane.add(mainPanel);
		mainPanel.setLayout(null);
//		JFrame.getContentPanel().add(addPanel);
	
		//더블클릭했을 때 수정 못하게! 위에 private JTable = table; 추가해야 합니다!
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
//				int result = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?","삭제", JOptionPane.YES_NO_OPTION);
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
		
		//돌아가기 버튼 누르면 메인화면으로 간다.
		btnBackCusMain.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false); 
				new ComMyPage();

			}
		});
		
		
		
//		btnAddCus.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//				new CusMgr_add();
//				
//			}
//		});
		
//		추가부분 누르면 페이지 넘어가게 ok!
		btnAddCus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new CusMgr_add();
				
			}
		});
		
//		삭제 버튼 실행
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
		
		
//		삭제버튼 눌렀을 때
//		btnDelCus.addActionListener(new ActionListener() {				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					if(tableCusList.getSelectedRow() == -1) {
//						DialogManager
//					}
//					
//				
//					int result = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?","삭제", JOptionPane.YES_NO_OPTION);
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
//		btnDelCus.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
////				int index = table.getSelectedRow();
//				
//				if(tableCusList.getSelectedRow() == -1){
//		            JOptionPane.showConfirmDialog(null, "셀을 선택하지 않으셨습니다.", "삭제", JOptionPane.DEFAULT_OPTION);
//		        }
//				
//		        else {
//		        	try {
//		        		int result = DialogManager.createMsgDialog("<html><h3>삭제하시겠습니까?</h3>", "/img/question6.png", "삭제", JOptionPane.YES_NO_OPTION);
//   
//			            if (result == 0) {
//			            	model.removeRow();
//			            	DialogManager.createMsgDialog("<html><h3>삭제되었습니다.</h3>", "/img/success1.png", "삭제", JOptionPane.CLOSED_OPTION);
//			            } else if (result == 1) {
//			            	   
//			            	}
//			            } catch(Exception ex) {
//			            	
//			            }
//		        	}
//				}
//			});
		
		btnDelCus.addActionListener(new ActionListener() {
//				
				@Override
				public void actionPerformed(ActionEvent e) {
					
				   try {
					    int index = tableCusList.getSelectedRow();
					    //만약 열을 선택하지 않았다면 
				    	if(index == -1) {
				    	 DialogManager.createMsgDialog("셀을 선택하지 않았습니다.","\\img\\information5.png", "오류",JOptionPane.PLAIN_MESSAGE);
				    	 return;
						} 
				    	
//				    	열을 선택하였다면
				    	int num = DialogManager.createMsgDialog("삭제하시겠습니까","\\img\\question6.png", "삭제",JOptionPane.YES_NO_OPTION);
				    	if(num==0){
				    		model.removeRow(tableCusList.getSelectedRow());
//				    		model.removeRow(index);
				    		DialogManager.createMsgDialog("삭제 성공하였습니다.","\\img\\success1.png", "완료",JOptionPane.PLAIN_MESSAGE);
				    	}
				    	else if(num==1) {
				    		
				    	}
				   
				    	
			            } catch(Exception ex) {
			            	ex.printStackTrace();
			            }
					
			}; 
		});
	}
		
		
		
		private void getInfo() {
			
			DBConnectionMgr mgr = DBConnectionMgr.getInstance();
			Connection con = null;
			PreparedStatement psmt = null;
			Statement stmt = null;
			ResultSet rs = null;
		
		
		try {
			
		
//			String query = "SELECT * from customer ";
//			con = mgr.getConnection();
//			psmt = con.prepareStatement(query);

			
//			while(rs.next()) {
//				
//				rs = psmt.executeQuery();
//				
//				int cusNum = rs.getInt(1, "cusNum");
//				String cusName = rs.getString(2, "cusName");
//				String cusCarNum= rs.getString(3,"cusCarNum");
//				String cusCarBrand = rs.getString(4,"cusCarBrand");
//				String cusCarType = rs.getString(5,"cusCarType");
//				String cusKm = rs.getInt(6,"cusKm");
//				String cusZip = rs.getString(7,"cusZip");
//				String cusAddr = rs.getString(8,"cusAddr");
//				String cusTel = rs.getString(9,"cusTel");
//				String cusDate = rs.getString(10,"cusDate");
//				
//				
//			}
//			
//		}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			if (rs != null) {rs.close();}
			if (con != null) {rs.close();}
			if (psmt != null) {rs.close();}
		}

	}
}