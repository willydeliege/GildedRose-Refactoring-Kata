package com.gildedrose;

public class ConjuredGildeRoseItem extends GildeRoseItem {
    protected ConjuredGildeRoseItem(String name, int sellin, int quality) {
        super(name, sellin, quality);
    }

    @Override
    public void updateQuality() {
        super.updateQuality();
        super.decreaseQuality();
    }
}
