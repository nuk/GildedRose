package gildedrose.console;

import java.util.List;

public class HotelConsole {

	private List<Item> items;
	
	public HotelConsole(List<Item> Items) {
		this.items = Items;
	}
	
	public void fixQuality(Item item){
			if(item.Quality < 0){
				item.Quality = 0;
			}
			if(!item.Name.equals("Sulfuras, Hand of Ragnaros")){
				if(item.Quality > 50){
					item.Quality = 50;
				}
			}else{
				item.Quality = 80;
			}
	}
	
	public void updateItemSellIn(Item item) {
		item.SellIn -=1;
	}
	
	public void updateItemQuality(Item item){
		if (item.Quality > 0){
			item.Quality -= (item.SellIn>0) ? 1:2;
		}
	}
	
	public void updateAgedItemQuality(Item item){
		if (item.Quality < 50){
			item.Quality += 1;
		}
		if (item.Quality < 50 && item.SellIn <=0){
			item.Quality += 1;
		}
	}
	
	public void updateEventTicketQuality(Item item){
		if (item.SellIn > 10){
			item.Quality +=1;
		}else if(item.SellIn > 5){
			item.Quality += 2;
		}else if(item.SellIn > 0){
			item.Quality +=3;
		}else{
			item.Quality =0;
		}
	} 
	
	public boolean isAgedItem(Item item){
		if (item.Name.equals("Aged Brie")){
			return true;
		}
		return false;
	}
	
	public boolean isEventTicket(Item item){
		if (item.Name.equals("Backstage passes to a TAFKAL80ETC concert")){
			return true;
		}
		return false;
	}	
	
	public boolean isLegendaryItem(Item item){
		if (item.Name.equals("Sulfuras, Hand of Ragnaros")){
			return true;
		}
		return false;
	}

    public void UpdateQuality()
    {
        for (int i = 0; i < items.size(); i++)
        {
        	Item item = items.get(i);
        	if (!isLegendaryItem(item)){
        		if (isAgedItem(item)){
        			updateAgedItemQuality(item);
        		}else if (isEventTicket(item)){
        			updateEventTicketQuality(item);
        		}else{
        			updateItemQuality(item);
        		}
        		updateItemSellIn(item);
        	}
        	fixQuality(item); 
        }
    }

	
}

