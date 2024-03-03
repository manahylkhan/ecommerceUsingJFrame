/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myshoppinghub;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author User
 */
public class BuyerSeller extends JFrame{
    JButton b1, b2,b3;
    JPanel p1,p2;
    JLabel l;
    BuyerSeller()
    {
        setSize(400,400);
        setVisible(true);
        setLayout(new BorderLayout());
        p1=new JPanel();
        p2=new JPanel(new GridLayout(3,1));
        b1=new JButton("Admin");
        b2=new JButton("Customer");
        b3=new JButton("Back");
        l=new JLabel("Please select Who you are!");
        MyActionListenerForBuyerSeller a =new MyActionListenerForBuyerSeller();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        p1.add(l);
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
    }
    public class MyActionListenerForBuyerSeller implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getActionCommand().equals("Admin"))
            {
                dispose();
                Admin a=new Admin();
            }
            else if(ae.getActionCommand().equals("Customer"))
            {
                dispose();
                CustomerLogin s=new CustomerLogin();
            }
            else
            {
                dispose();
                Home h=new Home();
            }
        }
    }
}
