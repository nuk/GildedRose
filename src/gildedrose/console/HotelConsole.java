package gildedrose.console;

import java.util.List;

public class HotelConsole {

	private List<Item> Items;
	
	public HotelConsole(List<Item> Items) {
		this.Items = Items;
	}
	
	public void fixNegativeQuality(List<Item> items){
		for(Item item: items){
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
	}

    public void UpdateQuality()
    {
        for (int i = 0; i < Items.size(); i++)
        {
            if (!Items.get(i).Name.equals("Aged Brie") && !Items.get(i).Name.equals("Backstage passes to a TAFKAL80ETC concert"))
            {
                if (Items.get(i).Quality > 0)
                {
                    if (!Items.get(i).Name.equals("Sulfuras, Hand of Ragnaros"))
                    {
                        Items.get(i).Quality = Items.get(i).Quality - 1;
                    }
                }
            }
            else
            {
                if (Items.get(i).Quality < 50)
                {
                    Items.get(i).Quality = Items.get(i).Quality + 1;

                    if (Items.get(i).Name.equals("Backstage passes to a TAFKAL80ETC concert"))
                    {
                        if (Items.get(i).SellIn < 11)
                        {
                            if (Items.get(i).Quality < 50)
                            {
                                Items.get(i).Quality = Items.get(i).Quality + 1;
                            }
                        }

                        if (Items.get(i).SellIn < 6)
                        {
                            if (Items.get(i).Quality < 50)
                            {
                                Items.get(i).Quality = Items.get(i).Quality + 1;
                            }
                        }
                    }
                }
            }

            if (!Items.get(i).Name.equals("Sulfuras, Hand of Ragnaros"))
            {
                Items.get(i).SellIn = Items.get(i).SellIn - 1;
            }

            if (Items.get(i).SellIn < 0)
            {
                if (!Items.get(i).Name.equals("Aged Brie"))
                {
                    if (!Items.get(i).Name.equals("Backstage passes to a TAFKAL80ETC concert"))
                    {
                        if (Items.get(i).Quality > 0)
                        {
                            if (!Items.get(i).Name.equals("Sulfuras, Hand of Ragnaros"))
                            {
                                Items.get(i).Quality = Items.get(i).Quality - 1;
                            }
                        }
                    }
                    else
                    {
                        Items.get(i).Quality = Items.get(i).Quality - Items.get(i).Quality;
                    }
                }
                else
                {
                    if (Items.get(i).Quality < 50)
                    {
                        Items.get(i).Quality = Items.get(i).Quality + 1;
                    }
                }
            }
        }
        fixNegativeQuality(Items);
    }
}

