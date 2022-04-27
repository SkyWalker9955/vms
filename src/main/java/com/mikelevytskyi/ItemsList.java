package com.mikelevytskyi;

import java.util.ArrayList;
import java.util.List;

public class ItemsList {

    //data fields
    private List<Item> items = new ArrayList<Item>();
    //--------------

    public ItemsList() {
        this.items = new ArrayList<Item>();
    }

    public ItemsList(List<Item> itemsList) {
        this.items = itemsList;
    }

    public List<Item> getItemsList() {
        return items;
    }

    public void setItemsList(List<Item> itemsList) {
        this.items = itemsList;
    }
}
