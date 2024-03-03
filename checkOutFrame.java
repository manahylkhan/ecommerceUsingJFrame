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
import javax.swing.JTextField;

/**
 *
 * @author Dell
 */
public class checkOutFrame extends JFrame{
 JButton b,checkOut;
    JLabel l, l1,l2, name, l3, l5,total;
    JPanel p1, p2, p3;
    JTextField t1,t3;

    /**
     * Constructor for the DisplayItems class.
     */
    checkOutFrame(){
        ArrayList<Items> iList = Cart.readCartFromFile();
//      total=Double.toString(Cart.displayTotalPriceOfItemsStoredInCart());
        setLayout(new BorderLayout());
        setSize(400, 400);
        JScrollPane s = new JScrollPane();
        p1 = new JPanel();
        p2 = new JPanel(new GridLayout(3, 2));
        p3 = new JPanel();
        l1 = new JLabel("Name");
        t1 = new JTextField();
        l2 = new JLabel("Total");
        String totalPrice=Double.toString(Cart.displayTotalPriceOfItemsStoredInCart());
        total = new JLabel(totalPrice);
//        total = new JLabel(total);
        l3 = new JLabel("Address");
        t3=new JTextField();
//        l4 = new JLabel("Description");
        b = new JButton("Back");
        checkOut = new JButton("Check Out");
        //remove=new JButton("Remove");
        l = new JLabel("Check Out");
        MyActionListener a = new MyActionListener();
        b.addActionListener(a);
        //remove.addActionListener(a);
        checkOut.addActionListener(a);
        p1.add(l);
        p2.add(l1);
        p2.add(t1);
        p2.add(l3);
        p2.add(t3);
        p2.add(l2);
        p2.add(total);
        p3.add(checkOut);
        p3.add(b);
//            p2.add(l2);
            add(p1, BorderLayout.NORTH);
            add(p2, BorderLayout.CENTER);
            add(p3, BorderLayout.SOUTH);
            setVisible(true);
    }
    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Back")) {
                dispose();
                CartFrame p=new CartFrame();
            }
//            else if(ae.getActionCommand().equals("Remove"))
//            {
//                dispose();
//                removeFromCartFrame r=new removeFromCartFrame();
//            }
            else if(ae.getActionCommand().equals("Check Out"))
            {
                dispose();
                ConfirmationCheckOut r=new ConfirmationCheckOut();
            }
        }
    }
}
