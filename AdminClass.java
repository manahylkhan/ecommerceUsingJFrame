/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myshoppinghub;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class AdminClass extends Person implements Serializable{
        private String id,passward;

    AdminClass(String name, String gender, String id, String passward) 
    {
        super(name, gender);
        this.id = id;
        this.passward = passward;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassward() {
        return passward;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }

    public String toString() {
        return super.toString()+"Manager{" +"id='" + id +", passward='" + passward +'}';
    }
    private static final String ADMIN_FILE = "admins.dat";
    public static void writeAdminToFile(ArrayList<AdminClass> adminList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ADMIN_FILE))) {
            oos.writeObject(adminList);
            System.out.println("Admins written to file successfully.");
        } catch (IOException e) {
            System.out.println("IOException while writing to admin file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static ArrayList<AdminClass> readAdminFromFile() {
        ArrayList<AdminClass> adminList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ADMIN_FILE))) {
            adminList = (ArrayList<AdminClass>) ois.readObject();
            System.out.println("Admins read from file successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading from admin file: " + e.getMessage());
            e.printStackTrace();
        }
        return adminList;
    }
    public static boolean searchAdminByName(String name) {
        boolean flag=false;
        ArrayList<AdminClass> adminList = readAdminFromFile();

        for (AdminClass admin : adminList) {
            if (admin.getName().equalsIgnoreCase(name)) {
                flag=true; 
            }
        }
        return flag; 
    }
}
