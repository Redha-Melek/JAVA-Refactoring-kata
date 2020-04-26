package com.gildedrose.service;


import com.gildedrose.domain.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AgedBrieItemServiceTest {

    private AgedBrieItemService agedBrieItemService;

    @BeforeEach
    void init(){
        agedBrieItemService = new AgedBrieItemService();
    }

    @Test
    void increaseQuality_returnsUpdatedItem_whenUpdate() {
        Item item = new Item("Age Brie", 2, 20);
        Item updatedItem = agedBrieItemService.update(item);

        assertThat(updatedItem.sellIn).isEqualTo(1);
        assertThat(updatedItem.quality).isEqualTo(21);
    }

    @Test
    void increaseQuality_returnsUpdatedItem_whenPastSellIn() {
        Item item = new Item("Age Brie", -1, 20);
        Item updatedItem = agedBrieItemService.update(item);

        assertThat(updatedItem.sellIn).isEqualTo(-2);
        assertThat(updatedItem.quality).isEqualTo(21);
    }

    @Test // Age Brie
    void dontIncreaseQuality_returnsUpdatedItem_whenQualityIs50() {
        Item item = new Item("Aged Brie", 2, 50);
        Item updatedItem = agedBrieItemService.update(item);

        assertThat(updatedItem.sellIn).isEqualTo(1);
        assertThat(updatedItem.quality).isEqualTo(50);
    }

}
