package com.gildedrose.service;


import com.gildedrose.domain.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BackstageItemServiceTest {

    BackstageItemService backstageItemService;

    @BeforeEach
    public void init(){
        backstageItemService = new BackstageItemService();
    }


    @Test
    public void increaseQuality_returnsUpdatedItem_whenUpdate() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 30);
        Item updatedItem = backstageItemService.update(item);

        assertThat(updatedItem.sellIn).isEqualTo(14);
        assertThat(updatedItem.quality).isEqualTo(31);
    }

    @Test
    public void dontIncreaseQuality_returnsUpdatedItem_whenQualityIs50() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 2, 50);
        Item updatedItem = backstageItemService.update(item);

        assertThat(updatedItem.sellIn).isEqualTo(1);
        assertThat(updatedItem.quality).isEqualTo(50);
    }

    @Test
    public void increaseQualityTwice_returnsUpdatedItem_whenSellInIsEqualOrLessThan10() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 9, 20);
        Item updatedItem = backstageItemService.update(item);

        assertThat(updatedItem.sellIn).isEqualTo(8);
        assertThat(updatedItem.quality).isEqualTo(22);
    }

    @Test
    public void increaseQualityByThree_returnsUpdatedItem_whenSellInIsEqualOrLessThan5() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 3, 20);
        Item updatedItem = backstageItemService.update(item);

        assertThat(updatedItem.sellIn).isEqualTo(2);
        assertThat(updatedItem.quality).isEqualTo(23);
    }

    @Test
    public void setQualityToZero_returnsUpdatedItem_whenPastSellIn() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        Item updatedItem = backstageItemService.update(item);

        assertThat(updatedItem.sellIn).isEqualTo(-1);
        assertThat(updatedItem.quality).isEqualTo(0);
    }


}
