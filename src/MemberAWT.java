

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemberAWT extends CFrame implements ActionListener {
	
	JLabel lab1, lab2, lab3, lab4;
	JTextField tf1, tf2, tf3, tf4;
	JButton upBtn;
	MemberMgr mgr;
	MemberBean bean;
	

	public MemberAWT() {
		super(300, 300);
		setTitle("Member MAG Ver1.0");
		mgr = new MemberMgr();
		reload();
		add(upBtn = new JButton("update"), BorderLayout.SOUTH);
		upBtn.addActionListener(this);
		validate();
	}

	public void reload() {
		bean =  mgr.select(1);
		updateForm(bean);
	}
	
	public void updateForm(MemberBean bean) {
		JPanel p1, p2, p3, p4, p5;
		p1 = new JPanel();
		p1.add(lab1 = new JLabel("이름"));
		p1.add(tf1 = new JTextField(bean.getName(), 10));
		
		p2 = new JPanel();
		p2.add(lab2 = new JLabel("전화번호"));
		p2.add(tf2 = new JTextField(bean.getPhone(), 10));
		
		p3 = new JPanel();
		p3.add(lab3 = new JLabel("사는곳"));
		p3.add(tf3 = new JTextField(bean.getAddress(), 10));
		
		p4 = new JPanel();
		p4.add(lab4 = new JLabel("팀"));
		p4.add(tf4 = new JTextField(bean.getTeam(), 10));
		
		p5 = new JPanel();
		p5.add(p1);
		p5.add(p2);
		p5.add(p3);
		p5.add(p4);
		add(p5, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==upBtn) {
			MemberUpdate update = new MemberUpdate(this, bean);
		}
	}

	public static void main(String[] args) {
		new MemberAWT();
	}
}
