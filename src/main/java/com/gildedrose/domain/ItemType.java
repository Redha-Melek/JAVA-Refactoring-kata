package com.gildedrose.domain;

public enum ItemType {
    COMMON,
    AGEDBRIE,
    BACKSTAGE,
    SULFURAS;

    public static ItemType fromName(String name) {
        switch (name) {
            case "Aged Brie":
                return AGEDBRIE;
            case "Backstage passes to a TAFKAL80ETC concert":
                return BACKSTAGE;
            case "Sulfuras, Hand of Ragnaros":
                return SULFURAS;
            default:
                return COMMON;
        }
    }
}
