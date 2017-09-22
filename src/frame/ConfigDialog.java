package frame;


import javax.swing.JDialog;

import javax.swing.JTextField;


import dao.ConfigDao;
import entity.Config;

public class ConfigDialog extends JDialog {
	private static final long serialVersionUID = 5016876596940564305L;
	private static ConfigDialog configDialog;
	private JTextField jtfName, jtfDiscount, jtfHours, jtfHoursAdded, jtfBg;

	public static ConfigDialog instance() {
		if (configDialog == null)
			configDialog = new ConfigDialog();
		return configDialog;
	}

	public void open() {
		Config config = ConfigDao.instance().getConfig();
		jtfName.setText(config.getName());
		jtfDiscount.setText(String.valueOf(config.getDiscount()));
		jtfHours.setText(String.valueOf(config.getHoursTaken()));
		jtfHoursAdded.setText(String.valueOf(config.getHoursAdded()));
		jtfBg.setText(config.getBackground());
		setVisible(true);
	}
}
