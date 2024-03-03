/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myshoppinghub;

/**
 *
 * @author Dell
 */
import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String gender;

    public Person(String name,String gender) {
        this.name = name;
        this.gender=gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return this.gender;
    }
        

    public void setContantnum(String gender) {
        this.gender = gender;
    }

    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
    public void display(){
        System.out.println("Person{" +
                "name='" + this.getName() + '\'' +
                ", cgender='" + this.getGender() + '\'' +'}');
    }
}
