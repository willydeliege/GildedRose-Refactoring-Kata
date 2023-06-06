package com.gildedrose.model;

public class GildeRoseItem {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static  final String CONJURED = "Conjured";

    private final Item item;

    protected GildeRoseItem(String name, int sellin, int quality) {
        this.item = new Item(name,sellin,quality);
    }

    public static GildeRoseItem createGildeItem(String name, int sellin, int quality) {

        switch (name) {
                case AGED_BRIE:
                    return new AgedBrieGildeRoseItem(name,sellin,quality);
                case BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                    return new BackStagePassGilleRoseItem(name,sellin,quality) ;

                case SULFURAS_HAND_OF_RAGNAROS:
                    return new SulfuraGildeRoseItem(name,sellin,quality);
            case CONJURED:
                return new ConjuredGildeRoseItem(name,sellin,quality);
            default:
                return new GildeRoseItem(name, sellin, quality);
        }
    }


    public int getQuality() {
        return item.quality;
    }

    public void setQuality(int quality) {
        item.quality = quality;
    }

    public int getSellin() {
        return item.sellIn;
    }

    public String toString() {
        return item.toString();
    }

    public void updateQuality() {
        if (item.quality > 0) {
            decreaseQuality();
        }

        decreaseSellin();

        if (item.sellIn < 0) {
            if (item.quality > 0) {
                decreaseQuality();
            }
        }
    }

    public void decreaseSellin() {
        item.sellIn = item.sellIn - 1;
    }

    public void decreaseQuality() {
        item.quality = item.quality - 1;
    }

    protected void increaseQuality() {

        item.quality = item.quality + 1;
    }
}
