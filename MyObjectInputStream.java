/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myshoppinghub;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.InputStream;

/**
 *
 * @author User
 */public class MyObjectInputStream extends ObjectInputStream{
    public MyObjectInputStream() throws IOException
    {
        super();
    }
    public MyObjectInputStream(InputStream o) throws IOException
    {
        super(o);
    }
    public void writeStreamHeader()
    {
    }
}
