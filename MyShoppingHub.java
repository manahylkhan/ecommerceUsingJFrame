/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package myshoppinghub;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class MyShoppingHub {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException 
    {
        ArrayList<Items> i_list=new ArrayList<Items>();
        Items i1=new Items("Blush",3,500,"Available in Pink, Peach and Skin Tone");
        Items i2=new Items("Mobile Cover",5,100,"Available in Pink, Peach and Skin Colours");
        //Items.writeItemToFile(i2);
        Items i3=new Items("Airpods",3,50,"Available in White and Black");
        //Items.writeItemToFile(i3);
        Items i4=new Items("Water Bottle",3,50,"Available in Transparent only");
        //Items.writeItemToFile(i4);
        Items i5=new Items("Gell Pen",3,10,"Available in Black, Blue, Red and Green");
        //Items.writeItemToFile(i5);
        Items i6=new Items("Diary",3,50,"500 pages");
        //Items.writeItemToFile(i6);
        Items i7=new Items("Shades",3,250,"Available in Black, for both male and female"); 
        Items i8=new Items("Mobile Phone",3,50000,"Iphone 15");
        Items i9=new Items("Chess Board",3,500,"8x8");
        Items i10=new Items("Shoes",3,1000,"Nike");
        i_list.add(i1);
        i_list.add(i2);
        i_list.add(i3);
        i_list.add(i4);
        i_list.add(i5);
        i_list.add(i6);
        i_list.add(i7);
        i_list.add(i8);
        i_list.add(i9);
        i_list.add(i10);
        ArrayList<Customer> c_list=new ArrayList<Customer>();
        Customer c1=new Customer("Manahil","female","manahyl","1234");
        Customer c2=new Customer("Momina","Female","momina","7890");
        c_list.add(c1);
        c_list.add(c1);
        Customer.writeCustomersToFile(c_list);
        Items if2=new Items("TShirt",10,30,"Available in all sizes");
        Items if3=new Items("Frok",5,500,"Available in all sizes");
//        i_list.add(if1);
        i_list.add(if2);
        i_list.add(if3);
        Items.writeItemToFile(i_list);
        Home h=new Home();
        ArrayList<Items> alist=Items.readItemFromFile();
        for(int i=0;i<alist.size();i++)
        {
            System.out.println(alist.get(i).getName());
        }
    }
    
}
