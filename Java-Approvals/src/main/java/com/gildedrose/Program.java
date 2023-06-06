package com.gildedrose;

public class Program {

	public static void main(String... args) {
		System.out.println("OMGHAI!");

		GildeRoseItem[] items = new GildeRoseItem[] {
				GildeRoseItem.createGildeItem("+5 Dexterity Vest", 10, 20),
				GildeRoseItem.createGildeItem(GildeRoseItem.AGED_BRIE, 2, 0),
				GildeRoseItem.createGildeItem("Elixir of the Mongoose", 5, 7),
				GildeRoseItem.createGildeItem(GildeRoseItem.SULFURAS_HAND_OF_RAGNAROS, 0, 80),
				GildeRoseItem.createGildeItem(GildeRoseItem.SULFURAS_HAND_OF_RAGNAROS, -1, 80),
				GildeRoseItem.createGildeItem(GildeRoseItem.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, 15, 20),
				GildeRoseItem.createGildeItem(GildeRoseItem.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, 10, 49),
				GildeRoseItem.createGildeItem(GildeRoseItem.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, 5, 49),
				// this conjured GildeRoseItem.createGildeRoseTiem does not work properly yet
				GildeRoseItem.createGildeItem("Conjured Mana Cake", 3, 6) };

		GildedRose app = new GildedRose(items);

		for (int i = 0; i < 31; i++) {
			System.out.println("-------- day " + i + " --------");
			System.out.println("name, sellIn, quality");
			for (int j = 0; j < items.length; j++) {
				System.out.println(items[j]);
			}
			System.out.println("");
			app.updateQuality();
		}
	}
}
