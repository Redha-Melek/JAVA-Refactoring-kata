package com.gildedrose.controller;

import com.gildedrose.domain.Item;
import com.gildedrose.service.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GildedRoseTest {

    @Mock
    CommonItemService commonItemService;
    @Mock
    AgedBrieItemService agedBrieService;
    @Mock
    BackstageItemService backstageItemService;
    @Mock
    SulfurasItemService sulfurasItemService;
    @Mock
    ConjuredItemService conjuredItemService;

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
                new Item("Conjured Mana Cake", 2, 4) };

    }
    @BeforeEach
    public void initService() {

        gildedRose = new GildedRose(commonItemService,
                                    agedBrieService,
                                    backstageItemService,
                                    sulfurasItemService,
                                    conjuredItemService,
                                    items);
    }

    @Test
    void updateAllTheList_returnsNothing_whenUpdate() {
        // GIVEN
        when(commonItemService.update(items[0]))
                .thenReturn(resultExpected[0]);
        when(agedBrieService.update(items[1]))
                .thenReturn(resultExpected[1]);
        when(commonItemService.update(items[2]))
                .thenReturn(resultExpected[2]);
        when(sulfurasItemService.update(items[3]))
                .thenReturn(resultExpected[3]);
        when(sulfurasItemService.update(items[4]))
                .thenReturn(resultExpected[4]);
        when(backstageItemService.update(items[5]))
                .thenReturn(resultExpected[5]);
        when(backstageItemService.update(items[6]))
                .thenReturn(resultExpected[6]);
        when(backstageItemService.update(items[7]))
                .thenReturn(resultExpected[7]);
        when(conjuredItemService.update(items[8]))
                .thenReturn(resultExpected[8]);

        // WHEN
       gildedRose.updateQuality();

        // THEN
        for (int itemIndex = 0; itemIndex < items.length; itemIndex++){
            assertThat(gildedRose.items[itemIndex].sellIn).isEqualTo(resultExpected[itemIndex].sellIn);
            assertThat(gildedRose.items[itemIndex].quality).isEqualTo(resultExpected[itemIndex].quality);
        }
    }

}
