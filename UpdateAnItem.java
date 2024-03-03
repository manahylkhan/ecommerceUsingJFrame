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
 * @author User
 */
public class UpdateAnItem extends JFrame{
    JButton b1,b2,b3;
    JPanel p1,p2;
    JLabel l;
    UpdateAnItem()
    {
        setSize(400,400);
        setVisible(true);
        setLayout(new BorderLayout());
        b1=new JButton("Update Price");
        b2=new JButton("Update Quantity");
        b3=new JButton("Back");
        p1=new JPanel();
        p2=new JPanel(new GridLayout(3,1));
        l=new JLabel("Admin Panel Updation");
        MyActionListenerForUpdateItem a=new MyActionListenerForUpdateItem();
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
    public class MyActionListenerForUpdateItem implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getActionCommand().equals("Update Price"))
            {
                dispose();
                Price p=new Price();
            }
            else if(ae.getActionCommand().equals("Update Quantity"))
            {
                dispose();
                Quantity q=new Quantity();
            }
            else
            {
                dispose();
                AdminMenu a=new AdminMenu();
            }
        }
    }
}
