package com.gildedrose;

import com.gildedrose.model.GildeRoseItem;
import org.approvaltests.Approvals;
import org.approvaltests.combinations.CombinationApprovals;
import org.approvaltests.legacycode.Range;
import org.approvaltests.reporters.DiffReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@UseReporter(DiffReporter.class)
public class GildedRoseApprovalTest {

    @Test
    public void foo() {

        GildeRoseItem[] items = new GildeRoseItem[]{ GildeRoseItem.createGildeItem("foo", 0, 0)};
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
        String[] names = {GildeRoseItem.AGED_BRIE, GildeRoseItem.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, GildeRoseItem.SULFURAS_HAND_OF_RAGNAROS};
        Integer[] qualities = Range.get(1, 50);
        Integer[] sellins = Range.get(-1, 50);
        CombinationApprovals.verifyAllCombinations(this::updateItem, names, qualities, sellins);
    }

    private GildeRoseItem updateItem(String name, Integer quality, Integer sellins) {
        GildeRoseItem[] items = new GildeRoseItem[]{GildeRoseItem.createGildeItem(name, sellins, name.equals(GildeRoseItem.SULFURAS_HAND_OF_RAGNAROS) ? 80 : quality)};
        GildedRose gr = new GildedRose(items);
        gr.updateQuality();
        return items[0];
    }
}

