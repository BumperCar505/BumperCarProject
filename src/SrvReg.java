import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.accessibility.Accessible;
import javax.swing.AbstractAction;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;
import javax.swing.JComponent;

public class SrvReg extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	DefaultTableModel dtm;
    Vector<String> list;
    Vector<String> colName;
    private JTextField srvName;
    private JTextField srvPrice;

    
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

	SrvReg()
    {

        setBounds(300, 300, Size.SCREEN_W, Size.SCREEN_H);
        
//      폼 창이 화면 가운데서 뜨게 하는 기능
		setLocationRelativeTo(null);
        
        /////////////////////////////////////////////
        colName = new Vector<String>();
        
        colName.add("서비스명");
        colName.add("서비스제공 정비사");
        colName.add("서비스 가격");
        
        // 익명중첩 클래스로 테이블 편집 여부를 설정한다.
        dtm = new DefaultTableModel(colName ,0){        // DefaultTableModel(Vector ColumnNames, int rowCount)

            @Override
            public boolean isCellEditable(int row, int column)      // 테이블의 편집 가능 여부를 알려주는 메소드
            {
                return false;       // 편집이 안되도록 한다.
            }
        };
        
        
        table = new JTable(dtm);
        table.getTableHeader().setFont(new Font("NanumBarunGothic", Font.PLAIN, 18));
        table.getTableHeader().setReorderingAllowed(false);     // JTable의 헤더를 고정시킨다. (true는 고정해제)
        getContentPane().setLayout(null);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(914, 234, 571, 579);
        getContentPane().add(scrollPane);        // table을 담은 JScollPane을 JFrame에 부착 
        
     
        setVisible(true);                       // table을 단순히 JFrame에 부착시 헤더가 나오지 않는다
        
        table.setRowHeight(25);
		table.setFont(new Font("NanumBarunGothic", Font.PLAIN, 18));
        
        //////////////////////////////////////////
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(SrvReg.class.getResource("/img/YellowCat.png")));
		lblNewLabel.setBounds(717, 57, 230, 94);
        getContentPane().add(lblNewLabel);
        
        JPanel panel = new JPanel();
        panel.setBounds(121, 182, 626, 631);
        getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("서비스명");
		lblNewLabel_1.setFont(new Font("NanumBarunGothic", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(36, 43, 140, 55);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("서비스 제공 정비사 선택");
        lblNewLabel_2.setFont(new Font("NanumBarunGothic", Font.PLAIN, 21));
        lblNewLabel_2.setBounds(36, 201, 356, 55);
        panel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("서비스 가격 (공임비)");
        lblNewLabel_3.setFont(new Font("NanumBarunGothic", Font.PLAIN, 21));
        lblNewLabel_3.setBounds(36, 359, 259, 55);
        panel.add(lblNewLabel_3);
        
        srvName = new JTextField();
        srvName.setFont(new Font("NanumBarunGothic", Font.PLAIN, 21));
		srvName.setBounds(37, 111, 546, 45);
        panel.add(srvName);
//        srvName.setColumns(10);
        
        srvPrice = new JTextField();
        srvPrice.setFont(new Font("NanumBarunGothic", Font.PLAIN, 21));
		srvPrice.setBounds(37, 423, 546, 45);
        panel.add(srvPrice);
//        srvPrice.setColumns(10);
        
        CheckedComboBox comboBox = new CheckedComboBox<>(makeModel());
	    comboBox.setFont(new Font("NanumBarunGothic", Font.PLAIN, 21));
		comboBox.setBounds(37, 267, 385, 45);
		panel.add(comboBox);

		
		ComboBoxModel<CheckableItem> model = comboBox.getModel();
        
		JButton btnSrvReg = new JButton("등록");
		btnSrvReg.setFont(new Font("NanumBarunGothic", Font.PLAIN, 21));

		btnSrvReg.setBounds(231, 493, Size.BTN_S_W, Size.BTN_S_H);
		panel.add(btnSrvReg);
		
		JLabel lblNewLabel_4 = new JLabel("등록된 서비스 목록");
		lblNewLabel_4.setBounds(1106, 182, 169, 40);
		getContentPane().add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("NanumBarunGothic", Font.PLAIN, 21));
		
		JButton btnComSignUp = new JButton("회원가입 완료");
		btnComSignUp.setFont(new Font("NanumBarunGothic", Font.PLAIN, 21));
		btnComSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnComSignUp.setBounds(687, 862, Size.BTN_B_W, Size.BTN_B_H);
		getContentPane().add(btnComSignUp);
        

		btnSrvReg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				String inputStr[] = new String[3];
//				
//				inputStr[0] = srvName.getText();
//				inputStr[1] = comboBox.getCheckedItemString(model);
//				inputStr[2] = srvPrice.getText();
//				
//				dtm.addRow(inputStr);
				
				Vector<String> list = new Vector<String>();
				list.add(srvName.getText());
				list.add(comboBox.getCheckedItemString(model));
				list.add(srvPrice.getText());
				dtm.addRow(list);
				
			}
		});


    }
}


//Select multiple JCheckBox in JComboBox
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