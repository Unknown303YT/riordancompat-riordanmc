package com.riverstone.unknown303.riordanlib.block.entity;

import net.minecraft.world.level.ItemLike;

import java.util.HashMap;
import java.util.List;

public class CustomCraftingRecipe {
    public static final int LINE_1 = 0;
    public static final int LINE_2 = 1;
    public static final int LINE_3 = 2;

    ItemLike result;
    List<String> rows;
    HashMap<Character, ItemLike> charToItemMap;

    public CustomCraftingRecipe(ItemLike result, List<String> rows, HashMap<Character, ItemLike> charToItem) {
        if (rows.size() >  3 || rows.isEmpty()) {
            throw new IllegalArgumentException("Rows must have 1-3 rows, got " + rows.size());}
        this.result = result;
        this.rows = rows;
        this.charToItemMap = charToItem;
    }

    public ItemLike getResult() {
        return result;
    }

    public List<String> getRows() {
        return rows;
    }

    public HashMap<Character, ItemLike> getCharToItem() {
        return charToItemMap;
    }

    public String getLine(int line) {
        if (rows.size() == 1) {
            return rows.get(0);
        } else if (rows.size() == 2) {
            if (line == LINE_1) {
                return rows.get(line);
            } else if (line == LINE_2) {
                return rows.get(line);
            }
        } else if (rows.size() == 3) {
            if (line == LINE_1) {
                return rows.get(line);
            } else if (line == LINE_2) {
                return rows.get(line);
            } else if (line == LINE_3) {
                return rows.get(line);
            }
        }
        throw new IllegalArgumentException("Error: parameter 'line' must be equal to 1, 2, or 3, got" + line);
    }
}
