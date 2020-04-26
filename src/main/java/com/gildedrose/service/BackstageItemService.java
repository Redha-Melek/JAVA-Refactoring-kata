package com.gildedrose.service;

import com.gildedrose.domain.Item;

import static com.gildedrose.appConstants.QualityConstants.MAX_QUALITY;

/**
 * Service for updating backstage passes items
 */
public class BackstageItemService {
    public Item update(Item item) {

        if (item.sellIn <= 0) {
            item.quality = 0;
        } else if (item.sellIn <= 5) {
            item.quality += 3;
        } else if(item.sellIn <= 10) {
            item.quality += 2;
        } else {
            item.quality ++;
        }
        // The quality of an item cannot be greater than the max value
        if( item.quality > MAX_QUALITY) {
            item.quality = MAX_QUALITY;
        }

        item.sellIn--;

    return item;
    }

}
