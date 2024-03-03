/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myshoppinghub;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ShoppingMenu extends JFrame{
    JButton b1,b2,b3,b4,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,search;
    JLabel l;
    JPanel p1,p2,p3;
    ShoppingMenu()
    {
        setSize(400,400);
        setVisible(true);
        setLayout(new BorderLayout());
        //initializing buttons and labels
        search=new JButton("Search");
        b1=new JButton("Blush");
        b2=new JButton("Mobile Cover");
        b3=new JButton("Airpods");
        b4=new JButton("Water Bottle");
        b11=new JButton("Gell Pen");
        b12=new JButton("Diary");
        b13=new JButton("Shades");
        b14=new JButton("Mobile Phone");
        b15=new JButton("Chess Board");
        b16=new JButton("Shoes");
        b17=new JButton("TShirt");
        b18=new JButton("Frok");
        b19=new JButton("Back");
        b20=new JButton("View Cart");
        l=new JLabel("Shopping Menu");
//        initializing Panels
        p1=new JPanel();
        ArrayList<Items> iList=Items.readItemFromFile();
        int size = iList.size();
        int rows = (int)Math.ceil((double) size / 4);
        p2=new JPanel(new GridLayout(rows+1,4));
        p3=new JPanel(new GridLayout(1,3));
        //Action Listener Object
        MyActionListenerForShoppingMenu a=new MyActionListenerForShoppingMenu();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        b4.addActionListener(a);
        b11.addActionListener(a);
        b12.addActionListener(a);
        b13.addActionListener(a);
        b14.addActionListener(a);
        b15.addActionListener(a);
        b16.addActionListener(a);
        b17.addActionListener(a);
        b18.addActionListener(a);
        b19.addActionListener(a);
        b20.addActionListener(a);
        search.addActionListener(a);
        //adding panel wise
        p1.add(l);
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b11);
        p2.add(b12);
        p2.add(b13);
        p2.add(b14);
        p2.add(b15);
        p2.add(b16);
        p2.add(b17);
        p2.add(b18);
        p3.add(b19);
        p3.add(b20);
        p3.add(search);
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
        add(p3,BorderLayout.SOUTH);
    }
    public class MyActionListenerForShoppingMenu implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getActionCommand().equals("Blush"))
            {
                dispose();
                Blush m=new Blush();
            }
            else if(ae.getActionCommand().equals("Mobile Cover"))
            {
                dispose();
                MobileCover f=new MobileCover();
            }
            else if(ae.getActionCommand().equals("Airpods"))
            {
                dispose();
                Airpods t=new Airpods();
            }
            else if(ae.getActionCommand().equals("Water Bottle"))
            {
                dispose();
                WaterBottle s=new WaterBottle();
            }
            else if(ae.getActionCommand().equals("Gell Pen"))
            {
                dispose();
                GellPen t=new GellPen();
            }
            else if(ae.getActionCommand().equals("Diary"))
            {
                dispose();
                Diary t=new Diary();
            }
            else if(ae.getActionCommand().equals("Shades"))
            {
                dispose();
                Shades t=new Shades();
            }
            else if(ae.getActionCommand().equals("Mobile Phone"))
            {
                dispose();
                MobilePhone t=new MobilePhone();
            }
            else if(ae.getActionCommand().equals("Chess Board"))
            {
                dispose();
                ChessBoard t=new ChessBoard();
            }
            else if(ae.getActionCommand().equals("Shoes"))
            {
                dispose();
                Shoes t=new Shoes();
            }
            else if(ae.getActionCommand().equals("TShirt"))
            {
                dispose();
                TShirt t=new TShirt();
            }
            else if(ae.getActionCommand().equals("Frok"))
            {
                dispose();
                Frok t=new Frok();
            }
            else if(ae.getActionCommand().equals("Back"))
            {
                dispose();
                BuyerSeller b=new BuyerSeller();
            }
            else if(ae.getActionCommand().equals("Search"))
            {
                dispose();
                ItemSearch b=new ItemSearch();
            }
            else
            {
                CartFrame c=new CartFrame();
            }
        }
    }
}
