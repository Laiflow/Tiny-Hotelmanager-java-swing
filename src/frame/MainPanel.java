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
		Object[] head = { "房号", "房间类型", "房间楼层", "房间价格", "加钟费用" };
		showData(RoomDao.instance().getRoomsData(), head);
		JMenuItem add = new JMenuItem("    添加房间    ");
		JMenuItem addRooms = new JMenuItem("    批量添加    ");
		JMenuItem delete = new JMenuItem("    删除房间    ");
		JPopupMenu menu = new JPopupMenu();
		menu.add(add);
		menu.add(addRooms);
		menu.add(delete);

	}

	public void showExpiredRoomsData() {
		dataType = "ExpiredRooms";
		Object[] head = { "房号", "房间类型", "房间消费", "开始时间", "结束时间" };
		showData(RoomDao.instance().getExpiredRoomsData(), head);
		JPopupMenu menu = new JPopupMenu();
		JMenuItem checkout = new JMenuItem("    房间结算    ");
		JMenuItem addHours = new JMenuItem("    房间加钟    ");
		menu.add(checkout);
		menu.add(addHours);

	}

	public void showRoomTypesData() {
		dataType = "RoomTypes";
		Object[] head = { "ID", "类型名称", "房间价格", "续费费用" };
		showData(RoomTypeDao.instance().getRoomTypesData(), head);
		

	}

	public void showRoomsBookedData() {
		dataType = "RoomsBooked";
		Object[] head = { "房号", "房间类型", "电话号码", "预订时长", "预订时间" };
		showData(BookingDao.instance().getBookingsData(), head);
	
		
	
	}

	public void showRoomTakenData() {
		dataType = "RoomsTaken";
		Object[] head = { "房号", "房间类型", "房间消费", "开始时间", "结束时间" };
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
