package frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7635382088464340846L;
	private static LoginFrame loginFrame;
	private static JDialog loginDialog;
	

	public static LoginFrame instance() {
		if (loginFrame == null)
			loginFrame = new LoginFrame();
		return loginFrame;
	}

	public static JDialog getLoginDialog() {
		if (loginDialog == null)
			loginDialog = new JDialog();
		return loginDialog;
	}

	
	public void open() {



	public void easeOpacity(float opacity) {
		if (opacity <= 0) {
			opacity = 0;
			return;
		} else if (opacity > 1) {
			opacity = 1;
		}
		AWTUtilities.setWindowOpacity(loginDialog, opacity);
	}

	public void showMainFrame() {
		MainFrame.instance().open();
	}

	public void exit() {
		System.exit(0);
	}

	@Override
	public void run() {
		instance().open();
	}
}
