package frame;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import dao.BookingDao;
import dao.RoomDao;
import dao.RoomTypeDao;

public class MainPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4090036947302273308L;
	private static MainPanel mainPanel;
	private DataTable table;
	private JScrollPane jscrolPane;
	private String dataType;

	public static MainPanel instance() {
		if (mainPanel == null)
			mainPanel = new MainPanel();
		return mainPanel;
	}

	public MainPanel() {
		mainPanel = this;
		setOpaque(false);
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(0, 0, 20, 10));
		table = new DataTable(null, null);
		jscrolPane = new JScrollPane();
		jscrolPane.setBorder(null);
		jscrolPane.setOpaque(false);
		jscrolPane.getViewport().setOpaque(false);
		add(jscrolPane);
		showRoomsBookedData();
	}

	@Override
	public void paint(Graphics g) {
		ImageIcon icon = new ImageIcon(this.getClass().getResource(
				"/images/scrollpane.png"));
		Image img = icon.getImage();
		g.drawImage(img, jscrolPane.getX(), jscrolPane.getY(),
				jscrolPane.getWidth(), jscrolPane.getHeight(), this);
		super.paint(g);
	}

	public DataTable getTable() {
		return table;
	}

	public void showAllRoomsData() {
		dataType = "AllRooms";
		Object[] head = { "����", "��������", "����¥��", "����۸�", "���ӷ���" };
		showData(RoomDao.instance().getRoomsData(), head);
		JMenuItem add = new JMenuItem("    ��ӷ���    ");
		JMenuItem addRooms = new JMenuItem("    �������    ");
		JMenuItem delete = new JMenuItem("    ɾ������    ");
		JPopupMenu menu = new JPopupMenu();
		menu.add(add);
		menu.add(addRooms);
		menu.add(delete);

	}

	public void showExpiredRoomsData() {
		dataType = "ExpiredRooms";
		Object[] head = { "����", "��������", "��������", "��ʼʱ��", "����ʱ��" };
		showData(RoomDao.instance().getExpiredRoomsData(), head);
		JPopupMenu menu = new JPopupMenu();
		JMenuItem checkout = new JMenuItem("    �������    ");
		JMenuItem addHours = new JMenuItem("    �������    ");
		menu.add(checkout);
		menu.add(addHours);

	}

	public void showRoomTypesData() {
		dataType = "RoomTypes";
		Object[] head = { "ID", "��������", "����۸�", "���ѷ���" };
		showData(RoomTypeDao.instance().getRoomTypesData(), head);
		

	}

	public void showRoomsBookedData() {
		dataType = "RoomsBooked";
		Object[] head = { "����", "��������", "�绰����", "Ԥ��ʱ��", "Ԥ��ʱ��" };
		showData(BookingDao.instance().getBookingsData(), head);
	
		
	
	}

	public void showRoomTakenData() {
		dataType = "RoomsTaken";
		Object[] head = { "����", "��������", "��������", "��ʼʱ��", "����ʱ��" };
		showData(RoomDao.instance().getRoomsTakenData(), head);
	}

	public void showData(Object[][] data, Object[] head) {
		table.removeAll();
		table = new DataTable(data, head);
		jscrolPane.setViewportView(table);
	}

	public void refresh() {
		if (dataType.equals("AllRooms")) {
			showAllRoomsData();
		} else if (dataType.equals("RoomTypes")) {
			showRoomTypesData();
		} else if (dataType.equals("RoomsBooked")) {
			showRoomsBookedData();
		} else if (dataType.equals("RoomsTaken")) {
			showRoomTakenData();
		} else if (dataType.equals("ExpiredRooms")) {
			showExpiredRoomsData();
		
		}
	}

}
