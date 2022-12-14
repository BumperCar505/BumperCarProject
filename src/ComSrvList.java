import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.Color;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

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
    		tableSrvList.getTableHeader().setFont(font.deriveFont(Font.BOLD, FONT_SIZE));

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
	
	private void setTableHeader(JTable table) {
		TableColumnModel columnModel = table.getColumnModel();
		String prefix = "<html><body><table><tr><td height=50>";
		String suffix = "</td></tr></table></body><html>";
		
		for (int col = 0; col < columnModel.getColumnCount(); col++) {
		    TableColumn column = columnModel.getColumn(col);
		    String text = prefix + columnModel.getColumn(col).getHeaderValue().toString() + suffix;
		    column.setHeaderValue(text);
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		
		// ???????????? ????????? ?????? ???????????????.
		ArrayList<String> techAllList = new ArrayList<>();
		techAllList.add("?????????1");
		techAllList.add("?????????2");
		techAllList.add("?????????3");
		techAllList.add("?????????4");
		techAllList.add("?????????5");
		techAllList.add("?????????6");
		
		if(obj == btnAddsrv) { // ????????? ?????? ??????
			new ComSrvListSub1(techAllList).setFont();
		} else if(obj == btnEditSrv) { // ?????? ????????? ??????
			int selectedRow = tableSrvList.getSelectedRow();
			
			if(selectedRow == -1) {
				DialogManager.createMsgDialog("????????? ?????? ????????????.", "\\img\\YellowCat.png",
						"??????", JOptionPane.PLAIN_MESSAGE);
				return;
			}
			
			String selectedSrvName = tableSrvList.getValueAt(selectedRow, 1).toString();
			String[] selectedTechNames = tableSrvList.getValueAt(selectedRow, 2).toString().trim().split(", ");
			String selectedSrvPrice = tableSrvList.getValueAt(selectedRow, 3).toString();
			
			ArrayList<String> techList = new ArrayList<>(List.of(selectedTechNames));
			
			new ComSrvListSub1(selectedSrvName, selectedSrvPrice, techAllList, techList).setFont();
		} else if(obj == btnDelSrv) { // ?????? ????????? ??????
			int selectedRow = tableSrvList.getSelectedRow();
			
			if(selectedRow == -1) {
				DialogManager.createMsgDialog("????????? ?????? ????????????.", "\\img\\YellowCat.png",
						"??????", JOptionPane.PLAIN_MESSAGE);
				return;
			}
			
			int result = DialogManager.createMsgDialog("????????? ?????? ??????????", "\\img\\YellowCat.png",
					"??????", JOptionPane.YES_NO_OPTION);
			if(result == 0) {
				DialogManager.createMsgDialog("?????? ???????????????.", "\\img\\YellowCat.png",
						"??????", JOptionPane.PLAIN_MESSAGE);
			} else {
				DialogManager.createMsgDialog("????????? ?????????????????????.", "\\img\\YellowCat.png",
						"??????", JOptionPane.PLAIN_MESSAGE);
			}
		}
	}
	
	/**
	 * Create the frame.
	 */
	public ComSrvList() {
		setTitle("?????????????????? - ????????? ??????");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, Size.SCREEN_W, Size.SCREEN_H);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Num, Service Name, Provide Technician, Service Price
		Object[] columns = {"??????", "????????? ???", "?????? ?????????", "????????? ??????"};
		Object[][] rowNames = {
				{"1", "????????? ??????", "?????????, ?????????", "?????????2"},
				{"2", "???????????? ??????", "?????????, ?????????", "?????????1"},
		};
		
		// Text Align Center
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		render.setHorizontalAlignment(SwingConstants.CENTER);
		
		tableSrvList = new JTable(rowNames, columns);
		tableSrvList.setAutoCreateRowSorter(true);
		tableSrvList.setDefaultEditor(Object.class, null); // ????????? ?????? ?????????
		tableSrvList.getTableHeader().setResizingAllowed(false);
		tableSrvList.getColumn("??????").setCellRenderer(render);
		tableSrvList.getColumn("????????? ???").setCellRenderer(render);
		tableSrvList.getColumn("?????? ?????????").setCellRenderer(render);
		tableSrvList.getColumn("????????? ??????").setCellRenderer(render);
		
		// Column Not Move
		tableSrvList.getTableHeader().setReorderingAllowed(false);
		
		// Column Change Width
		tableSrvList.getColumn("????????? ???").setPreferredWidth(200);
		tableSrvList.getColumn("?????? ?????????").setPreferredWidth(350);
		
		// Row Change Height 
		tableSrvList.setRowHeight(50);
		
		setTableHeader(tableSrvList);
		
		// Table Set Area
		scSrvList = new JScrollPane(tableSrvList);
		scSrvList.setVisible(true);
		scSrvList.setBounds(100, 145, 1462, 750);
		
		contentPane.add(scSrvList);
		
		// Button Create
		btnAddsrv = new JButton("??????");
		btnAddsrv.setBackground(new Color(244, 204, 204));
		btnAddsrv.setBounds(100, 70, Size.BTN_S_W, Size.BTN_S_H);
		btnAddsrv.setBorder(new BevelBorder(BevelBorder.RAISED, Color.red, Color.red, 
				Color.red, Color.red));
		btnAddsrv.addActionListener(this);
		contentPane.add(btnAddsrv);
		
		btnEditSrv = new JButton("??????");
		btnEditSrv.setBackground(new Color(244, 204, 204));
		btnEditSrv.setBounds(275, 70, Size.BTN_S_W, Size.BTN_S_H);
		btnEditSrv.setBorder(new BevelBorder(BevelBorder.RAISED, Color.red, Color.red, 
				Color.red, Color.red));
		btnEditSrv.addActionListener(this);
		contentPane.add(btnEditSrv);
		
		btnDelSrv = new JButton("??????");
		btnDelSrv.setBackground(new Color(244, 204, 204));
		btnDelSrv.setBounds(450, 70, Size.BTN_S_W, Size.BTN_S_H);
		btnDelSrv.setBorder(new BevelBorder(BevelBorder.RAISED, Color.red, Color.red, 
				Color.red, Color.red));
		btnDelSrv.addActionListener(this);
		contentPane.add(btnDelSrv);
		
		btnBackMain = new JButton("????????????");
		btnBackMain.setBackground(new Color(244, 204, 204));
		btnBackMain.setBounds(670, 918, Size.BTN_B_W, Size.BTN_B_H);
		btnBackMain.setBorder(new BevelBorder(BevelBorder.RAISED, Color.red, Color.red, 
				Color.red, Color.red));
		contentPane.add(btnBackMain);
		
		lblYellowCat = new JLabel("");
		lblYellowCat.setIcon(new ImageIcon(ComSrvList.class.getResource("/img/YellowCat.png")));
		lblYellowCat.setBounds(710, 50, 230, 80);
		contentPane.add(lblYellowCat);
	}
}
