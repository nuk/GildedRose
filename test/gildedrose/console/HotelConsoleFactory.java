package gildedrose.console;

import java.util.List;

public class HotelConsoleFactory {

	private static Class hotelConsoleClass = HotelConsole.class;
	
	public static HotelConsole createConsole(List<Item> items){
		try {
			return (HotelConsole) hotelConsoleClass.getConstructor(List.class).newInstance(items);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void setHotelConsoleClass(Class clazz){
		hotelConsoleClass = clazz;
	}
	
}
