package com.gildedrose.service;

import com.gildedrose.domain.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CommonItemServiceTest {

    private CommonItemService commonItemService;

    @BeforeEach
    void init(){
        commonItemService = new CommonItemService();
    }

    @Test
    void decreaseQualityAndSellIn_returnsUpdatedItem_whenCommonUpdate() {
        Item item = new Item("Any item", 2, 1);
        Item updatedItem = commonItemService.update(item);

        assertThat(updatedItem.sellIn).isEqualTo(1);
        assertThat(updatedItem.quality).isEqualTo(0);
    }

    @Test
    void decreaseSellInAndQualityTwice_returnsUpdatedItem_whenPastSellIn() {
        Item item = new Item("Any item", 0, 3);
        Item updatedItem = commonItemService.update(item);

        assertThat(updatedItem.sellIn).isEqualTo(-1);
        assertThat(updatedItem.quality).isEqualTo(1);
    }

    @Test
    void dontSetNegativeQuality_returnsUpdatedItem_whenQualityIsZero() {
        Item item = new Item("Any item", 2, 0);
        Item updatedItem = commonItemService.update(item);

        assertThat(updatedItem.sellIn).isEqualTo(1);
        assertThat(updatedItem.quality).isEqualTo(0);
    }

    @Test
    void dontSetNegativeQuality_returnsUpdatedItem_whenPastSellInAndQualityIsZero() {
        Item item = new Item("Any item", 0, 1);
        Item updatedItem = commonItemService.update(item);

        assertThat(updatedItem.sellIn).isEqualTo(-1);
        assertThat(updatedItem.quality).isEqualTo(0);
    }

}
