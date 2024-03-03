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
import static myshoppinghub.Customer.readCustomersFromFile;
import static myshoppinghub.Customer.writeCustomersToFile;

/**
 *
 * @author Dell
 */
public class ChangePassword extends JFrame{
    JTextField t1,t2,t3;
    JButton b,back;
    JLabel l,l1,l2,l3;
    JPanel p1,p2,p3;
    ChangePassword()
    {
        setSize(400,400);
        setVisible(true);
        setLayout(new BorderLayout());
        p1=new JPanel();
        p2=new JPanel(new GridLayout(3,2));
        p3=new JPanel(new GridLayout(1,2));
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        l=new JLabel("Change Password");
        l1=new JLabel("Enter the username:");
        l2=new JLabel("Enter the name:");
        l3=new JLabel("Enter the new Password:");
        b=new JButton("Submit");
        back=new JButton("Back");
        MyActionListener a=new MyActionListener();
        b.addActionListener(a);
        back.addActionListener(a);
        p1.add(l);
        p2.add(l1);
        p2.add(t1);
        p2.add(l2);
        p2.add(t2);
        p2.add(l3);
        p2.add(t3);
        p3.add(b);
        p3.add(back);
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
        add(p3,BorderLayout.SOUTH);
    }
    public class MyActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getActionCommand().equals("Submit"))
            {
                ArrayList<Customer> customers = readCustomersFromFile();
                boolean found=false;
                for (Customer customer:customers) 
                {
                if (customer.getUsername().equals(t1.getText()) ) 
                {
                    customer.setPassword(t3.getText());
                    found = true;
                    break;
                }
            }
            if(found) 
            {
                writeCustomersToFile(customers);
                dispose();
                PasswordChangedConfirmation p=new PasswordChangedConfirmation();
            } 
            else 
            {
                dispose();
                ChangePasswordWarning n=new ChangePasswordWarning();
            }
        }
        else
        {
            dispose();
            BuyerSeller b=new BuyerSeller();
        }
    }
}
}
