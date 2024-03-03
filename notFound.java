/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myshoppinghub;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Dell
 */
public class notFound extends JFrame{
    JLabel l;
    JButton b;
    notFound()
    {
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());
        b=new JButton("ok");
        l=new JLabel("Not Found");
        add(l,BorderLayout.CENTER);
        MyActionListenerForWarning a=new MyActionListenerForWarning();
        b.addActionListener(a);
        add(l,BorderLayout.CENTER);
        add(b,BorderLayout.SOUTH);
        
    }
    public class MyActionListenerForWarning implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getActionCommand().equals("ok"))
            {
                dispose();
                ShoppingMenu a=new ShoppingMenu();
            }
        }
    }
}
