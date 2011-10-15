package gildedrose.console;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class HotelConsoleTest {

	/*
	 * - All items have a SellIn value which denotes the number of days we have
	 * to sell the item - All items have a Quality value which denotes how
	 * valuable the item is - At the end of each day our system lowers both
	 * values for every item
	 * 
	 * - Once the sell by date has passed, Quality degrades twice as fast 
	 * - The Quality of an item is never negative 
	 * - "Aged Brie" actually increases in Quality the older it gets 
	 * - The Quality of an item is never more than 50
	 * - "Sulfuras", being a legendary item, never has to be sold or decreases in Quality 
	 * - "Backstage passes", like aged brie, increases in Quality as
	 * it's SellIn value approaches; Quality increases by 2 when there are 10
	 * days or less and by 3 when there are 5 days or less but Quality drops to
	 * 0 after the concert
	 */
	
	private List<Item> items;
	private HotelConsole console;

	@Before
	public void setUp() throws Exception {
		items = new ArrayList<Item>();
		Item item1 = new Item("item normal 1", 4, 5);
		Item item2 = new Item("item normal 2", 3, 4);
		Item item3 = new Item("Sulfuras", 80, 80);
		Item item4 = new Item("Aged Brie", 4, 5);
		Item item5 = new Item("Backstage passes", 4, 5);
	}

	@Test
	public void qualityShouldNeverBeNegative() {
		
		fail("Not yet implemented");
	}
	
	@Test
	public void agedBrieQualitySHouldIncreaseOverTime() {
		fail("Not yet implemented");
	}
	
	@Test
	public void sulfurasShouldNeverChange() {
		fail("Not yet implemented");
	}
	
	@Test 
	public void qualityShouldDecreaseTwiceAsFastAfterSellInExpires(){
		fail("");		
	}

}
