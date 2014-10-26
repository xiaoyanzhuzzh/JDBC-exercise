package com.thoughtWorks.dao;

import com.thoughtWorks.vo.Item;

import java.util.List;

public interface ItemDao {
    Item getItemById(int id);
    List<Item> getItems();
    void insertItem(Item item);
    void deleteItemById(int id);
    void updateItem(Item item);
}
