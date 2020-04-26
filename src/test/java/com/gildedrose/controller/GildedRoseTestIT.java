package com.gildedrose.controller;

import com.gildedrose.domain.Item;
import com.gildedrose.service.AgedBrieItemService;
import com.gildedrose.service.BackstageItemService;
import com.gildedrose.service.CommonItemService;
import com.gildedrose.service.SulfurasItemService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GildedRoseTestIT {


    CommonItemService commonItemService;
    AgedBrieItemService agedBrieService;
    BackstageItemService backstageItemService;
    SulfurasItemService sulfurasItemService;

    GildedRose gildedRose;

    static Item[] items;
    static Item[] resultExpected;

    @BeforeAll
    public static void init(){
        items =  new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        resultExpected =  new Item[] {
                new Item("+5 Dexterity Vest", 9, 19), //
                new Item("Aged Brie", 1, 1), //
                new Item("Elixir of the Mongoose", 4, 6), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 14, 21),
                new Item("Backstage passes to a TAFKAL80ETC concert", 9, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 2, 5) };

    }
    @BeforeEach
    public void initService() {

        commonItemService = new CommonItemService();
        agedBrieService = new AgedBrieItemService();
        backstageItemService = new BackstageItemService();
        sulfurasItemService = new SulfurasItemService();

        gildedRose = new GildedRose(commonItemService,
                                    agedBrieService,
                                    backstageItemService,
                                    sulfurasItemService,
                                    items);
    }

    @Test
    void updateAllTheList_returnsNothing_whenUpdate() {
        // GIVEN

        // WHEN
       gildedRose.updateQuality();

        // THEN
        for (int itemIndex = 0; itemIndex < items.length; itemIndex++){
            assertThat(gildedRose.items[itemIndex].sellIn).isEqualTo(resultExpected[itemIndex].sellIn);
            assertThat(gildedRose.items[itemIndex].quality).isEqualTo(resultExpected[itemIndex].quality);
        }
    }

}
