package com.thoughtWorks.dao;

import com.thoughtWorks.util.DbUtil;
import com.thoughtWorks.vo.Item;

import java.beans.*;
import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemDao {
    private DbUtil dbUtil = new DbUtil();

    public Item getItemById(int id) {
        Item item = null;
        String sql = "SELECT * FROM items WHERE id = '"+id+"'";
        Connection connection = dbUtil.getConnection();
        Statement statement = null;
        ResultSet rs = null;

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            rs.next();

            item = new Item(rs.getString("barcode"), rs.getString("name"), rs.getString("unit"), rs.getDouble("price"));

            rs.close();
            statement.close();
            dbUtil.closeConnection();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    public List<Item> getItems(){
        List<Item> items = new ArrayList<Item>();
        String sql = "SELECT * FROM items";
        Connection connection = dbUtil.getConnection();
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while(rs.next()){
                items.add(new Item(rs.getString("barcode"),
                        rs.getString("name"),
                        rs.getString("unit"),
                        rs.getDouble("price")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public void insertItem(Item item){

        String sql = "insert into items values(null, '"+item.getBarcode()+
                "','"+item.getName()+"','"+item.getUnit()+"', "+item.getPrice()+")";
        Connection connection = dbUtil.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            int result = statement.executeUpdate(sql);
            if(result > 0){
                System.out.println("插入成功");
            }
            else{
                System.out.println("插入失败");
            }
            statement.close();
            dbUtil.closeConnection();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteItemById(int id){
        String sql = "delete from items where id = '"+id+"'";
        Connection connection = dbUtil.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            int result = statement.executeUpdate(sql);
            if(result > 0){
                System.out.println("删除成功");
            }
            else{
                System.out.println("删除失败");
            }
            statement.close();
            dbUtil.closeConnection();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateItem(Item item){

        String sql = "update items set name = '"+item.getName()
                +"',unit = '"+item.getUnit()+"' ,price = '"+item.getPrice()
                +"' where barcode = '"+item.getBarcode()+"'";
        Connection connection = dbUtil.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            int result = statement.executeUpdate(sql);
            if(result > 0){
                System.out.println("更新成功");
            }
            else{
                System.out.println("更新失败");
            }
            statement.close();
            dbUtil.closeConnection();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
