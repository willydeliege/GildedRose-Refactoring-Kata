package com.gildedrose;

import org.approvaltests.Approvals;
import org.approvaltests.combinations.CombinationApprovals;
import org.approvaltests.legacycode.Range;
import org.approvaltests.reporters.DiffReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

import java.awt.font.NumericShaper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@UseReporter(DiffReporter.class)
public class GildedRoseApprovalTest {

    @Test
    public void foo() {

        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        Approvals.verifyAll("Items", items);
    }

    @Test
    public void thirtyDays() {

        ByteArrayOutputStream fakeOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(fakeOutput));
        System.setIn(new ByteArrayInputStream("a\n".getBytes()));

        Program.main();
        String output = fakeOutput.toString();

        Approvals.verify(output);
    }

    @Test
    public void testAllCases() {
        String[] names = {"Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"};
        Integer[] qualities = Range.get(1, 50);
        Integer[] sellins = Range.get(-1, 50);
        CombinationApprovals.verifyAllCombinations(this::updateItem, names, qualities, sellins);
    }

    private Item updateItem(String name, Integer quality, Integer sellins) {
        Item[] items = new Item[]{new Item(name, sellins, quality)};
        GildedRose gr = new GildedRose(items);
        gr.updateQuality();
        return items[0];
    }
}

