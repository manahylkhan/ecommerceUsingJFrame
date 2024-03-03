/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myshoppinghub;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Dell
 */
public class Register extends JFrame{
    JButton b,b1;
    JLabel l,l1,l2,l3,l4;
    JTextField t1,t2,t3,t4;
    JPanel p1,p2,p3;
    Register()
    {
        setSize(400,400);
        setVisible(true);
        setLayout(new BorderLayout());
        p1=new JPanel();
        p2=new JPanel(new GridLayout(4,2));
        p3=new JPanel();
        b=new JButton("Back");
        b1=new JButton("Submit");
        l=new JLabel("Register");
        l1=new JLabel("Username:");
        l2=new JLabel("Password");
        l3=new JLabel("Name");
        l4=new JLabel("Gender");
//        l3=new JLabel("Quantity");
//        l4=new JLabel("Description");
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
//        t3=new JTextField();
//        t4=new JTextField();
        MyActionListener a=new MyActionListener();
        b.addActionListener(a);
        b1.addActionListener(a);
        p1.add(l);
        p2.add(l1);
        p2.add(t1);
        p2.add(l2);
        p2.add(t2);
        p2.add(l3);
        p2.add(t3);
        p2.add(l4);
        p2.add(t4);
//        p2.add(l3);
//        p2.add(t3);
//        p2.add(l4);
//        p2.add(t4);
        p3.add(b);
        p3.add(b1);
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
        add(p3,BorderLayout.SOUTH);
    }
    public class MyActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getActionCommand().equals("Back"))
            {
                dispose();
                CustomerLogin a=new CustomerLogin();
            }
            else
            {
                try
                {
//                    String username = t1.getText();
//                    String password = t2.getText(); 
                    ArrayList<Customer> cList=Customer.readCustomersFromFile();
                    Customer c = new Customer(t3.getText(),t4.getText(),t1.getText(),t2.getText()); 
                    cList.add(c);
                    Customer.writeCustomersToFile(cList); 
                }
                catch(NumberFormatException e)
                {
                    dispose();
                    WarningAdd w = new WarningAdd();
                    w.setVisible(true);
                }
                dispose();
                CustomerLogin c=new CustomerLogin();
            }
        }
    }
}
