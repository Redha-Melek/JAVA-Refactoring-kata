package com.gildedrose.service;


import com.gildedrose.domain.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SulfurasItemServiceTest {

    private SulfurasItemService sulfurasItemService;

    @BeforeEach
    void init(){
        sulfurasItemService = new SulfurasItemService();
    }

    @Test // Sulfuras
    void dontDecreaseQualityAndSellIn_retursUpdatedItem_whenUpdate() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 2, 80);
        Item updatedItem = sulfurasItemService.update(item);

        assertThat(updatedItem.sellIn).isEqualTo(2);
        assertThat(updatedItem.quality).isEqualTo(80);
    }


}
