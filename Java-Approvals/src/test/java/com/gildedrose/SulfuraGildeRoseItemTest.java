package com.gildedrose;

import com.gildedrose.model.GildeRoseItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SulfuraGildeRoseItemTest {

    @Test
    public void hasQuality80(){
        GildeRoseItem gildeRoseItem = GildeRoseItem.createGildeItem(GildeRoseItem.SULFURAS_HAND_OF_RAGNAROS, 1, 80);
        GildedRose app = new GildedRose(new GildeRoseItem[]{gildeRoseItem});
        app.updateQuality();
        Assertions.assertEquals(80,gildeRoseItem.getQuality());
    }

    @Test void HasQualityDifferentThan80(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            GildeRoseItem.createGildeItem(GildeRoseItem.SULFURAS_HAND_OF_RAGNAROS, 1, 0);
        });
        assertEquals("Sulfura's quality must always be 80", illegalArgumentException.getMessage());
    }
}
