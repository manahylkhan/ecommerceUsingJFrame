/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myshoppinghub;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author User
 */
public class Admin extends JFrame{
    JTextField t;
    JButton b,back,register;
    JLabel l;
    JPanel p1;
    Admin()
    {
        setSize(400,400);
        setVisible(true);
        setLayout(new BorderLayout());
        p1=new JPanel(new GridLayout(1,3));
        t=new JTextField();
        l=new JLabel("Enter the passcode:");
        b=new JButton("Submit");
        back=new JButton("Back");
        register=new JButton("Register");
        MyActionListenerForAdmin a=new MyActionListenerForAdmin();
        b.addActionListener(a);
        back.addActionListener(a);
        register.addActionListener(a);;
        p1.add(b);
        p1.add(back);
        p1.add(register);
        add(l,BorderLayout.NORTH);
        add(t,BorderLayout.CENTER);
        add(p1,BorderLayout.SOUTH);
    }
    public class MyActionListenerForAdmin implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
             if (ae.getActionCommand().equals("Submit")) {
            ArrayList<AdminClass> adminList = AdminClass.readAdminFromFile();

                boolean authenticated = false;
                for (AdminClass admin : adminList) {
                    if (admin.getPassward().equals(t.getText())) {
                        authenticated = true;
                        break;
                    }
                }

                if (authenticated) {
                    dispose();
                    AdminMenu ac = new AdminMenu();
                } else {
                    dispose();
                    Warning w = new Warning();
                }
             }
            else if(ae.getActionCommand().equals("Register"))
            {
                dispose();
                registerAdmin r=new registerAdmin();
            }
            else
            {
                dispose();
                BuyerSeller b=new BuyerSeller();
            }
        }
    }
    
}
