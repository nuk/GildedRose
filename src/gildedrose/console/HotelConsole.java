package gildedrose.console;

import java.util.List;

public class HotelConsole {

	private List<Item> Items;
	
	public HotelConsole(List<Item> Items) {
		this.Items = Items;
	}

    public void UpdateQuality()
    {
        for (int i = 0; i < Items.size(); i++)
        {
            if (Items.get(i).Name != "Aged Brie" && Items.get(i).Name != "Backstage passes to a TAFKAL80ETC concert")
            {// Se não for queijo e se não for passe
                if (Items.get(i).Quality > 0)
                {
                    if (Items.get(i).Name != "Sulfuras, Hand of Ragnaros")
                    {//vale pro resto
                        Items.get(i).Quality = Items.get(i).Quality - 1;
                    }
                }
            }
            else
            {//se for queijo ou passe
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
            {//vale pro resto menos Sulfuras
                Items.get(i).SellIn = Items.get(i).SellIn - 1;
            }

            if (Items.get(i).SellIn < 0)
            {//validade acabou
                if (Items.get(i).Name != "Aged Brie")
                {
                    if (Items.get(i).Name != "Backstage passes to a TAFKAL80ETC concert")
                    {
                        if (Items.get(i).Quality > 0)
                        {
                            if (Items.get(i).Name != "Sulfuras, Hand of Ragnaros")
                            {
                                Items.get(i).Quality--;
                            }
                        }
                    }//2° if
                    else
                    {//nao acontece com queijo
                        Items.get(i).Quality = 0;
                    }
                }//1° if
                else
                {
                    if (Items.get(i).Quality < 50)
                    {
                        Items.get(i).Quality++;
                    }
                }
            }
        }
    }
}

