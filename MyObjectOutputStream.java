/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myshoppinghub;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author User
 */
public class MyObjectOutputStream extends ObjectOutputStream{
    public MyObjectOutputStream() throws IOException
    {
        super();
    }
    public MyObjectOutputStream(OutputStream o) throws IOException
    {
        super(o);
    }
    public void writeStreamHeader()
    {
    }
}

