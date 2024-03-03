/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myshoppinghub;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Dell
 */
public class FashionFrame extends JFrame{
    JButton b1,b2,b3;
    JLabel l;
    JPanel p1,p2;
    FashionFrame()
    {
        setSize(400,400);
        setVisible(true);
        setLayout(new BorderLayout());
        //initializing Panels
        p1=new JPanel();
        p2=new JPanel(new GridLayout(3,1));
        //initializing buttons
        b1=new JButton("Female");
        b2=new JButton("Male");
        b3=new JButton("Back");
        l=new JLabel("MakeUp");
        //Action Listener Object
        MyActionListenerForMakeUp a=new MyActionListenerForMakeUp();
        //attach buttons
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        //add buttons to panels
        p1.add(l);
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        //add panels
        add(p1,BorderLayout.NORTH);
        add(p2);
    }
    public class MyActionListenerForMakeUp implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            
        }
    }
}
