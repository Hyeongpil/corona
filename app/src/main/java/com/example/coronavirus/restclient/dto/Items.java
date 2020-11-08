package com.example.coronavirus.restclient.dto;

public class Items
{
    private Item[] item;

    public Item[] getItem ()
    {
        return item;
    }

    public void setItem (Item[] item)
    {
        this.item = item;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [item = "+item+"]";
    }
}
