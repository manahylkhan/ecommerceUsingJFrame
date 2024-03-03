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
public class ConfirmationCheckOut extends JFrame{
     JLabel l;
    JButton b,preview;
    JPanel p1,p2;
    ConfirmationCheckOut()
    {
        setSize(400,400);
        setLayout(new BorderLayout());
        setVisible(true);
        p1=new JPanel();
        p2=new JPanel(new GridLayout(1,2));
        b=new JButton("OK");
        preview = new JButton("Preview");
        l=new JLabel("Order Placed Successfully");
        MyActionListener a=new MyActionListener();
        b.addActionListener(a);
        preview.addActionListener(a);
        p1.add(l);
        p2.add(b);
        p2.add(preview);
        add(p1,BorderLayout.CENTER);
        add(p2,BorderLayout.SOUTH);
    }
    public class MyActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getActionCommand().equals("OK"))
            {
                dispose();
                ShoppingMenu u=new ShoppingMenu();
            }
            else if(ae.getActionCommand().equals("Preview"))
            {
                dispose();
                Order u=new Order();
            }
        }
    }
}
