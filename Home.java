/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myshoppinghub;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class Home extends JFrame{
    JButton b;
    JLabel l;
    JPanel p1,p2;
    Home()
    {
        setSize(400,400);
        setVisible(true);
        setLayout(new BorderLayout());
        //initializing the buttons
        l=new JLabel("Welcome To E Shopping Hub");
        b=new JButton("Click here to Continue");
        //Initializing the panels
        p1=new JPanel();
        p2=new JPanel();
        //Attaching action listener to Buttons
        MyActionListenerForHome a=new MyActionListenerForHome();
        b.addActionListener(a);
        //adding Buttons
        p1.add(l);
        p2.add(b);
        //adding Panels
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
        
    }
    public class MyActionListenerForHome implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getActionCommand().equals("Click here to Continue"))
            {
                dispose();
                BuyerSeller sm=new BuyerSeller();
            }
        }
    }
    
}
