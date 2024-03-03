/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myshoppinghub;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Dell
 */
public class WaterBottle extends JFrame{
    JButton b1,b2,b3;
    JLabel l,l2,l3,l4,l5,limage;
    JPanel p1,p2,p3,p4;
    WaterBottle()
    {
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());
        //initializing Panels
        p1=new JPanel();
        p2=new JPanel(new GridLayout(5,1));
        p3=new JPanel(new GridLayout(1,3));
        //initializing buttons
        b1=new JButton("Back");
        b2=new JButton("View Cart");
        b3=new JButton("Add To Cart");
        l=new JLabel("Water Bottle Details");
//        try{
//        ImageIcon t= new ImageIcon("C:\\Users\\Dell\\Pictures\\blush.jpg");
//        limage=new JLabel(t);
//        } catch (Exception e) {
//        System.err.println("Error loading image: " + e.getMessage());
//        e.printStackTrace();
//        }
        ArrayList<Items> iList=Items.readItemFromFile();
        int place=0;
        for(int i=0;i<iList.size();i++)
        {
            if(iList.get(i).getName().equalsIgnoreCase("Water Bottle"))
            {
                place=i;
                break;
            }
        }
        l2=new JLabel("Name: "+iList.get(place).getName());
        l3=new JLabel("Price: "+iList.get(place).getPrice());
        l4=new JLabel("Quanity: "+iList.get(place).getQuantity());
        l5=new JLabel("Description: "+iList.get(place).getDescription());
        //Action Listener Object
        MyActionListener a=new MyActionListener();
        //attach buttons
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        
        //add buttons to panels
        p1.add(l);
        p2.add(l2);
        p2.add(l3);
        p2.add(l4);
        p2.add(l5);
        //p4.add(limage);
        p3.add(b1);
        p3.add(b2);
        p3.add(b3);
        //add panels
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
        add(p3,BorderLayout.SOUTH);
        add(p4,BorderLayout.EAST);
        
    }
    public class MyActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getActionCommand().equals("Back"))
            {
                dispose();
                ShoppingMenu sm=new ShoppingMenu();
            }
            else if(ae.getActionCommand().equals("View Cart"))
            {
                CartFrame c=new CartFrame();
            }
            else
            {
                ArrayList<Items> it=Items.readItemFromFile();
                ArrayList<Items> soldItems=Items.readSoldItemFromFile();
                for(int i=0;i<it.size();i++)
                {
                    if(it.get(i).getName().equalsIgnoreCase("Water Bottle"))
                    {
                        if(it.get(i).getQuantity()<1)
                        {
                            QuantityLow l=new QuantityLow();
                        }
                        else
                        {
                            it.get(i).setQuantity((it.get(i).getQuantity())-1);
                            Cart.addToCart(it.get(i));
                            soldItems.add(it.get(i));
                            try {
                                Items.writeSoldItemToFile(soldItems);
                            } catch (IOException ex) {
                                Logger.getLogger(Blush.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            Added a=new Added();
                        }
                        
                    }
                }
                try {
                    Items.writeItemToFile(it);
                } catch (IOException ex) {
                    Logger.getLogger(MobileCover.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
