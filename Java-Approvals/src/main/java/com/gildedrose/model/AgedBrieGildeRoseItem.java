package com.gildedrose.model;

class AgedBrieGildeRoseItem extends GildeRoseItem {

    public static final int QUALITY_MAX = 50;

    protected AgedBrieGildeRoseItem(String name, int sellin, int quantity) {
        super(name, sellin, quantity);
    }

    @Override
    public void updateQuality() {
        if (super.getQuality() < 50) {
            super.setQuality(super.getQuality() + 1);

        }
        super.decreaseSellin();

        if (super.getSellin() < 0) {
            if (super.getQuality() < 50) {
                super.setQuality(super.getQuality() + 1);
            }
        }
    }
}
