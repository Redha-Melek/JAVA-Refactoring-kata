package com.gildedrose.domain;

public enum ItemType {
    COMMON,
    AGEDBRIE,
    BACKSTAGE,
    SULFURAS,
    CONJURED;

    public static ItemType fromName(String name) {
        switch (name) {
            case "Aged Brie":
                return AGEDBRIE;
            case "Backstage passes to a TAFKAL80ETC concert":
                return BACKSTAGE;
            case "Sulfuras, Hand of Ragnaros":
                return SULFURAS;
            case "Conjured Mana Cake":
                return CONJURED;
            default:
                return COMMON;
        }
    }
}
