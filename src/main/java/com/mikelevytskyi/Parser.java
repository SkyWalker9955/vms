package com.mikelevytskyi;

public class Parser {
    private ItemsList items;
    private Config config;

    //--------------------------

    public Parser() {
    }

    public Parser(ItemsList items, Config config) {
        this.items = items;
        this.config = config;
    }

    public ItemsList getItems() {
        return items;
    }

    public void setItems(ItemsList items) {
        this.items = items;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }
}
