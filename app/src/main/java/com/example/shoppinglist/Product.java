package com.example.shoppinglist;

public class Product {
    private final String name;
    private final int amount;

    public Product(String name, int amount)
    {
        this.name = name;
        this.amount = amount;
    }

    public String getName()
    {
        return this.name;
    }

    public int getAmount()
    {
        return this.amount;
    }
}
