package com.gildedrose.service;

import com.gildedrose.domain.Item;

import static com.gildedrose.appConstants.QualityConstants.MIN_QUALITY;

/**
 * Service for updating conjured items
 */
public class ConjuredItemService {

    /**
     * update an item.
     *
     * @param item the item to update.
     * @return the updated item.
     */
    public Item update(Item item) {

        item.sellIn--;

        // decrease quality of an item by 2 if its sell in is not passed and 4 otherwise
        item.quality = item.sellIn <= 0 ? item.quality - 4 : item.quality - 2;

        // The quality of an item cannot be lower than the min value
        if( item.quality < MIN_QUALITY) {
            item.quality = MIN_QUALITY;
        }
        return item;
    }
}
