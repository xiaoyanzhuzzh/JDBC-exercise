package com.thoughtWorks.posProject;

import com.thoughtWorks.dao.ItemDao;
import com.thoughtWorks.vo.Item;

public class DbTest {

    public static void main(String[] args){
      ItemDao itemDao = new ItemDao();
        Item item = new Item("ITEM000002","方便面","袋",2.5);
        itemDao.insertItem(item);

        Item item2 = new Item("ITEM000002","苹果","斤",5.00);
        itemDao.updateItem(item2);
        itemDao.getItem();

        itemDao.deleteItemByBarcode("ITEM000002");
    }

}
