import java.awt.Color;
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
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

// CommentManage
public class ComManageComment extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable tableCommentList;
	private JScrollPane scCommentList;
	private JLabel lblYellowCat;
	private JLabel lblScore;
	private JLabel lblEndDate;
	private JLabel lblStartDate;
	private JButton btnBackCommentMain;
	private JButton btnHideComment;
	private JButton btnSearchComment;
	private final int FONT_SIZE = 21;
	
	public ComManageComment setFont() {
		InputStream inputStream = null;
		
		// Font Setting
		try {
            String classPath = ComManageComment.class.getResource("").getPath();
            String path = URLDecoder.decode(classPath, "UTF-8");
            inputStream = new BufferedInputStream(
                    new FileInputStream(path + "/font/NanumBarunGothic.ttf"));

            Font font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            
            lblScore.setFont(font.deriveFont(Font.PLAIN, FONT_SIZE));
            lblScore.setFont(font.deriveFont(Font.PLAIN, FONT_SIZE));
            lblEndDate.setFont(font.deriveFont(Font.PLAIN, FONT_SIZE));
            lblStartDate.setFont(font.deriveFont(Font.PLAIN, FONT_SIZE));
            btnHideComment.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            btnBackCommentMain.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            btnSearchComment.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
    		// Table Font	
            tableCommentList.setFont(font.deriveFont(Font.PLAIN, FONT_SIZE));
            tableCommentList.getTableHeader().setFont(font.deriveFont(Font.BOLD, FONT_SIZE));

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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		
		if(obj == btnHideComment) {
			int[] selectedRows = tableCommentList.getSelectedRows();
			
			if(selectedRows.length == 0) {
				DialogManager.createMsgDialog("????????? ?????? ????????????.", "\\img\\YellowCat.png",
						"??????", JOptionPane.PLAIN_MESSAGE);
				return;
			}
			
			int result = DialogManager.createMsgDialog("????????? ????????? ????????? ?????????????", "\\img\\YellowCat.png",
					"??????", JOptionPane.YES_NO_OPTION);
			if(result == 0) {
				DialogManager.createMsgDialog("??????????????? ?????????????????????.", "\\img\\YellowCat.png",
						"??????", JOptionPane.PLAIN_MESSAGE);
			} else {
				DialogManager.createMsgDialog("????????? ?????????????????????.", "\\img\\YellowCat.png",
						"??????", JOptionPane.PLAIN_MESSAGE);
			}
		} else if(obj == btnSearchComment) {
			boolean tempFlag = true; // ????????? ???
			
			if(tempFlag == true) {
				DialogManager.createMsgDialog("?????? ???????????? ?????? ???????????????<br> ??????????????? ??????????????????.", "\\img\\YellowCat.png",
						"??????", JOptionPane.PLAIN_MESSAGE);
			}
			
			DialogManager.createMsgDialog("????????? ?????????????????????.", "\\img\\YellowCat.png",
					"??????", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComManageComment frame = new ComManageComment();
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
	public ComManageComment() {
		setTitle("?????????????????? - ???????????????");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, Size.SCREEN_W, Size.SCREEN_H);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null); // ?????? ????????? ??????????????? ???????????? ???????????????..
		
		// ?????? ????????? ????????????????????? ?????? DB?????? ???????????????
		Object[] columns = {"??????", "?????????", "????????????", "???????????????", "??????", "?????????"};
		Object[][] rowNames = {
				{"1", "?????????", "2022-02-11", "???????????????", "?????????", "??????????????? ????????? ?????? ????????????"},
				{"2", "?????????", "2022-02-13", "??????????????????", "???????????????", "??????????????? ????????? ??? ????????????..."
						+ "????????? ?????????~^^"}
		};
		
		// Text Align Center
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		render.setHorizontalAlignment(SwingConstants.CENTER);
		
		tableCommentList = new JTable(rowNames, columns);
		tableCommentList.setAutoCreateRowSorter(true);
		tableCommentList.setDefaultEditor(Object.class, null); // ????????? ??? ?????? ?????????
		tableCommentList.getTableHeader().setResizingAllowed(false);
		tableCommentList.getColumn("??????").setCellRenderer(render);
		tableCommentList.getColumn("?????????").setCellRenderer(render);
		tableCommentList.getColumn("????????????").setCellRenderer(render);
		tableCommentList.getColumn("???????????????").setCellRenderer(render);
		tableCommentList.getColumn("??????").setCellRenderer(render);
		tableCommentList.getColumn("?????????").setCellRenderer(render);
		
		// Column Not Move
		tableCommentList.getTableHeader().setReorderingAllowed(false);
		
		// Column Change Width
		tableCommentList.getColumn("???????????????").setPreferredWidth(200);
		tableCommentList.getColumn("?????????").setPreferredWidth(500);
		
		// Change Row Height 
		tableCommentList.setRowHeight(50);
		
		// Set Row Header
		setTableHeader(tableCommentList);
		
		// Table Set Area
		scCommentList = new JScrollPane(tableCommentList);
		scCommentList.setVisible(true);
		scCommentList.setBounds(100, 145, 1462, 750);
		
		contentPane.add(scCommentList);
		
		lblYellowCat = new JLabel("");
		lblYellowCat.setIcon(new ImageIcon(ComManageComment.class.getResource("/img/YellowCat.png")));
		lblYellowCat.setBounds(710, 50, 230, 80);
		contentPane.add(lblYellowCat);
		
		btnBackCommentMain = new JButton("????????????");
		btnBackCommentMain.setBackground(new Color(244, 204, 204));
		btnBackCommentMain.setBounds(670, 918, Size.BTN_B_W, Size.BTN_B_H);
		btnBackCommentMain.setBorder(new BevelBorder(BevelBorder.RAISED, Color.red, Color.red, 
				Color.red, Color.red));
		contentPane.add(btnBackCommentMain);
		
		btnHideComment = new JButton("?????? ?????????");
		btnHideComment.setBackground(new Color(244, 204, 204));
		btnHideComment.setBounds(100, 70, Size.BTN_S_W, Size.BTN_S_H);
		btnHideComment.setBorder(new BevelBorder(BevelBorder.RAISED, Color.red, Color.red, 
				Color.red, Color.red));
		btnHideComment.addActionListener(this);
		contentPane.add(btnHideComment);
		
		lblScore = new JLabel("?????? ?????? : 4.0");
		lblScore.setBounds(262, 74, 160, 42);
		contentPane.add(lblScore);
		
		btnSearchComment = new JButton("????????????");
		btnSearchComment.setBorder(new BevelBorder(BevelBorder.RAISED, Color.red, Color.red, 
				Color.red, Color.red));
		btnSearchComment.setBackground(new Color(244, 204, 204));
		btnSearchComment.setBounds(1412, 70, 150, 50);
		btnSearchComment.addActionListener(this);
		contentPane.add(btnSearchComment);
		
		lblEndDate = new JLabel("?????? ?????????");
		lblEndDate.setBounds(1160, 94, 110, 42);
		contentPane.add(lblEndDate);
		
		lblStartDate = new JLabel("?????? ?????????");
		lblStartDate.setBounds(1160, 52, 110, 42);
		contentPane.add(lblStartDate);
	}
}
