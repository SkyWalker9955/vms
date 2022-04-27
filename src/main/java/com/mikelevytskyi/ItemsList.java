package com.mikelevytskyi;

import java.util.ArrayList;
import java.util.List;

public class ItemsList {

    private List<Item> itemsList = new ArrayList<>();

    public ItemsList() {
        this.itemsList = new ArrayList<Item>();
    }

    public ItemsList(List<Item> itemsList) {
        this.itemsList = itemsList;
    }

    public List<Item> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Item> itemsList) {
        this.itemsList = itemsList;
    }
}
