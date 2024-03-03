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
 * @author User
 */
public class Cart implements Serializable{
    private static final String CART_FILE="cart.dat";
    ArrayList<Items> s=new ArrayList<Items>();

    public static void writeCartToFile(ArrayList<Items> itemList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CART_FILE))) {
            oos.writeObject(itemList);
            System.out.println("Cart items written to file successfully.");
        } catch (IOException e) {
            System.out.println("IOException while writing to cart file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static ArrayList<Items> readCartFromFile() 
    {
        ArrayList<Items> itemList=new ArrayList<>();
        try (ObjectInputStream ois=new ObjectInputStream(new FileInputStream(CART_FILE))) 
        {
            itemList=(ArrayList<Items>)ois.readObject();
            System.out.println("Cart items read from file successfully.");
        } 
        catch(IOException | ClassNotFoundException e) 
        {
            System.out.println("Error reading from cart file: "+e.getMessage());
            e.printStackTrace();
        }
        return itemList;
    }

    public static void addToCart(Items item) 
    {
        ArrayList<Items> itemList=readCartFromFile();
        itemList.add(item);
        writeCartToFile(itemList);
    }

    public static void displayCart() 
    {
        ArrayList<Items> itemList=readCartFromFile();
        if (itemList.isEmpty()) 
        {
            System.out.println("The cart is empty.");
        } 
        else 
        {
            System.out.println("Items in Cart:");
            for(Items item : itemList) 
            {
                System.out.println(item); 
            }
        }
    }

    public static void removeFromCart(String n) 
    {
        ArrayList<Items> itemList=readCartFromFile();
        for(int i=0;i<itemList.size();i++)
        {
            if(itemList.get(i).getName().equalsIgnoreCase(n))
            {
                itemList.remove(itemList.get(i));
            }
        }
        writeCartToFile(itemList);
    }

    public static double displayTotalPriceOfItemsStoredInCart() 
    {
        ArrayList<Items> itemList=readCartFromFile();
        double totalPrice=0.0;
        for (Items item:itemList) 
        {
            totalPrice+=item.getPrice();
        }
//        System.out.println("Total price of items in cart: $"+totalPrice);
        return totalPrice;
    }
     public static boolean findItemInCart(String itemName) 
     {
         boolean flag=false;
        ArrayList<Items> itemList=readCartFromFile();

        for (Items item:itemList) 
        {
            if (item.getName().equalsIgnoreCase(itemName)) 
            {
                flag=true; 
            }
        }

        return flag; 
    }
}
