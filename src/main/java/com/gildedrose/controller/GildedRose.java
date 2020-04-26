package com.gildedrose.controller;

import com.gildedrose.domain.Item;
import com.gildedrose.domain.ItemType;
import com.gildedrose.service.*;

public class GildedRose {

    //services
    CommonItemService commonItemService;
    AgedBrieItemService agedBrieService;
    BackstageItemService backstageItemService;
    SulfurasItemService sulfurasItemService;
    ConjuredItemService conjuredItemService;

    Item[] items;

    public GildedRose(CommonItemService commonItemService,
                      AgedBrieItemService agedBrieService,
                      BackstageItemService backstageItemService,
                      SulfurasItemService sulfurasItemService,
                      ConjuredItemService conjuredItemService,
                      Item[] items) {

        this.commonItemService = commonItemService;
        this.agedBrieService = agedBrieService;
        this.backstageItemService = backstageItemService;
        this.sulfurasItemService = sulfurasItemService;
        this.conjuredItemService = conjuredItemService;
        this.items = items;
    }

    public void updateQuality() {

        // update each item
        for (int itemIndex = 0; itemIndex < items.length; itemIndex++) {
            // get the type of the item
            ItemType itemType = ItemType.fromName(items[itemIndex].name);

            // call the corresponding service
            switch(itemType){

                case COMMON:
                    items[itemIndex] = commonItemService.update(items[itemIndex]);
                    break;
                case AGEDBRIE:
                    items[itemIndex] = agedBrieService.update(items[itemIndex]);
                    break;
                case BACKSTAGE:
                    items[itemIndex] = backstageItemService.update(items[itemIndex]);
                    break;
                case SULFURAS:
                    items[itemIndex] = sulfurasItemService.update(items[itemIndex]);
                    break;
                case CONJURED:
                    items[itemIndex] = conjuredItemService.update(items[itemIndex]);
                    break;
                default:
                    throw new UnsupportedOperationException("This should not happen");
            }
        }
    }
}