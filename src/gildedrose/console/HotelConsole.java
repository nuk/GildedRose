package gildedrose.console;

import java.util.List;

public class HotelConsole {

	private List<Item> Items;
	
	public HotelConsole(List<Item> Items) {
		this.Items = Items;
	}

	public List<Item> Items(){return Items;}
	
    public void UpdateQuality()
    {
        for (int i = 0; i < Items.size(); i++)
        {
            if (Items.get(i).Name != "Aged Brie" && Items.get(i).Name != "Backstage passes to a TAFKAL80ETC concert")
            {
                if (Items.get(i).Quality > 0)
                {
                    if (Items.get(i).Name != "Sulfuras, Hand of Ragnaros")
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

                    if (Items.get(i).Name == "Backstage passes to a TAFKAL80ETC concert")
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

            if (Items.get(i).Name != "Sulfuras, Hand of Ragnaros")
            {
                Items.get(i).SellIn = Items.get(i).SellIn - 1;
            }

            if (Items.get(i).SellIn < 0)
            {
                if (Items.get(i).Name != "Aged Brie")
                {
                    if (Items.get(i).Name != "Backstage passes to a TAFKAL80ETC concert")
                    {
                        if (Items.get(i).Quality > 0)
                        {
                            if (Items.get(i).Name != "Sulfuras, Hand of Ragnaros")
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
    }
}

