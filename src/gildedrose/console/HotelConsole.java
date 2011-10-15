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

			} else {
				if (Items.get(i).Name == "Aged Brie") {
					updateBrie(Items.get(i));
				}else if (Items.get(i).Name == "Backstage passes to a TAFKAL80ETC concert"){
					updatePasse(Items.get(i));
				}else { //todo resto
					updateItem(Items.get(i));
					Items.get(i).SellIn = Items.get(i).SellIn - 1;
					
					if (Items.get(i).Name != "Aged Brie"
							&& Items.get(i).Name != "Backstage passes to a TAFKAL80ETC concert") {
						if (Items.get(i).Quality > 0) {
								Items.get(i).Quality--;
						}
					} else {// se for queijo ou passe
						if (Items.get(i).Quality < 50) {
							Items.get(i).Quality ++;

							if (Items.get(i).Name == "Backstage passes to a TAFKAL80ETC concert") {
								if (Items.get(i).SellIn < 11) {
									if (Items.get(i).Quality < 50) {
										Items.get(i).Quality++;
									}
								}

								if (Items.get(i).SellIn < 6) {
									if (Items.get(i).Quality < 50) {
										Items.get(i).Quality = Items.get(i).Quality + 1;
									}
								}
							}
						}
					}
					
				}
				
				Items.get(i).SellIn = Items.get(i).SellIn - 1;

				if (Items.get(i).SellIn < 0) {// validade acabou
					if (Items.get(i).Name != "Aged Brie") {
						if (Items.get(i).Name != "Backstage passes to a TAFKAL80ETC concert") {
							if (Items.get(i).Quality > 0) {
									Items.get(i).Quality--;
							}
						}// 2° if
						else {// nao acontece com queijo
							Items.get(i).Quality = 0;
						}
					}// 1° if
					else {
						if (Items.get(i).Quality < 50) {
							Items.get(i).Quality++;
						}
					}
				}
			}
		}
	}// for
	
	private void updateItem(Item item) {
		item.SellIn--;
		
	}

	private void updateBrie(Item item){
		if (item.Quality < 50) {
			item.Quality ++;

			if (item.Name == "Backstage passes to a TAFKAL80ETC concert") {
				if (item.SellIn < 11) {
					if (item.Quality < 50) {
						item.Quality++;
					}
				}

				if (item.SellIn < 6) {
					if (item.Quality < 50) {
						item.Quality = item.Quality + 1;
					}
				}
			}
		}
	}
	
	private void updatePasse(Item item){
		if (item.Quality < 50) {
			item.Quality ++;

			if (item.SellIn < 11) {
				if (item.Quality < 50) {
					item.Quality++;
				}
			}

			if (item.SellIn < 6) {
				if (item.Quality < 50) {
					item.Quality = item.Quality + 1;
				}
			}
		}
	}
}
