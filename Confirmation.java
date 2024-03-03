/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myshoppinghub;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author User
 */
public class Confirmation extends JFrame{
    JLabel l;
    JButton b;
    Confirmation()
    {
        setSize(400,400);
        setLayout(new BorderLayout());
        setVisible(true);
        b=new JButton("OK");
        l=new JLabel("Updated Successfully");
        MyActionListener a=new MyActionListener();
        b.addActionListener(a);
        add(l,BorderLayout.CENTER);
        add(b,BorderLayout.SOUTH);
    }
    public class MyActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getActionCommand().equals("OK"))
            {
                dispose();
                AdminMenu u=new AdminMenu();
            }
        }
    }
}
