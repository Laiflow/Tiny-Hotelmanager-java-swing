package frame;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import listener.OptionListener;

public class OptionPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1613590806361203632L;
	private static OptionPanel optionPanel;
	
	static public OptionPanel instance(){
		if(optionPanel == null)
			optionPanel = new OptionPanel();
		return optionPanel;
	}

	public OptionPanel() {
		setLayout(new FlowLayout(FlowLayout.RIGHT, 30, 10));
		setSize(1366, 150);
		setOpaque(false);
		optionPanel = this;
		ImageButton jbtBookRoom = new ImageButton("book");
		ImageButton jbtTakeRoom = new ImageButton("take");
		ImageButton jbtRefresh = new ImageButton("refresh");
		jbtBookRoom.setToolTipText("¡¡¶©·¿¡¡");
		jbtTakeRoom.setToolTipText("¡¡ÄÃ·¿¡¡");
		jbtRefresh.setToolTipText("¡¡Ë¢ÐÂ¡¡");


		jbtBookRoom.setPreferredSize(new Dimension(80, 80));
		jbtTakeRoom.setPreferredSize(new Dimension(80, 80));
		jbtRefresh.setPreferredSize(new Dimension(80, 80));
		
		OptionListener optionListener = new OptionListener(jbtBookRoom,
				jbtTakeRoom, jbtRefresh);
		jbtBookRoom.addActionListener(optionListener);
		jbtTakeRoom.addActionListener(optionListener);
		jbtRefresh.addActionListener(optionListener);
	


		add(jbtBookRoom);
		add(jbtTakeRoom);
		add(jbtRefresh);

	}
}
