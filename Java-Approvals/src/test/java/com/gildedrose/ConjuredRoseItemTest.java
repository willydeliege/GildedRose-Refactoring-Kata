package com.gildedrose;

import com.gildedrose.model.ConjuredGildeRoseItem;
import com.gildedrose.model.GildeRoseItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConjuredRoseItemTest {

    @Test
    public void createConjuredItem(){
        GildeRoseItem gildeRoseItem = GildeRoseItem.createGildeItem(GildeRoseItem.CONJURED, 1, 40);
        Assertions.assertTrue(gildeRoseItem instanceof ConjuredGildeRoseItem);
    }
    @Test
    public void hasQualityDecreaseTwiceFaster(){
        GildeRoseItem gildeRoseItem = GildeRoseItem.createGildeItem(GildeRoseItem.CONJURED, 1, 40);
        GildedRose app = new GildedRose(new GildeRoseItem[]{gildeRoseItem});
        app.updateQuality();
        Assertions.assertEquals(38,gildeRoseItem.getQuality());
    }

}
