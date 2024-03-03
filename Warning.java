/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myshoppinghub;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JLabel;

/**
 *
 * @author User
 */
public class Warning extends JFrame{
    JLabel l;
    JButton b;
    Warning()
    {
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());
        b=new JButton("ok");
        l=new JLabel("You entered the wrong passcode");
        add(l,BorderLayout.CENTER);
        MyActionListenerForWarning a=new MyActionListenerForWarning();
        b.addActionListener(a);
        add(l,BorderLayout.CENTER);
        add(b,BorderLayout.SOUTH);
        
    }
    public class MyActionListenerForWarning implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getActionCommand().equals("ok"))
            {
                dispose();
                Admin a=new Admin();
            }
        }
    }
}
