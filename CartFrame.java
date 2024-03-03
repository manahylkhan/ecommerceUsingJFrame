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
public class CartFrame extends JFrame {
     JButton b,remove,checkOut;
    JLabel l, l1, l2, l3, l5;
    JPanel p1, p2, p3;

    /**
     * Constructor for the DisplayItems class.
     */
    CartFrame() {
        ArrayList<Items> iList = Cart.readCartFromFile();
        int size=iList.size();
        setLayout(new BorderLayout());
        setSize(400, 400);
        JScrollPane s = new JScrollPane();
        p1 = new JPanel();
        p2 = new JPanel(new GridLayout(size+1, 2));
        p3 = new JPanel(new GridLayout(1,3));
        l1 = new JLabel("Name");
//        l2 = new JLabel("Quantity");
        l3 = new JLabel("Price");
//        l4 = new JLabel("Description");
        b = new JButton("Back");
        checkOut = new JButton("Check Out");
        remove=new JButton("Remove");
        l = new JLabel("STOCK");
        MyActionListener a = new MyActionListener();
        b.addActionListener(a);
        remove.addActionListener(a);
        checkOut.addActionListener(a);
        p1.add(l);
        p2.add(l1);
//        p2.add(l2);
        p2.add(l3);
        //p2.add(l4);
        p3.add(b);
        p3.add(checkOut);
        p3.add(remove);
        //try {
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < 2; j++) {
                    if (j == 0) {
                        l5 = new JLabel(iList.get(i).getName());
                        p2.add(l5);
                    } else if (j == 1) {
                        l5 = new JLabel(String.valueOf(iList.get(i).getPrice()));
                        
                        p2.add(l5);
                    } 
//                    else if (j == 2) {
//                        l5 = new JLabel(String.valueOf(iList.get(i).getQuantity()));
//                        p2.add(l5);
//                    }
//                  else if(j==3){
//                        l5 = new JLabel(iList.get(i).getDescription());
//                        p2.add(l5);
//                }
                    
                }
            }

            add(p1, BorderLayout.NORTH);
            add(p2, BorderLayout.CENTER);
            add(p3, BorderLayout.SOUTH);
            setVisible(true);
    }

    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Back")) {
                dispose();
//                AdminMenu a = new AdminMenu();
            }
            else if(ae.getActionCommand().equals("Remove"))
            {
                dispose();
                removeFromCartFrame r=new removeFromCartFrame();
            }
            else if(ae.getActionCommand().equals("Check Out"))
            {
                dispose();
                checkOutFrame r=new checkOutFrame();
            }
        }
    }
}
