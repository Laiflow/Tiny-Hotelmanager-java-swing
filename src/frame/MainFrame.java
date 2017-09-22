package frame;

import java.awt.BorderLayout;
import java.awt.Container;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements Runnable {
	private static MainFrame mainFrame;

	public static MainFrame instance() {
		if (mainFrame == null)
			mainFrame = new MainFrame();
		return mainFrame;
	}

	public MainFrame() {
		setTitle("东软酒店管理系统");
		setSize(650,500);
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		container.add(new OptionPanel(), BorderLayout.NORTH);
		container.add(new MenuPanel(), BorderLayout.WEST);
		container.add(new MainPanel(), BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		//注意这里是关键，将背景标签添加到jfram的LayeredPane面板里
	
	}

	public void open() {
		setVisible(true);

	}

	@Override
	public void run() {
		instance();
	}
	
public static void main(String[] args) {
	 MainFrame.instance().open();
}
}