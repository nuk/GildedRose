package gildedrose.console;

import java.util.List;

public class HotelConsole {

	private List<Item> Items;

	public HotelConsole(List<Item> Items) {
		this.Items = Items;
	}

	public void UpdateQuality() {
		for (int i = 0; i < Items.size(); i++) {

			if (Items.get(i).Name == "Sulfuras, Hand of Ragnaros") {
				Items.get(i).Quality = 80;

			} else {
				
				Items.get(i).SellIn = Items.get(i).SellIn - 1;
				
				if (Items.get(i).Name == "Aged Brie") {
					updateBrie(Items.get(i));

				} else if (Items.get(i).Name == "Backstage passes to a TAFKAL80ETC concert") {
					updatePasse(Items.get(i));

				} else { // todo resto
					updateItem(Items.get(i));
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
		
		if (item.SellIn < 0){
			if (item.Quality > 0) {
				item.Quality--;
			}
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
		if (item.Quality<0)
			item.Quality = 0;
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
