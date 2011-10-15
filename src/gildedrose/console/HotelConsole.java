package gildedrose.console;

import java.util.List;

public class HotelConsole {

	private List<Item> Items;
	
	public HotelConsole(List<Item> Items) {
		this.Items = Items;
	}

    public void UpdateQuality()
    {
    	for( Item item : Items )
        {
            if (item.Name != "Aged Brie" && item.Name != "Backstage passes to a TAFKAL80ETC concert")
            {
                if (item.Quality > 0)
                {
                    if (item.Name != "Sulfuras, Hand of Ragnaros")
                    {
                        decrementItemQuality( item );
                    }
                }
            }
            else
            {
                if (item.Quality < 50)
                {
                    incrementItemQuality( item );

                    updateBackStagePassesQuality( item );
                }
            }

            updateItemSellIn( item );

            if (item.SellIn < 0)
            {
                if (item.Name != "Aged Brie")
                {
                    if (item.Name != "Backstage passes to a TAFKAL80ETC concert")
                    {
                        if (item.Quality > 0)
                        {
                            if (item.Name != "Sulfuras, Hand of Ragnaros")
                            {
                                decrementItemQuality( item );
                            }
                        }
                    }
                    else
                    {
                        item.Quality = item.Quality - item.Quality;
                    }
                }
                else
                {
                    if (item.Quality < 50)
                    {
                        incrementItemQuality( item );
                    }
                }
            }
        }
    }

	private void updateBackStagePassesQuality( Item item )
	{
		if (item.Name == "Backstage passes to a TAFKAL80ETC concert")
		{
		    if (item.SellIn < 11)
		    {
		        if (item.Quality < 50)
		        {
		            incrementItemQuality( item );
		        }
		    }

		    if (item.SellIn < 6)
		    {
		        if (item.Quality < 50)
		        {
		            incrementItemQuality( item );
		        }
		    }
		}
	}

	private void incrementItemQuality( Item item )
	{
		item.Quality = item.Quality + 1;
	}

	private void updateItemSellIn( Item item )
	{
		if (item.Name != "Sulfuras, Hand of Ragnaros")
		{
		    item.SellIn --;
		}
	}

	private void decrementItemQuality( Item item )
	{
		item.Quality --;
	}
}

