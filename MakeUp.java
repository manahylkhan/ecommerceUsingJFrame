/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myshoppinghub;

/**
 *
 * @author Dell
 */

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */

public class MakeUp implements Serializable{
    //private String category;
    private String name;
    private int quantity;
    private int price;
    private String description;

    public MakeUp() {
    }

    public MakeUp(String name, int quantity, int price,String description) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.description=description;
    }
    public String getDescription()
    {
        return description;
    }
    
    public String getName() {
        return name;
    }


    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description)
    {
        this.description=description;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toString() {
        return "MakeUp\n{name=" + this.getName() + ", quantity=" + this.getQuantity() + ", price=" + this.getPrice() + ", Description="+ this.getDescription()+'}';
    }
    public static void writeMakeUpToFile(ArrayList<MakeUp> i) throws IOException
    {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("MakeUp.dat"))) 
            {
                oos.writeObject(i);
                System.out.println("MakeUp written to file successfully.");
            } 
            catch (IOException e) 
            {
                System.out.println("IOException in write");
                e.printStackTrace();
            }
    }
    public static ArrayList<MakeUp> readMakeUpFromFile() {
    ArrayList<MakeUp> alist = new ArrayList<>();

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("MakeUp.dat"))) {
        alist =(ArrayList<MakeUp>) ois.readObject();

    } catch (ClassNotFoundException | IOException e) {
        e.printStackTrace();
    }

    return alist;
}

    public static void deleteMakeUp(String name)
    {
        ArrayList<MakeUp> alist=MakeUp.readMakeUpFromFile();
        boolean flag=false;
        for(int i=0;i<alist.size();i++)
        {
            if(alist.get(i).getName().equalsIgnoreCase(name))
            {
                flag=true;
            }
        }
        if(flag==true)
        {
            for(int i=0;i<alist.size();i++)
            {
                if(alist.get(i).getName().equalsIgnoreCase(name))
                {
                    alist.remove(i);
                    //i--;
                    break;
                }
            }
        }
        try 
        {
            writeMakeUpToFile(alist); 
        } 
        catch (IOException e) 
        {
            System.out.println("Error writing to file: " + e.getMessage());
            e.printStackTrace();
        }
    }
    //String name, int quantity, int price,String description
    public static void AddMakeUp(MakeUp i)
    {
        ArrayList<MakeUp> alist=MakeUp.readMakeUpFromFile();
        try
        {
            //MakeUp t=new MakeUp(i.getName(),i.getQuantity(),i.getPrice(),i.description);
            alist.add(i);
            MakeUp.writeMakeUpToFile(alist);
        }
        catch(IOException e)
        {
            System.out.println("IOException");
        }
        
    }
    public static void updateMakeUpName(String n,String newN)
    {
            ArrayList<MakeUp> alist=MakeUp.readMakeUpFromFile();
            //boolean it=false;
            for(int i=0;i<alist.size();i++)
            {
                if(alist.get(i).getName().compareTo(n)==0)
                {
                    alist.get(i).setName(newN);
                }
            }
        
        try {
            ObjectOutputStream oos;
            File f = new File("MakeUp.dat");
            oos = new ObjectOutputStream(new FileOutputStream(f));
            for (int i = 0; i < alist.size(); i++) {
                oos.writeObject(alist.get(i));
            }
            oos.close();
        } 
        catch (IOException e) 
        {
            System.out.println("Ioexception");
        }
    }
    public static void updateAnItemQuantity(String n,int newQ) throws IOException
    {
            ArrayList<MakeUp> alist=MakeUp.readMakeUpFromFile();
            boolean flag=false;
            for(int i=0;i<alist.size();i++)
            {
                if(alist.get(i).getName().equalsIgnoreCase(n))
                {
                    flag=true;
                    alist.get(i).setQuantity(newQ);
                }
            }
                MakeUp.writeMakeUpToFile(alist);

             
    }
    public static void updateMakeUpPrice(String name,int price,int newPrice) throws IOException
    {
        ArrayList<MakeUp> alist=MakeUp.readMakeUpFromFile();
        boolean it=false;
        for(int i=0;i<alist.size();i++)
        {
            if(alist.get(i).getPrice()==price && alist.get(i).getName().equalsIgnoreCase(name))
            {
                alist.get(i).setPrice(newPrice);
                it=true;
                break;
            }
            else
            {
                System.out.println("No item with the given price");
            }
        }
        if(it==false)
        {
            System.out.println("No item with this name is present in the list");
        }
        else{
              MakeUp.writeMakeUpToFile(alist);
        }
    }
    public static ArrayList<MakeUp> displayMakeUp()
    {
        ArrayList<MakeUp> alist=MakeUp.readMakeUpFromFile();
        return alist;
    }
    public static boolean findMakeUp(String s)
    {
        ArrayList<MakeUp> ilist=MakeUp.readMakeUpFromFile();
        boolean flag=false;
        for(int i=0;i<ilist.size();i++)
        {
            if(ilist.get(i).getName().equalsIgnoreCase(s))
            {
                flag=true;
            }
        }
        return flag;
    }

}
