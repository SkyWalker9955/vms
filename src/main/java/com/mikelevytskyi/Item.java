package com.mikelevytskyi;

public class Item {

    //data fields
    private String name;
    private int amount;
    private String price;

    public Item() {

    }

    //constructors
    public Item (String name, int amount, String price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    //methods
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public int getAmount() {
        return amount;
    }
}
