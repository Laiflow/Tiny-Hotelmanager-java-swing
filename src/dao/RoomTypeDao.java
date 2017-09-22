package dao;

import java.util.ArrayList;
import java.util.List;

import entity.RoomType;

public class RoomTypeDao {
	private List<RoomType> roomTypeList;
	private static RoomTypeDao roomTypeDao;

	public static RoomTypeDao instance() {
		if (roomTypeDao == null)
			roomTypeDao = new RoomTypeDao();
		return roomTypeDao;
	}

	public RoomTypeDao() {
		roomTypeList = new ArrayList<RoomType>();
		addRoomType(new RoomType("单人房", 88, 88));
		addRoomType(new RoomType("双人房", 188, 188));
		addRoomType(new RoomType("豪华房房", 588, 588));
	}

	public void addRoomType(RoomType roomType) {
		roomTypeList.add(roomType);
	}

	public void setRoomType(int id, RoomType roomType) {
		for (int i = 0; i < roomTypeList.size(); ++i) {
			if (roomTypeList.get(i).getId() == id) {
				roomTypeList.set(i, roomType);
				return;
			}
		}
	}

	public List<RoomType> getRoomTypeList() {
		return roomTypeList;
	}

	public Object[] formatTakenData(RoomType roomType) {
		Object[] result = new Object[4];
		result[0] = roomType.getId();
		result[1] = roomType.getName();
		result[2] = roomType.getPrice();
		result[3] = roomType.getPriceAdded();
		return result;
	}

	public Object[][] getRoomTypesData() {
		Object[][] result = new Object[1][4];
		if (roomTypeList.size() > 0) {
			result = new Object[roomTypeList.size()][4];
			int i = 0;
			for (RoomType roomType : roomTypeList) {
				result[i] = formatTakenData(roomType);
				++i;
			}
		} else {
			result[0][0] = 0;
			result[0][1] = "没有数据";
			result[0][2] = 0;
			result[0][3] = 0;
		}
		return result;
	}

	public RoomType getRoomTypebyId(int id) {
		for (RoomType roomType : roomTypeList) {
			if (roomType.getId() == id)
				return roomType;
		}
		return null;
	}

	public String getNamebyId(int id) {
		for (RoomType roomType : roomTypeList) {
			if (roomType.getId() == id)
				return roomType.getName();
		}
		return null;
	}

	public int getPricebyId(int id) {
		for (RoomType roomType : roomTypeList) {
			if (roomType.getId() == id)
				return roomType.getPrice();
		}
		return 0;
	}

	public int getPriceAddedbyId(int id) {
		for (RoomType roomType : roomTypeList) {
			if (roomType.getId() == id)
				return roomType.getPriceAdded();
		}
		return 0;
	}

	public void removeRoomType(RoomType roomType) {
		roomTypeList.remove(roomType);
	}
}
