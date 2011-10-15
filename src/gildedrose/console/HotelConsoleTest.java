package gildedrose.console;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class HotelConsoleTest {

	@Test
	public void shouldDecrementAtTheEndOFTheDay(){
		List<Item> items = new ArrayList<Item>();
		Collections.addAll(items, new Item("Coke",10,10),new Item("Pepsi",15,9), new Item("Doctor Pepper",5,11));
		
		runUpdate(items);
		
		assertEquals(9, items.get(0).SellIn);
		assertEquals(9, items.get(0).Quality);
		assertEquals(14, items.get(1).SellIn);
		assertEquals(8, items.get(1).Quality);
		assertEquals(4, items.get(2).SellIn);
		assertEquals(10, items.get(2).Quality);
	}
	
	@Test
	public void shouldDecrementTwiceAsFasAfterSellDate(){
		List<Item> items = new ArrayList<Item>();
		Collections.addAll(items, new Item("Coke",0,10),new Item("Pepsi",-1,9), new Item("Doctor Pepper",0,7));
		
		runUpdate(items);
		
		assertEquals(8, items.get(0).Quality);
		assertEquals(7, items.get(1).Quality);
		assertEquals(5, items.get(2).Quality);
	}
	
	@Test
	public void shouldNeverAllowANegativeQuality(){
		List<Item> items = new ArrayList<Item>();
		Collections.addAll(items, new Item("Coke",1,0),new Item("Pepsi",0,0), new Item("Doctor Pepper",-2,0));
		
		runUpdate(items);
		
		assertEquals(0, items.get(0).Quality);
		assertEquals(0, items.get(1).Quality);
		assertEquals(0, items.get(2).Quality);
	}
	
	@Test
	public void shouldIncreaseAgedBrieQualityAOverTime(){
		List<Item> items = new ArrayList<Item>();
		Collections.addAll(items, new Item("Aged Brie",1,0),new Item("Aged Brie",10,10), 
				new Item("Aged Brie",0,5));
		
		runUpdate(items);
		
		assertEquals(1, items.get(0).Quality);
		assertEquals(11, items.get(1).Quality);
		assertEquals(7, items.get(2).Quality);
	}
	
	@Test
	public void shouldNotAllowAQualityOver50(){
		List<Item> items = new ArrayList<Item>();
		Collections.addAll(items, new Item("Aged Brie",10,50),new Item("Aged Brie",0,49));
		
		runUpdate(items);
		
		assertEquals(50, items.get(0).Quality);
		assertEquals(50, items.get(1).Quality);
	}
	
	@Test
	public void shouldNotDecrementSulfurasQualityAndSellIn(){
		List<Item> items = new ArrayList<Item>();
		Collections.addAll(items, new Item("Sulfuras, Hand of Ragnaros",10,80),new Item("Sulfuras, Hand of Ragnaros",0,80),
				new Item("Sulfuras, Hand of Ragnaros",-1,80));
		
		runUpdate(items);
		
		assertEquals(10, items.get(0).SellIn);
		assertEquals(80, items.get(0).Quality);
		assertEquals(0, items.get(1).SellIn);
		assertEquals(80, items.get(1).Quality);
		assertEquals(-1, items.get(2).SellIn);
		assertEquals(80, items.get(2).Quality);
	}
	
	@Test
	public void shouldIncreaseBackstagePassesQualityAOverTime(){
		List<Item> items = new ArrayList<Item>();
		Collections.addAll(items, new Item("Backstage passes to a TAFKAL80ETC concert",15,0),
				new Item("Backstage passes to a TAFKAL80ETC concert",20,10));
		
		runUpdate(items);
		
		assertEquals(1, items.get(0).Quality);
		assertEquals(11, items.get(1).Quality);
	}
	
	@Test
	public void shouldIncreaseBackstagePassesQualityBy2Before10Days(){
		List<Item> items = new ArrayList<Item>();
		Collections.addAll(items, new Item("Backstage passes to a TAFKAL80ETC concert",10,0),
				new Item("Backstage passes to a TAFKAL80ETC concert",7,10));
		
		runUpdate(items);
		
		assertEquals(2, items.get(0).Quality);
		assertEquals(12, items.get(1).Quality);
	}
	
	@Test
	public void shouldIncreaseBackstagePassesQualityBy3Before5Days(){
		List<Item> items = new ArrayList<Item>();
		Collections.addAll(items, new Item("Backstage passes to a TAFKAL80ETC concert",5,0),
				new Item("Backstage passes to a TAFKAL80ETC concert",3,10),
				new Item("Backstage passes to a TAFKAL80ETC concert",1,5));
		
		runUpdate(items);
		
		assertEquals(3, items.get(0).Quality);
		assertEquals(13, items.get(1).Quality);
		assertEquals(8, items.get(2).Quality);
	}
	
	@Test
	public void shouldSetBackstagePassesQualityToZeroAfterSellDate(){
		List<Item> items = new ArrayList<Item>();
		Collections.addAll(items, new Item("Backstage passes to a TAFKAL80ETC concert",0,0),
				new Item("Backstage passes to a TAFKAL80ETC concert",0,10),
				new Item("Backstage passes to a TAFKAL80ETC concert",-1,5),
				new Item("Backstage passes to a TAFKAL80ETC concert",-3,-5));
		
		runUpdate(items);
		
		assertEquals(0, items.get(0).Quality);
		assertEquals(0, items.get(1).Quality);
		assertEquals(0, items.get(2).Quality);
		assertEquals(0, items.get(3).Quality);
	}
	
	@Test
	public void shouldNotAllowInconsisntenciesInDataPropagate(){
		List<Item> items = new ArrayList<Item>();
		Collections.addAll(items, new Item("Ginger Ale",2,-3),new Item("Aged Brie",-2,-3),
				new Item("Coke",1,55), new Item("Sulfuras, Hand of Ragnaros",10,49));
		
		runUpdate(items);
		
		assertEquals(0, items.get(0).Quality); // Quality should never be negative
		assertEquals(0, items.get(1).Quality); // Quality should never be negative
		assertEquals(50, items.get(2).Quality); // Quality should never be more than 50
		assertEquals(80, items.get(3).Quality); // Sulfuras always have quality 80s
	}

	private void runUpdate(List<Item> items) {
		HotelConsole console = HotelConsoleFactory.createConsole(items);
		console.UpdateQuality();
	}
}
