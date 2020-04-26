package com.gildedrose.service;

import com.gildedrose.domain.Item;

import static com.gildedrose.appConstants.QualityConstants.MAX_QUALITY;

/**
 * Service for updating aged brie items
 */
public class AgedBrieItemService {

    /**
     * update an item.
     *
     * @param item the item to update.
     * @return the updated item.
     */
    public Item update(Item item) {

        item.sellIn--;
        // The quality of an item cannot be greater than the max value
        if( item.quality < MAX_QUALITY) {
            item.quality++;
        }
        return item;
    }
}
