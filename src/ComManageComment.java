import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import javax.swing.JCheckBox;

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
	private JCheckBox checkBox;
	private final int FONT_SIZE = 21;
	
	// model1 : 시작일, model2 : 종료일
	private UtilDateModel model1, model2;
	private JDatePanelImpl datePanel1, datePanel2;
	private JDatePickerImpl datePicker1, datePicker2;
	
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
            checkBox.setFont(font.deriveFont(Font.BOLD, 18));

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
				DialogManager.createMsgDialog("선택된 셀이 없습니다.", "\\img\\information5.png",
						"에러", JOptionPane.PLAIN_MESSAGE);
				return;
			}
			
			int result = DialogManager.createMsgDialog("정말로 선택한 댓글을 숨길까요?", "\\img\\question6.png",
					"알림", JOptionPane.YES_NO_OPTION);
			if(result == 0) {
				DialogManager.createMsgDialog("정상적으로 처리되었습니다.", "\\img\\success1.png",
						"알림", JOptionPane.PLAIN_MESSAGE);
			} else {
				DialogManager.createMsgDialog("작업이 취소되었습니다.", "\\img\\information5.png",
						"알림", JOptionPane.PLAIN_MESSAGE);
			}
		} else if(obj == btnSearchComment) {
			boolean flag = false;
			int startYear = model1.getYear();
			int startMonth = model1.getMonth();
			int startDay = model1.getDay();
			int endYear = model2.getYear();
			int endMonth = model2.getMonth();
			int endDay = model2.getDay();
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			try {
				Date startDate = dateFormat.parse(String.valueOf(startYear) + startMonth + startDay);
				Date endDate = dateFormat.parse(String.valueOf(endYear) + endMonth + endDay);
				
				if(startDate.after(endDate)) {
					flag = true;
				}
			} catch(ParseException ex) {
				// ex.getMessage();
				DialogManager.createMsgDialog("달력 처리하는 과정에서 문제 발생", "\\img\\information5.png",
						"에러", JOptionPane.PLAIN_MESSAGE);
			}
			
			if(flag == true) {
				DialogManager.createMsgDialog("방문 종료일은 방문 시작일보다<br> 이전날짜가 될수없습니다.", "\\img\\information5.png",
						"에러", JOptionPane.PLAIN_MESSAGE);
			} else {
				DialogManager.createMsgDialog("검색이 완료되었습니다.", "\\img\\success1.png",
						"알림", JOptionPane.PLAIN_MESSAGE);
			}
		} else if(obj == checkBox) {
			if(checkBox.isSelected() == true) {
				datePicker1.setVisible(true);
				datePicker2.setVisible(true);
				model1.setSelected(true);
				model2.setSelected(true);
			} else {
				datePicker1.setVisible(false);
				datePicker2.setVisible(false);
				model1.setSelected(false);
				model2.setSelected(false);
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
		setTitle("다고쳐카센터 - 코멘트관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, Size.SCREEN_W, Size.SCREEN_H);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null); // 이거 없으면 정상적으로 레이아웃 안그려진다..
		
		// 값은 임의로 집어넣은것으로 추후 DB에서 가져와야함
		Object[] columns = {"번호", "고객명", "방문날짜", "서비스내용", "별점", "코멘트"};
		Object[][] rowNames = {
				{"1", "홍길동", "2022-02-11", "타이어교체", "★★★", "수리하는데 시간이 너무 오래걸림"},
				{"2", "김홍도", "2022-02-13", "엔진오일교체", "★★★★★", "가성비있게 교체한 것 같습니다..."
						+ "위치도 좋구요~^^"}
		};
		
		// Text Align Center
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		render.setHorizontalAlignment(SwingConstants.CENTER);
		
		tableCommentList = new JTable(rowNames, columns);
		tableCommentList.setAutoCreateRowSorter(true);
		tableCommentList.setDefaultEditor(Object.class, null); // 테이블 값 수정 안되게
		tableCommentList.getTableHeader().setResizingAllowed(false);
		tableCommentList.getColumn("번호").setCellRenderer(render);
		tableCommentList.getColumn("고객명").setCellRenderer(render);
		tableCommentList.getColumn("방문날짜").setCellRenderer(render);
		tableCommentList.getColumn("서비스내용").setCellRenderer(render);
		tableCommentList.getColumn("별점").setCellRenderer(render);
		tableCommentList.getColumn("코멘트").setCellRenderer(render);
		
		// Column Not Move
		tableCommentList.getTableHeader().setReorderingAllowed(false);
		
		// Column Change Width
		tableCommentList.getColumn("서비스내용").setPreferredWidth(200);
		tableCommentList.getColumn("코멘트").setPreferredWidth(500);
		
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
		
		btnBackCommentMain = new JButton("돌아가기");
		btnBackCommentMain.setBackground(new Color(244, 204, 204));
		btnBackCommentMain.setBounds(670, 918, Size.BTN_B_W, Size.BTN_B_H);
		btnBackCommentMain.setBorder(new BevelBorder(BevelBorder.RAISED, Color.red, Color.red, 
				Color.red, Color.red));
		contentPane.add(btnBackCommentMain);
		
		btnHideComment = new JButton("댓글 숨기기");
		btnHideComment.setBackground(new Color(244, 204, 204));
		btnHideComment.setBounds(100, 70, Size.BTN_S_W, Size.BTN_S_H);
		btnHideComment.setBorder(new BevelBorder(BevelBorder.RAISED, Color.red, Color.red, 
				Color.red, Color.red));
		btnHideComment.addActionListener(this);
		contentPane.add(btnHideComment);
		
		lblScore = new JLabel("평균 별점 : 4.0");
		lblScore.setBounds(262, 74, 160, 42);
		contentPane.add(lblScore);
		
		btnSearchComment = new JButton("검색하기");
		btnSearchComment.setBorder(new BevelBorder(BevelBorder.RAISED, Color.red, Color.red, 
				Color.red, Color.red));
		btnSearchComment.setBackground(new Color(244, 204, 204));
		btnSearchComment.setBounds(1412, 70, 150, 50);
		btnSearchComment.addActionListener(this);
		contentPane.add(btnSearchComment);
		
		lblEndDate = new JLabel("방문 종료일");
		lblEndDate.setBounds(1160, 94, 110, 42);
		contentPane.add(lblEndDate);
		
		lblStartDate = new JLabel("방문 시작일");
		lblStartDate.setBounds(1160, 52, 110, 42);
		contentPane.add(lblStartDate);
		
		model1 = new UtilDateModel();
		model1.setSelected(false);
		datePanel1 = new JDatePanelImpl(model1);
		datePicker1 = new JDatePickerImpl(datePanel1);
		datePicker1.setBounds(1275, 61, 125, 40);
		datePicker1.setVisible(false);
		contentPane.add(datePicker1);
		
		model2 = new UtilDateModel();
		model2.setSelected(false);
		datePanel2 = new JDatePanelImpl(model2);
		datePicker2 = new JDatePickerImpl(datePanel2);
		datePicker2.setBounds(1275, 102, 125, 40);
		datePicker2.setVisible(false);
		contentPane.add(datePicker2);
		
		checkBox = new JCheckBox("범위 검색 사용");
		checkBox.setBounds(1155, 25, 135, 35);
		checkBox.addActionListener(this);
		contentPane.add(checkBox);
	}
}
