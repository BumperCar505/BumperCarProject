
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class CFrame extends JFrame{
	public CFrame() {
		this(300,300,new Color(220,220,220),false);
	}
	public CFrame(int w, int h) {
		this(w,h,new Color(220,220,220),false);
	}////
	public CFrame(Color c) {
		this(300,300,c,false);
	}
	public CFrame(int w, int h,Color c ) {
		this(w,h,c,false);
	}
	public CFrame(int w, int h, Color c, boolean flag) {
		//setLayout(new FlowLayout());
		setSize(w, h);
		setBackground(c);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setVisible(true);
		//setResizable(flag);
	}

}
