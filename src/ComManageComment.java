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
	private JLabel lblDialog;
	private JButton btnBackCommentMain;
	private JButton btnHideComment;
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
            lblDialog.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            btnHideComment.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
            btnBackCommentMain.setFont(font.deriveFont(Font.BOLD, FONT_SIZE));
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
	
	private int createMsgDialog(String title, String msg, String imgPath, int option) {
		try {
			lblDialog.setText("<html><center>" + msg);
			String classPath = ComLogin.class.getResource("").getPath();
            String path = URLDecoder.decode(classPath, "UTF-8");
            path += imgPath;
            
            ImageIcon icon = new ImageIcon(path);
            lblDialog.setIcon(icon);
            lblDialog.setHorizontalAlignment(SwingConstants.CENTER);
            
            if(option == JOptionPane.PLAIN_MESSAGE) {
    			JOptionPane.showMessageDialog(this, lblDialog, title, JOptionPane.PLAIN_MESSAGE);
    			return -1;
            } else if(option == JOptionPane.YES_NO_OPTION) {
            	// YES => 0, NO => 1 Return
            	return JOptionPane.showConfirmDialog(this, lblDialog, title, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
            }
		} catch(Exception ex) {
			createMsgDialog("에러", "다이얼로그를 생성하는 과정에 문제가 발생했습니다.", null, JOptionPane.PLAIN_MESSAGE); // 이미지 추가 필요
		}
		
		return -2; // 비정상적 작동
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
				createMsgDialog("에러", "선택된 셀이 없습니다.", "\\img\\YellowCat.png", JOptionPane.PLAIN_MESSAGE);
				return;
			}
			
			int result = createMsgDialog("알림", "정말로 선택한 댓글을 표시안하겠습니까?", "\\img\\YellowCat.png", JOptionPane.YES_NO_OPTION);
			if(result == 0) {
				createMsgDialog("알림", "정상적으로 처리되었습니다.", "\\img\\YellowCat.png", JOptionPane.PLAIN_MESSAGE);
			} else {
				createMsgDialog("알림", "작업이 취소되었습니다.", "\\img\\YellowCat.png", JOptionPane.PLAIN_MESSAGE);
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
		btnBackCommentMain.setBounds(690, 918, Size.BTN_B_W, Size.BTN_B_H);
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
		
		lblDialog = new JLabel("");
	}
}
