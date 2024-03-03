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

/**
 *
 * @author Dell
 */
public class removeFromCartFrame extends JFrame{
    JLabel l;
    JTextField t;
    JButton b,b2;
    JPanel p,p2;
    removeFromCartFrame()
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
                    ArrayList<Items> ilist=Cart.readCartFromFile();
                    ArrayList<Items> itemList=Items.readItemFromFile();
                    boolean  found=false;
                    int index=0;
                    String itemName = t.getText().trim();
                    for(int i=0;i<itemList.size();i++)
                    {
                        if(itemList.get(i).getName().equalsIgnoreCase(t.getText()))
                        {
                            found=true;
                            index=i;
                            break;
                        }
                    }
                        if(found==true)
                        {
                            itemList.get(index).setQuantity((itemList.get(index).getQuantity())+1);
                            Items.writeItemToFile(itemList);
                        }
                        
//                        else
//                        {
//                            dispose();
//                            ddeleteNameNotFound a=new ddeleteNameNotFound();
//                        }
                    
                        if(Cart.findItemInCart(itemName))
                        {
                            Cart.removeFromCart(itemName);
                            dispose();
                            DeletedItemFromCartConfirmation p=new DeletedItemFromCartConfirmation();
                        }
                        else
                        {
                             dispose();
                            DeletedItemFromCartWarning a=new DeletedItemFromCartWarning();
                        }
                }
                catch(Exception e)
                {
                    dispose();
                    DeletedItemFromCartWarning a=new DeletedItemFromCartWarning();                    
                }
            }
            else
            {
                dispose();
                CartFrame u=new  CartFrame();
            }
        }
    }
}
