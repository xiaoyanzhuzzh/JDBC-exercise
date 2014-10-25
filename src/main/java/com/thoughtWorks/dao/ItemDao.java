package com.thoughtWorks.dao;

import com.thoughtWorks.util.DbUtil;
import com.thoughtWorks.vo.Item;

import java.sql.*;

public class ItemDao {
    private DbUtil dbUtil = new DbUtil();

    public void getItem() {
        String sql = "SELECT * FROM items";
        Connection connection = dbUtil.getConnection();
        Statement statement = null;
        ResultSet rs = null;

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            rs.next();
            String barcode = rs.getString("barcode");
            String name = rs.getString("name");
            String unit = rs.getString("unit");
            double price = rs.getDouble("price");

            System.out.println("条形码：" + barcode +"名称："+ name + "单价：" + unit + "单价：" + price + "元");

            rs.close();
            statement.close();
            dbUtil.closeConnection();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertItem(Item item){

        String sql = "insert into items values('"+item.getBarcode()+
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

    public void deleteItemByBarcode(String barcode){
        String sql = "delete from items where barcode = '"+barcode+"'";
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
