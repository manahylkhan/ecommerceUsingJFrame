/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myshoppinghub;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author User
 */
public class Price extends JFrame{
    JLabel l,l2,l3;
    JTextField t,t2,t3;
    JButton b,b2;
    JPanel p,p2;
    Price()
    {
        setSize(400,400);
        setVisible(true);
        setLayout(new BorderLayout());
        b=new JButton("Submit");
        b2=new JButton("Back");
        t=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        p=new JPanel(new GridLayout(3,2));
        p2=new JPanel(new GridLayout(1,2));
        l=new JLabel("Name of the item:");
        l2=new JLabel("Exisiting Price:");
        l3=new JLabel("New Price:");
        MyActionListenerForPrice a=new MyActionListenerForPrice();
        b.addActionListener(a);
        b2.addActionListener(a);
        p.add(l);
        p.add(t);
        p.add(l2);
        p.add(t2);
        p.add(l3);
        p.add(t3);
        p2.add(b);
        p2.add(b2);
        add(p,BorderLayout.CENTER);
        add(p2,BorderLayout.SOUTH);
        
    }
    public class MyActionListenerForPrice implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getActionCommand().equals("Submit"))
            {
                if(Items.findItem(t.getText()))
                {
                    try{
                        int t11=Integer.parseInt(t2.getText());
                        int t12=Integer.parseInt(t3.getText());
                        Items.updateAnItemPrice(t.getText(),t11,t12);
                        dispose();
                        priceChange p=new priceChange();
                    }
                    catch(InputMismatchException e)
                    {
                        dispose();
                        inputMismatch i=new inputMismatch();
                    } catch (IOException ex) {
                        Logger.getLogger(Price.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else
                {
                    dispose();
                    noItemWithSuchName i=new noItemWithSuchName();
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
