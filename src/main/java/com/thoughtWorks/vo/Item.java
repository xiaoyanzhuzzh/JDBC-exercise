package com.thoughtWorks.vo;

import java.util.ArrayList;
import java.util.List;

//ORM(Object relation mapping)
public class Item {
    private String id;
    private String barcode;
    private String name;
    private String unit;
    private double price;

    private List<Promotion> promotionList = new ArrayList<Promotion>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Item(){

    }

    public Item(String id, String barcode, String name, String unit, double price) {
        this.id = id;
        this.barcode = barcode;
        this.name = name;
        this.unit = unit;
        this.price = price;
    }

    public Item(String id, String barcode, String name, String unit, double price, List<Promotion> promotionList) {
        this.id = id;
        this.barcode = barcode;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.promotionList = promotionList;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", barcode='" + barcode + '\'' +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                '}';
    }
}
