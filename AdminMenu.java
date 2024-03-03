/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myshoppinghub;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author User
 */
public class AdminMenu extends JFrame{
    JButton b1,b2,b3,b4,b5,b6;
    JPanel p1,p2;
    JLabel l;
    AdminMenu()
    {
        setSize(400,400);
        setVisible(true);
        setLayout(new BorderLayout());
        b1=new JButton("Update an Item");
        b2=new JButton("Delete an Item");
        b3=new JButton("Add an Item");
        b4=new JButton("Display Items");
        b6=new JButton("View Stats");
        b5=new JButton("Back");
        p1=new JPanel();
        p2=new JPanel(new GridLayout(6,1));
        l=new JLabel("Admin Menu");
        MyActionListenerForAdminMenu a=new MyActionListenerForAdminMenu();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        b4.addActionListener(a);
        b5.addActionListener(a);
        b6.addActionListener(a);
        p1.add(l);
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b6);
        p2.add(b5);
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
    }
    public class MyActionListenerForAdminMenu implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getActionCommand().equals("Update an Item"))
            {
                dispose();
                UpdateAnItem u=new UpdateAnItem();
            }
            else if(ae.getActionCommand().equals("Delete an Item"))
            {
                dispose();
                DeleteAnItem i=new DeleteAnItem();
            }
            else if(ae.getActionCommand().equals("Add an Item"))
            {
                dispose();
                AddAnItem a=new AddAnItem();
            }
            else if(ae.getActionCommand().equals("Display Items"))
            {
                dispose();
                DisplayItems d=new DisplayItems();
            }
            else if(ae.getActionCommand().equals("View Stats"))
            {
                dispose();
                ViewStats d=new ViewStats();
            }
            else
            {
                dispose();
                BuyerSeller b=new BuyerSeller();
            }
        }
    }
}