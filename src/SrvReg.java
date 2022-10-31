

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Panel;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.accessibility.Accessible;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.awt.event.ActionEvent;

public class SrvReg extends JFrame {

	private JPanel contentPane;
	private JTextField srvName;
	private JTextField srvPrice;
	private LineBorder LineBorderRegTec1;
	private JTable table;
	private JTable table_1;
	
	
	String header[] = {"서비스명", "서비스제공 정비사", "서비스가격" };
	Object contents[][];
	String selectedItems[];
	private JTable table_2;
	private final JScrollPane scrollPane = new JScrollPane(table_2);
	
//	서비스제공 정비사 목록 -> DB랑 연결해야함
	private static ComboBoxModel<CheckableItem> makeModel() {
	    CheckableItem[] m = {
	        new CheckableItem("김하하", false),
	        new CheckableItem("이나나", false),
	        new CheckableItem("박호호", false),
	        new CheckableItem("강히히", false)
	    };
	    return new DefaultComboBoxModel<>(m);
	  }
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SrvReg frame = new SrvReg();
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
	public SrvReg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, Size.SCREEN_W, Size.SCREEN_H);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
//      폼 창이 화면 가운데서 뜨게 하는 기능
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SrvReg.class.getResource("/img/YellowCat.png")));
		lblNewLabel.setBounds(717, 57, 230, 94);
		contentPane.add(lblNewLabel);

		LineBorderRegTec1 = new LineBorder(Color.black, 1, true);
		
		Panel panel = new Panel();
		panel.setBounds(121, 234, 626, 579);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("서비스명");
		lblNewLabel_1.setFont(new Font("NanumBarunGothic", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(36, 43, 140, 55);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("서비스 제공 정비사 선택");
		lblNewLabel_1_1.setFont(new Font("NanumBarunGothic", Font.PLAIN, 21));
		lblNewLabel_1_1.setBounds(36, 201, 356, 55);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("서비스 가격 (공임비)");
		lblNewLabel_1_1_1.setFont(new Font("NanumBarunGothic", Font.PLAIN, 21));
		lblNewLabel_1_1_1.setBounds(36, 359, 259, 55);
		panel.add(lblNewLabel_1_1_1);
		
		srvName = new JTextField();
		srvName.setFont(new Font("NanumBarunGothic", Font.PLAIN, 21));
		srvName.setBounds(37, 111, 546, 45);
		panel.add(srvName);
		srvName.setColumns(10);
		
		
	    CheckedComboBox comboBox = new CheckedComboBox<>(makeModel());
	    comboBox.setFont(new Font("NanumBarunGothic", Font.PLAIN, 21));
		comboBox.setBounds(37, 267, 385, 45);
		panel.add(comboBox);

		
		ComboBoxModel<CheckableItem> model = comboBox.getModel();

		
		srvPrice = new JTextField();
		srvPrice.setFont(new Font("NanumBarunGothic", Font.PLAIN, 21));
		srvPrice.setColumns(10);
		srvPrice.setBounds(37, 423, 546, 45);
		panel.add(srvPrice);
		
		JButton btnSrvReg = new JButton("등록");
		btnSrvReg.setFont(new Font("NanumBarunGothic", Font.PLAIN, 21));

		btnSrvReg.setBounds(231, 493, Size.BTN_S_W, Size.BTN_S_H);
		panel.add(btnSrvReg);
		

//		테이블 더블클릭 수정 불가
		DefaultTableModel modelT = new DefaultTableModel(contents, header){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
//		modelT.setColumnIdentifiers(header);

		JTable table_2 = new JTable(modelT);
        
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(914, 234, 571, 579);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		table_2.setBounds(0, 74, 571, 505);
		panel_1.add(table_2);
//		panel_1.add(scrollPane);
		
		table_2.setRowHeight(25);
		table_2.setFont(new Font("NanumBarunGothic", Font.PLAIN, 18));
		
		modelT.addRow(header);
//		TableCellRenderer render = table_2.getCellRenderer(0,0);
//		((Component) render).setBackground(Color.LIGHT_GRAY);
				
				
		JLabel lblNewLabel_2 = new JLabel("등록된 서비스 목록");
		lblNewLabel_2.setBounds(197, 19, 177, 45);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("NanumBarunGothic", Font.PLAIN, 21));

//		modelT.addRow(header);



				
		
		JButton btnComSignUp = new JButton("회원가입 완료");
		btnComSignUp.setFont(new Font("NanumBarunGothic", Font.PLAIN, 21));
		btnComSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnComSignUp.setBounds(687, 862, Size.BTN_B_W, Size.BTN_B_H);
		contentPane.add(btnComSignUp);
		

		
		btnSrvReg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputStr[] = new String[3];
				
				inputStr[0] = srvName.getText();
				inputStr[1] = comboBox.getCheckedItemString(model);
				inputStr[2] = srvPrice.getText();
				
				modelT.addRow(inputStr);
			}
		});

		
	}
}

// Select multiple JCheckBox in JComboBox
class CheckableItem {
	  private final String text;
	  private boolean selected;

	  protected CheckableItem(String text, boolean selected) {
	    this.text = text;
	    this.selected = selected;
	  }

	  public boolean isSelected() {
	    return selected;
	  }

	  public void setSelected(boolean selected) {
	    this.selected = selected;
	  }

	  @Override public String toString() {
	    return text;
	  }
	}

class CheckedComboBox<E extends CheckableItem> extends JComboBox<E> {
	  protected boolean keepOpen;
	  private final JPanel panel = new JPanel(new BorderLayout());


	  protected CheckedComboBox(ComboBoxModel<E> model) {
	    super(model);
	  }

	  @Override public Dimension getPreferredSize() {
	    return new Dimension(200, 20);
	  }

	  @Override public void updateUI() {
	    setRenderer(null);
	    super.updateUI();

	    Accessible a = getAccessibleContext().getAccessibleChild(0);
	    if (a instanceof ComboPopup) {
	      ((ComboPopup) a).getList().addMouseListener(new MouseAdapter() {
	        @Override public void mousePressed(MouseEvent e) {
	          JList<?> list = (JList<?>) e.getComponent();
	          if (SwingUtilities.isLeftMouseButton(e)) {
	            keepOpen = true;
	            updateItem(list.locationToIndex(e.getPoint()));
	          }
	        }
	      });
	    }

	    DefaultListCellRenderer renderer = new DefaultListCellRenderer();
	    JCheckBox check = new JCheckBox();
	    check.setOpaque(false);
	    setRenderer((list, value, index, isSelected, cellHasFocus) -> {
	      panel.removeAll();
	      Component c = renderer.getListCellRendererComponent(
	          list, value, index, isSelected, cellHasFocus);
	      if (index < 0) {
	        String txt = getCheckedItemString(list.getModel());
	        JLabel l = (JLabel) c;
	        l.setText(txt.isEmpty() ? " " : txt);
	        l.setOpaque(false);
	        l.setForeground(list.getForeground());
	        panel.setOpaque(false);
	      } else {
	        check.setSelected(value.isSelected());
	        panel.add(check, BorderLayout.WEST);
	        panel.setOpaque(true);
	        panel.setBackground(c.getBackground());
	      }
	      panel.add(c);
	      return panel;
	    });
	    initActionMap();
	  }

	  protected void initActionMap() {
	    KeyStroke ks = KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0);
	    getInputMap(JComponent.WHEN_FOCUSED).put(ks, "checkbox-select");
	    getActionMap().put("checkbox-select", new AbstractAction() {
	      @Override public void actionPerformed(ActionEvent e) {
	        Accessible a = getAccessibleContext().getAccessibleChild(0);
	        if (a instanceof ComboPopup) {
	          updateItem(((ComboPopup) a).getList().getSelectedIndex());
	        }
	      }
	    });
	  }

	  protected void updateItem(int index) {
	    if (isPopupVisible() && index >= 0) {
	      E item = getItemAt(index);
	      item.setSelected(!item.isSelected());
	      setSelectedIndex(-1);
	      setSelectedItem(item);
	    }
	  }

	  @Override public void setPopupVisible(boolean v) {
	    if (keepOpen) {
	      keepOpen = false;
	    } else {
	      super.setPopupVisible(v);
	    }
	  }

	  protected static <E extends CheckableItem> String getCheckedItemString(ListModel<E> model) {
	    return IntStream.range(0, model.getSize())
	        .mapToObj(model::getElementAt)
	        .filter(CheckableItem::isSelected)
	        .map(Objects::toString)
	        .sorted()
	        .collect(Collectors.joining(", "));
	  }
	}

