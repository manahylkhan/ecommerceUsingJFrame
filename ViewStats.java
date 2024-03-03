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
public class ViewStats extends JFrame{
    JButton b;
    JLabel l, l1, l2, l3, l4, l5;
    JPanel p1, p2, p3;

    /**
     * Constructor for the DisplayItems class.
     */
    ViewStats() {
        ArrayList<Items> iList = Items.readSoldItemFromFile();
        int size=iList.size();
        setLayout(new BorderLayout());
        setSize(400, 400);
        JScrollPane s = new JScrollPane();
        p1 = new JPanel();
        p2 = new JPanel(new GridLayout(size+1, 4));
        p3 = new JPanel();
        l1 = new JLabel("Name");
        l2 = new JLabel("Quantity");
        l3 = new JLabel("Price");
        l4 = new JLabel("Description");
        //l6 = new JLabel("Category");
        b = new JButton("Back");
        l = new JLabel("Stats");
        MyActionListener a = new MyActionListener();
        b.addActionListener(a);
        p1.add(l);
        p2.add(l1);
        p2.add(l2);
        p2.add(l3);
        p2.add(l4);
        //p2.add(l6);
        p3.add(b);
        
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < 5; j++) {
                    if (j == 0){
                        l5 = new JLabel(iList.get(i).getName());
                        p2.add(l5);
                    } else if (j == 1) {
                        l5 = new JLabel(String.valueOf(iList.get(i).getQuantity()));
                        p2.add(l5);
                    } else if (j == 2) {
                        l5 = new JLabel(String.valueOf(iList.get(i).getPrice()));
                        p2.add(l5);
                    } else if(j==3){
                        l5 = new JLabel(iList.get(i).getDescription());
                        p2.add(l5);
                    } else if(j==4){
                        
                    }
                }
            }
            add(p1, BorderLayout.NORTH);
            add(p2, BorderLayout.CENTER);
            add(p3, BorderLayout.SOUTH);
            setVisible(true);
    }
    /**
     * ActionListener class for the "Back" button.
     */
    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Back")) {
                dispose();
                AdminMenu a = new AdminMenu();
            }
        }
    }
}
