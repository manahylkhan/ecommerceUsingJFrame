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
public class DeleteAnItem extends JFrame{
    JLabel l;
    JTextField t;
    JButton b,b2;
    JPanel p,p2;
    DeleteAnItem()
    {
        setSize(400,400);
        setVisible(true);
        setLayout(new BorderLayout());
        b=new JButton("Submit");
        b2=new JButton("Back");
        t=new JTextField();
        //t2=new JTextField();
        //t3=new JTextField();
        p=new JPanel(new GridLayout(1,2));
        p2=new JPanel(new GridLayout(1,2));
        l=new JLabel("Name of the item:");
        //l2=new JLabel("Exisiting Quantity");
        //l3=new JLabel("New Quantity:");
        MyActionListener a=new MyActionListener();
        b.addActionListener(a);
        b2.addActionListener(a);
        p.add(l);
        p.add(t);
        p2.add(b);
        p2.add(b2);
        add(p,BorderLayout.CENTER);
        add(p2,BorderLayout.SOUTH);
        
    }
    public class MyActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getActionCommand().equals("Submit"))
            {
                try{
                    ArrayList<Items> ilist=Items.readItemFromFile();
                    boolean  found=false;
                    String itemName = t.getText().trim();
//                    for(int i=0;i<ilist.size();i++)
//                    {
//                        if(ilist.get(i).getName().equalsIgnoreCase(t.getText()))
//                        {
//                            found=true;
//                            break;
//                        }
//                    }
//                        if(found==true)
//                        {
//                            Items.deleteAnItem(t.getText());
//                            dispose();
//                            DeletedItemConfirmation p=new DeletedItemConfirmation();
//                        }
//                        else
//                        {
//                            dispose();
//                            ddeleteNameNotFound a=new ddeleteNameNotFound();
//                        }
                        if(Items.findItem(itemName))
                        {
                            Items.deleteAnItem(itemName);
                            dispose();
                            DeletedItemConfirmation p=new DeletedItemConfirmation();
                        }
                        else
                        {
                             dispose();
                            ddeleteNameNotFound a=new ddeleteNameNotFound();
                        }
                }
                catch(Exception e)
                {
                    dispose();
                    ddeleteNameNotFound a=new ddeleteNameNotFound();                    
                }
            }
            else
            {
                dispose();
                AdminMenu u=new AdminMenu();
            }
        }
    }
}
