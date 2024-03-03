/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myshoppinghub;

import java.io.Serializable;

/**
 *
 * @author Dell
 */
import java.io.*;
import java.util.ArrayList;
import static myshoppinghub.Items.writeItemToFile;

public class Customer extends Person implements Serializable {
    private String username; 
    private String password;

    public Customer(String name,String gender,String username, String password) {
        super(name, gender);
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public static String getCUSTOMER_FILE() {
        return CUSTOMER_FILE;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    private static final String CUSTOMER_FILE = "customers.dat";
    
    public static boolean verifyLogin(String u, String p) 
    {
        ArrayList<Customer> customers = readCustomersFromFile();
        for (Customer customer : customers) 
        {
            if (customer.getUsername().equals(u) && customer.getPassword().equals(p)) 
            {
                return true; 
            }
        }
        return false; 
    }

    public static ArrayList<Customer> readCustomersFromFile() 
    {
        ArrayList<Customer> customers = new ArrayList<>();
    
    File file = new File(CUSTOMER_FILE);
    
    if (!file.exists()) {
        System.out.println("File not found. Creating a new customer list.");
        return customers;
    }

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CUSTOMER_FILE))) {
        customers = (ArrayList<Customer>) ois.readObject();
        System.out.println("Customers read from file successfully.");
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Error reading customers from file: " + e.getMessage());
        e.printStackTrace();
    }
    return customers;
    }

    public static void writeCustomersToFile(ArrayList<Customer> customers) 
    {
        try (ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(CUSTOMER_FILE))) 
        {
            if (customers.isEmpty()) 
            {
                System.out.println("No customers to write.");
            } 
            else 
            {
                oos.writeObject(customers);
                System.out.println("Customers written to file successfully.");
            }
        } 
        catch (IOException e) 
        {
            System.out.println("Error writing customers to file: "+e.getMessage());
            e.printStackTrace();
        }
    }
    public static boolean isUsernameTaken(String username, ArrayList<Customer> customers) {
        for (Customer customer : customers) {
            if (customer.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
//    public static void addCustomer(Customer newCustomer) 
//    {
//        ArrayList<Customer> cList=readCustomersFromFile();
//        if (isUsernameTaken(newCustomer.getUsername(),cList)) 
//        {
//            System.out.println("Username is already taken. Please choose another username.");
//            return;
//        }
//        cList.add(newCustomer);
//        writeCustomersToFile(cList);
//        System.out.println("Customer added successfully.");
//    }
     public static void updatePassword(String username,String newPassword) {
        
        ArrayList<Customer> customers = readCustomersFromFile();

        //boolean found=false;
        for (Customer customer:customers) {
            if (customer.getUsername().equals(username)) {
                customer.setPassword(newPassword);
                break;
            }
        }
        writeCustomersToFile(customers);
    }
     public static void deleteCustomer(String name)
    {
        ArrayList<Customer> alist=Customer.readCustomersFromFile();
        boolean flag=false;
        for(int i=0;i<alist.size();i++)
        {
            if(alist.get(i).getUsername().equalsIgnoreCase(name))
            {
                flag=true;
            }
        }
        if(flag==true)
        {
            for(int i=0;i<alist.size();i++)
            {
                if(alist.get(i).getUsername().equalsIgnoreCase(name))
                {
                    alist.remove(i);
                    //i--;
                    break;
                }
            }
        }
        writeCustomersToFile(alist);
    }
    public static void AddCustomer(Customer i)
    {
        ArrayList<Customer> alist=Customer.readCustomersFromFile();
        alist.add(i);
        Customer.writeCustomersToFile(alist);
    }
}
