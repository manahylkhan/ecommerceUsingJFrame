/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myshoppinghub;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class Quantity extends JFrame{
    JLabel l,l3;
    JTextField t,t3;
    JButton b,b2;
    JPanel p,p2;
    Quantity()
    {
        setSize(400,400);
        setVisible(true);
        setLayout(new BorderLayout());
        b=new JButton("Submit");
        b2=new JButton("Back");
        t=new JTextField();
        //t2=new JTextField();
        t3=new JTextField();
        p=new JPanel(new GridLayout(2,2));
        p2=new JPanel(new GridLayout(1,2));
        l=new JLabel("Name of the item:");
        //l2=new JLabel("Exisiting Quantity");
        l3=new JLabel("New Quantity:");
        MyActionListenerForQuantity a=new MyActionListenerForQuantity();
        b.addActionListener(a);
        b2.addActionListener(a);
        p.add(l);
        p.add(t);
        //p.add(l2);
        //p.add(t2);
        p.add(l3);
        p.add(t3);
        p2.add(b);
        p2.add(b2);
        add(p,BorderLayout.CENTER);
        add(p2,BorderLayout.SOUTH);
        
    }
    public class MyActionListenerForQuantity implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getActionCommand().equals("Submit"))
            {
                //int t11=Integer.parseInt(t2.getText());
                int t12=Integer.parseInt(t3.getText());
                ArrayList<Items> ilist=Items.readItemFromFile();
                boolean flag=false;
                for(int i=0;i<ilist.size();i++)
                {
                    if(ilist.get(i).getName().equalsIgnoreCase(t.getText()))
                    {
                        flag=true;
                    }
                }
                if(flag==true)
                {
                    try {
                        Items.updateAnItemQuantity(t.getText(),t12);
                    } catch (IOException ex) {
                        Logger.getLogger(Quantity.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    dispose();
                    QuantityChange p=new QuantityChange();
                }
                else
                {
                    WarningQuantity q=new WarningQuantity();
                }
            }
            else
                {
                    dispose();
                    UpdateAnItem u=new UpdateAnItem();
                }
            
        }
    }
    
}
