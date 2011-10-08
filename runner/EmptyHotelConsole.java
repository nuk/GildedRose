import java.util.List;

import gildedrose.console.HotelConsole;
import gildedrose.console.Item;


public class EmptyHotelConsole extends HotelConsole {

	public EmptyHotelConsole(List<Item> Items) {
		super(Items);
	}

	@Override
	public void UpdateQuality() {
		// do nothing
	}
	
}
