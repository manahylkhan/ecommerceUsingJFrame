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
public class ItemSearch extends JFrame{
    JButton b,back;
    JLabel l,l1;
    JTextField t;
    JPanel p1,p2,p3;
    ItemSearch()
    {
        setSize(400,400);
        setVisible(true);
        setLayout(new BorderLayout());
        p1=new JPanel();
        p2=new JPanel(new GridLayout(1,2));
        p3=new JPanel(new GridLayout(1,2));
        t=new JTextField();
        l=new JLabel("Enter the Item you want to search");
        b=new JButton("Submit");
        l1=new JLabel("Item name:");
        back=new JButton("Back");
        MyActionListenerForAdmin a=new MyActionListenerForAdmin();
        b.addActionListener(a);
        back.addActionListener(a);
        p1.add(l);
        p2.add(l1);
        p2.add(t);
        p3.add(b);
        p3.add(back);
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
        add(p3,BorderLayout.SOUTH);
    }
    public class MyActionListenerForAdmin implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
             if (ae.getActionCommand().equals("Submit")) {
            ArrayList<Items> iList = Items.readItemFromFile();

                boolean authenticated = false;
                for (int i=0; i<iList.size(); i++) {
                    if (iList.get(i).getName().equalsIgnoreCase(t.getText())) {
                        authenticated = true;
                        break;
                    }
                }

                if (authenticated) {
                    dispose();
                    ShowSearchItem ac = new ShowSearchItem(t.getText());
                } else {
                    dispose();
                    notFound w = new notFound();
                }
             }
            else
            {
                dispose();
                ShoppingMenu b=new ShoppingMenu();
            }
        }
    }
}
