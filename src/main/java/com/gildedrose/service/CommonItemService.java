package com.gildedrose.service;

import com.gildedrose.domain.Item;

import static com.gildedrose.appConstants.QualityConstants.MIN_QUALITY;

/**
 * Service for updating common items
 */
class CommonItemService {

    /**
     * update an item.
     *
     * @param item the item to update.
     * @return the updated item.
     */
    Item update(Item item) {

        item.sellIn--;

        // decrease quality of an item by 1 if its sell in is not passed and 2 otherwise
        item.quality = item.sellIn <= 0 ? item.quality - 2 : item.quality - 1;

        // The quality of an item cannot be lower than the min value
        if( item.quality < MIN_QUALITY) {
            item.quality = 0;
        }
        return item;
    }
}
