package gildedrose.console;

import java.util.List;

public class HotelConsole {

	private List<Item> items;

	public HotelConsole(List<Item> Items) {
		this.items = Items;
	}

	public void UpdateQuality() {
		for (int i = 0; i < items.size(); i++) {

			if (items.get(i).Name.equals("Sulfuras, Hand of Ragnaros")) {
				items.get(i).Quality = 80;

			} else {
				
				items.get(i).SellIn = items.get(i).SellIn - 1;
				
				if (items.get(i).Name.equals("Aged Brie")) {
					updateBrie(items.get(i));

				} else if (items.get(i).Name.equals("Backstage passes to a TAFKAL80ETC concert")) {
					updatePasse(items.get(i));

				} else { // todo resto
					updateItem(items.get(i));
				}
			}

		}// for
	}

	private void updateItem(Item item) {
		if (item.Quality > 0) {
			item.Quality--;
		}else {
			item.Quality = 0;
		}
		
		if (item.SellIn < 0 && item.Quality > 0) {
			item.Quality--;
		}
		
		if (item.Quality >= 50) {
			item.Quality = 50;
		}

	}

	private void updateBrie(Item item) {
		if (item.Quality < 50) {
			item.Quality++;
		}
		if (item.SellIn < 0 && item.Quality < 50) {
				item.Quality++;
			
		}
		if (item.Quality < 0) {
			item.Quality = 0;
		}
	}

	private void updatePasse(Item item) {
		if (item.Quality < 50) {
			
			item.Quality++;

			if (item.SellIn < 10) {
				if (item.Quality < 50) {
					item.Quality++;
				}
			}

			if (item.SellIn < 5) {
				if (item.Quality < 50) {
					item.Quality = item.Quality + 1;
				}
			}
		}
		if (item.SellIn < 0) {
			item.Quality = 0;
		}
	}
}
