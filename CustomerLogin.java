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
 * @author Dell
 */
public class CustomerLogin extends JFrame{
    JButton b1, b2,b3,b4;
    JPanel p1,p2,p3;
    JLabel l,l1,l2;
    JTextField t1,t2;
    CustomerLogin()
    {
        setSize(400,400);
        setVisible(true);
        setLayout(new BorderLayout());
        p1=new JPanel();
        p2=new JPanel(new GridLayout(2,2));
        p3=new JPanel(new GridLayout(1,4));
        b1=new JButton("Back");
        b2=new JButton("Submit");
        b3=new JButton("Register");
        b4=new JButton("Change Password");
        l=new JLabel("Customer Credentials");
        l1=new JLabel("Username:");
        l2=new JLabel("Password");
        t1=new JTextField();
        t2=new JTextField();
        MyActionListener a =new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        b4.addActionListener(a);
        p1.add(l);
        p2.add(l1);
        p2.add(t1);
        p2.add(l2);
        p2.add(t2);
        p3.add(b1);
        p3.add(b2);
        p3.add(b3);
        p3.add(b4);
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
                BuyerSeller a=new BuyerSeller();
            }
            else if(ae.getActionCommand().equals("Submit"))
            {
                boolean verify=Customer.verifyLogin(t1.getText(), t2.getText());
                if(verify==true)
                {
                    dispose();
                    ShoppingMenu m=new ShoppingMenu();
                }
                else
                {
                    dispose();
                    WarningCustomer c=new WarningCustomer();
                }
            }
            else if(ae.getActionCommand().equals("Change Password"))
            {
                dispose();
                ChangePassword c=new ChangePassword();
            }
            else
            {
                dispose();
                Register p=new Register();
            }
        }
    }
}
