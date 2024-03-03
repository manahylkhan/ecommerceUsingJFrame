/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myshoppinghub;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class OrdersPlaced implements Serializable{
    public static final String ORDER_FILE="orders.dat";
    String name;
    String address;
    ArrayList<Items> orderPlaced=Cart.readCartFromFile();

    public void setOrderPlaced(ArrayList<Items> orderPlaced) {
        this.orderPlaced = Cart.readCartFromFile();
    }

    public ArrayList<Items> getOrderPlaced() {
        return orderPlaced;
    }
    
    public static void writeCartToFile(ArrayList<OrdersPlaced> itemList) 
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ORDER_FILE))) 
        {
            oos.writeObject(itemList);
            System.out.println("Cart items written to file successfully.");
        } 
        catch (IOException e) 
        {
            System.out.println("IOException while writing to cart file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static ArrayList<OrdersPlaced> readCartFromFile() 
    {
        ArrayList<OrdersPlaced> itemList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ORDER_FILE))) 
        {
            itemList = (ArrayList<OrdersPlaced>) ois.readObject();
            System.out.println("Cart items read from file successfully.");
        } 
        catch (IOException | ClassNotFoundException e) 
        {
            System.out.println("Error reading from cart file: " + e.getMessage());
            e.printStackTrace();
        }
        return itemList;
    }
}
