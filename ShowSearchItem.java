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
import javax.swing.JScrollPane;

/**
 *
 * @author Dell
 */
public class ShowSearchItem extends JFrame{
    JLabel l,l1,l2,l3,l4,l5;
    JButton b;
    JPanel p2;
    ShowSearchItem(String s)
    {
        String item=s;
        int index=0;
        setLayout(new BorderLayout());
        setSize(400, 400);
        setVisible(true);
        ArrayList<Items> iList=Items.readItemFromFile();
        for(int i=0;i<iList.size();i++)
        {
            if(iList.get(i).getName().equalsIgnoreCase(item))
            {
                index=i;
                break;
            }
        }
//        p1 = new JPanel();
        p2 = new JPanel(new GridLayout(2, 4));
//        p3 = new JPanel();
        b=new JButton("Back");
        l = new JLabel("Searched Item");
        l1 = new JLabel("Name");
        l2 = new JLabel("Quantity");
        l3 = new JLabel("Price");
        l4 = new JLabel("Description");
        p2.add(l1);
        p2.add(l2);
        p2.add(l3);
        p2.add(l4);
        for(int i=0;i<4;i++)
        {
            if(i==0)
            {
                l5=new JLabel(iList.get(index).getName());
                p2.add(l5);
            }
            else if(i==1)
            {
                l5=new JLabel(String.valueOf(iList.get(index).getQuantity()));
                p2.add(l5);
            }
            else if(i==2)
            {
                l5=new JLabel(String.valueOf(iList.get(index).getPrice()));
                p2.add(l5);
            }
            else
            {
                l5=new JLabel(iList.get(index).getDescription());
                p2.add(l5);
            }
        }
        MyActionListener listener = new MyActionListener();
        b.addActionListener(listener);
        add(p2, BorderLayout.CENTER);
        add(b, BorderLayout.SOUTH);
    }
    public class MyActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getActionCommand().equals("Back"))
            {
                dispose();
                ShoppingMenu u=new ShoppingMenu();
            }
        }
    }
}
