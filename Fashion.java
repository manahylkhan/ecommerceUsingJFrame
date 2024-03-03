/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myshoppinghub;

import java.io.Serializable;

/**
 *
 * @author User
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

public class Fashion extends Items implements Serializable{
    private String category;
    public Fashion() {
    }

    public Fashion(String name, int quantity, int price,String description,String category) {
        super(name,quantity,price,description);
        this.category=category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
   

    public String toString() 
    {
        return super.toString() + "Category" + this.getCategory() + '}';
    }
    public static void writeFashionToFile(ArrayList<Fashion> i) throws IOException
    {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Fashion.dat"))) 
            {
                oos.writeObject(i);
                System.out.println("Fashion written to file successfully.");
            } 
            catch (IOException e) 
            {
                System.out.println("IOException in write");
                e.printStackTrace();
            }
    }
    public static ArrayList<Fashion> readFashionFromFile() {
    ArrayList<Fashion> alist = new ArrayList<>();

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Fashion.dat"))) {
        alist =(ArrayList<Fashion>) ois.readObject();

    } catch (ClassNotFoundException | IOException e) {
        e.printStackTrace();
    }

    return alist;
}

    public static void deleteFashion(String name)
    {
        ArrayList<Fashion> alist=Fashion.readFashionFromFile();
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
            writeFashionToFile(alist); 
        } 
        catch (IOException e) 
        {
            System.out.println("Error writing to file: " + e.getMessage());
            e.printStackTrace();
        }
    }
    //String name, int quantity, int price,String description
    public static void AddFashion(Fashion i)
    {
        ArrayList<Fashion> alist=Fashion.readFashionFromFile();
        try
        {
            //Fashion t=new Fashion(i.getName(),i.getQuantity(),i.getPrice(),i.description);
            alist.add(i);
            Fashion.writeFashionToFile(alist);
        }
        catch(IOException e)
        {
            System.out.println("IOException");
        }
        
    }
    public static void updateFashionName(String n,String newN)
    {
            ArrayList<Fashion> alist=Fashion.readFashionFromFile();
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
            File f = new File("Fashion.dat");
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
    public static void updateFashionQuantity(String n,int newQ) throws IOException
    {
            ArrayList<Fashion> alist=Fashion.readFashionFromFile();
            boolean flag=false;
            for(int i=0;i<alist.size();i++)
            {
                if(alist.get(i).getName().equalsIgnoreCase(n))
                {
                    flag=true;
                    alist.get(i).setQuantity(newQ);
                }
            }
                Fashion.writeFashionToFile(alist);

             
    }
    public static void updateFashionPrice(String name,int price,int newPrice) throws IOException
    {
        ArrayList<Fashion> alist=Fashion.readFashionFromFile();
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
              Fashion.writeFashionToFile(alist);
        }
    }
    public static ArrayList<Fashion> displayFashion()
    {
        ArrayList<Fashion> alist=Fashion.readFashionFromFile();
        return alist;
    }
    public static boolean findFashion(String s)
    {
        ArrayList<Fashion> ilist=Fashion.readFashionFromFile();
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
