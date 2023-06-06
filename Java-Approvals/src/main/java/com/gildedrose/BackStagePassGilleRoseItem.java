package com.gildedrose;

public class BackStagePassGilleRoseItem extends GildeRoseItem {
    protected BackStagePassGilleRoseItem(String name, int sellin, int quantity) {
        super(name, sellin, quantity);
    }

    @Override
    public void updateQuality() {
        if (super.getQuality() < 50) {
            super.increaseQuality();
            if (super.getSellin() < 11) {
                if (super.getQuality() < 50) {
                    super.increaseQuality();
                }
            }

            if (super.getSellin() < 6) {
                if (super.getQuality() < 50) {
                    super.increaseQuality();
                }
            }
        }
        super.decreaseSellin();

        if (super.getSellin() < 0) {
            super.setQuality(0);
        }
    }
}
