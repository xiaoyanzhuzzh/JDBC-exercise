package com.thoughtWorks.db;

import com.thoughtWorks.dao.ItemDao;
import com.thoughtWorks.vo.Item;

public class DbTest {

    public static void main(String[] args){
      ItemDao itemDao = new ItemDao();
//        Item item = new Item("ITEM000005", "娃哈哈", "瓶", 3.0);
//        itemDao.insertItem(item);

//        Item item2 = new Item("ITEM000002","苹果","斤",5.00);
//        itemDao.updateItem(item2, 4);

        System.out.println(itemDao.getItems());
        itemDao.deleteItemById(11);

    }

}
