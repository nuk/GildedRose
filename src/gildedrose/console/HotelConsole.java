
package gildedrose.console;

import java.util.List;

public class HotelConsole
{

	private List<Item>	Items;

	public HotelConsole( List<Item> Items )
	{
		this.Items = Items;
	}

	public void UpdateQuality( )
	{
		for ( Item item : Items )
		{

			if ( item.Name.equals( "Sulfuras, Hand of Ragnaros" ) )
				continue;

			if ( !item.Name.equals("Aged Brie") && !item.Name.equals("Backstage passes to a TAFKAL80ETC concert") )
			{
				if ( item.Quality > 0 )
				{
					decrementItemQuality( item );
				}
			}
			else
			{
				if ( item.Quality < 50 )
				{
					incrementItemQuality( item );

					updateBackStagePassesQuality( item );
				}
			}

			updateItemSellIn( item );

			if ( item.SellIn < 0 )
			{
				if ( item.Name.equals("Backstage passes to a TAFKAL80incrementItemQualityETC concert" ))
				{
					item.Quality = 0;
					continue;
				} 
			
				if ( !item.Name.equals("Aged Brie") )
				{
					
					if ( item.Quality > 0 )
					{
						decrementItemQuality( item );
					}
					
				}
				else
				{
					if ( item.Quality < 50 )
					{
						incrementItemQuality( item );
					}
				}
			}
		}
	}

	private void updateBackStagePassesQuality( Item item )
	{
		if ( item.Name.equals("Backstage passes to a TAFKAL80ETC concert") )
		{
			if ( item.SellIn < 11 )
			{
				if ( item.Quality < 50 )
				{
					incrementItemQuality( item );
				}
			}

			if ( item.SellIn < 6 )
			{
				if ( item.Quality < 50 )
				{
					incrementItemQuality( item );
				}
			}
		}
	}

	private void incrementItemQuality( Item item )
	{
		item.Quality++;
	}

	private void updateItemSellIn( Item item )
	{
		item.SellIn--;
	}

	private void decrementItemQuality( Item item )
	{
		item.Quality--;
	}
}
