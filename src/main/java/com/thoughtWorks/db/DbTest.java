package com.thoughtWorks.db;

import com.thoughtWorks.dao.ItemDao;
import com.thoughtWorks.vo.Item;

public class DbTest {

    public static void main(String[] args){
      ItemDao itemDao = new ItemDao();
      System.out.println(itemDao.getItemById(2));
//        Item item = new Item(null,"ITEM000009", "香蕉", "斤", 4.5);
//        itemDao.insertItem(item);

//        Item item2 = new Item("4","ITEM000001","葡萄","斤",6.5);
//        itemDao.updateItem(item2);

        System.out.println(itemDao.getItems());
        itemDao.deleteItemById(2);

    }

}
