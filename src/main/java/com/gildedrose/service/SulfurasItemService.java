package com.gildedrose.service;

import com.gildedrose.domain.Item;

import static com.gildedrose.appConstants.QualityConstants.SULFURAS_QUALITY;
import static com.gildedrose.appConstants.SellInConstants.SULFURAS_SELLIN;

/**
 * Service for updating sulfuras items
 */
public class SulfurasItemService {
    public Item update(Item item) {
        // the quantity must alwats equal SULFURAS_QUALITY(80)
        item.quality = item.quality == SULFURAS_QUALITY ? item.quality : SULFURAS_QUALITY;
        // sell in must always equal SULFURAS_SELLIN(0)
        item.sellIn = item.sellIn == SULFURAS_SELLIN ? item.sellIn : SULFURAS_SELLIN;

        return item;
    }
}
