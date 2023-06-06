package com.gildedrose.model;

public class SulfuraGildeRoseItem extends GildeRoseItem {

    public SulfuraGildeRoseItem(String name, int sellin, int quality) {
        super(name,sellin,quality);
        if (quality!=80){
            throw new IllegalArgumentException("Sulfura's quality must always be 80");
        }
    }
    @Override
    public void updateQuality() {
//        System.out.println("SulfuraGildeRoseItem.updateQuality");
    }
}
