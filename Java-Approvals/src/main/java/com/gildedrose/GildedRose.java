package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    private final GildeRoseItem[] items;

    public GildedRose(GildeRoseItem[] items) {
        if (items == null) {
            this.items =  new GildeRoseItem[]{};
        } else {
            this.items = Arrays.copyOf(items,items.length);
        }
    }

    public void updateQuality() {
        for (GildeRoseItem item : items) {
            item.updateQuality();
        }
    }

}
