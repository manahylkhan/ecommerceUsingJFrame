/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myshoppinghub;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Items implements Serializable{
    //private String category;
    private String name;
    private int quantity;
    private int price;
    private String description;

    public Items() {
        
    }

    public Items(String name, int quantity, int price,String description) {
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
        return "Items\n{name=" + this.getName() + ", quantity=" + this.getQuantity() + ", price=" + this.getPrice() + ", Description="+ this.getDescription()+'}';
    }
    public static void writeSoldItemToFile(ArrayList<Items> i) throws IOException
    {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("sold.dat"))) 
            {
                oos.writeObject(i);
                System.out.println("Items written to file successfully.");
            } 
            catch (IOException e) 
            {
                System.out.println("IOException in write");
                e.printStackTrace();
            }
    }
    public static ArrayList<Items> readSoldItemFromFile() {
    ArrayList<Items> alist = new ArrayList<>();

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sold.dat"))) {
        alist =(ArrayList<Items>) ois.readObject();

    } catch (ClassNotFoundException | IOException e) {
        e.printStackTrace();
    }

    return alist;
}
    public static void writeItemToFile(ArrayList<Items> i) throws IOException
    {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("items.dat"))) 
            {
                oos.writeObject(i);
                System.out.println("Items written to file successfully.");
            } 
            catch (IOException e) 
            {
                System.out.println("IOException in write");
                e.printStackTrace();
            }
    }
    public static ArrayList<Items> readItemFromFile() {
    ArrayList<Items> alist = new ArrayList<>();

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Items.dat"))) {
        alist =(ArrayList<Items>) ois.readObject();

    } catch (ClassNotFoundException | IOException e) {
        e.printStackTrace();
    }

    return alist;
}
    
    public static void deleteAnItem(String name)
    {
        ArrayList<Items> alist=Items.readItemFromFile();
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
            writeItemToFile(alist); 
        } 
        catch (IOException e) 
        {
            System.out.println("Error writing to file: " + e.getMessage());
            e.printStackTrace();
        }
    }
    //String name, int quantity, int price,String description
    public static void AddAnItem(Items i)
    {
        ArrayList<Items> alist=Items.readItemFromFile();
        try
        {
            //Items t=new Items(i.getName(),i.getQuantity(),i.getPrice(),i.description);
            alist.add(i);
            Items.writeItemToFile(alist);
        }
        catch(IOException e)
        {
            System.out.println("IOException");
        }
        
    }
    public static void updateAnItemName(String n,String newN)
    {
            ArrayList<Items> alist=Items.readItemFromFile();
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
            File f = new File("Items.dat");
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
            ArrayList<Items> alist=Items.readItemFromFile();
            boolean flag=false;
            for(int i=0;i<alist.size();i++)
            {
                if(alist.get(i).getName().equalsIgnoreCase(n))
                {
                    flag=true;
                    alist.get(i).setQuantity(newQ);
                }
            }
                Items.writeItemToFile(alist);

             
    }
    public static void updateAnItemPrice(String name,int price,int newPrice) throws IOException
    {
        ArrayList<Items> alist=Items.readItemFromFile();
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
              Items.writeItemToFile(alist);
        }
    }
    public static ArrayList<Items> displayItems()
    {
        ArrayList<Items> alist=Items.readItemFromFile();
        return alist;
    }
    public static boolean findItem(String s)
    {
        ArrayList<Items> ilist=Items.readItemFromFile();
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
