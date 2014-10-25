package com.thoughtWorks.posProject;

import com.thoughtWorks.vo.Item;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbTest {
    String driverName = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/management";
    String userName = "pos";
    String password = "123";

    Connection connection = null;
    Statement statement = null;
    ResultSet rs = null;

    public static void main(String[] args){
       DbTest dbTest = new DbTest();
        Item item = new Item("ITEM000002","方便面","袋",2.5);
        dbTest.insertItem(item);

        Item item2 = new Item("ITEM000002","苹果","斤",5.00);
        dbTest.updateItem(item2);
        dbTest.getItem();

        dbTest.deleteItemByBarcode("ITEM000002");
    }
    public void getItem() {
        String sql = "SELECT * FROM items";

        try {
            Class.forName(driverName);//加载
            connection = DriverManager.getConnection(url, userName, password);
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
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
         catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertItem(Item item){

        String sql = "insert into items values('"+item.getBarcode()+
                "','"+item.getName()+"','"+item.getUnit()+"', "+item.getPrice()+")";
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, userName, password);
            statement = connection.createStatement();

            int result = statement.executeUpdate(sql);
            if(result > 0){
                System.out.println("插入成功");
            }
            else{
                System.out.println("插入失败");
            }
            statement.close();
            connection.close();

        }catch (SQLException e) {
                e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void deleteItemByBarcode(String barcode){
        String sql = "delete from items where barcode = '"+barcode+"'";
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, userName, password);
            statement = connection.createStatement();

            int result = statement.executeUpdate(sql);
            if(result > 0){
                System.out.println("删除成功");
            }
            else{
                System.out.println("删除失败");
            }
            statement.close();
            connection.close();

        }catch (SQLException e) {
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void updateItem(Item item){

        String sql = "update items set name = '"+item.getName()
                +"',unit = '"+item.getUnit()+"' ,price = '"+item.getPrice()
                +"' where barcode = '"+item.getBarcode()+"'";
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, userName, password);
            statement = connection.createStatement();

            int result = statement.executeUpdate(sql);
            if(result > 0){
                System.out.println("更新成功");
            }
            else{
                System.out.println("更新失败");
            }
            statement.close();
            connection.close();

        }catch (SQLException e) {
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
