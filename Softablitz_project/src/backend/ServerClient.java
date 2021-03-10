/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Hardik
 */

//It acts as a messenger for Server
public class ServerClient {
    final static int ServerPort = 5436;
    static DataOutputStream dost;
  
    public static void main(String args[]) throws UnknownHostException, IOException  
    { 
        //Connecting Socket
        InetAddress ip = InetAddress.getByName("localhost");
        
        Socket s = new Socket(ip, ServerPort);
        
        DataInputStream dis = new DataInputStream(s.getInputStream()); 
        DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
        dost=dos;
        
        //To send message
        Thread sendMessage = new Thread(new Runnable()  
        { 
            @Override
            public void run() {
                
                    String msg = new String();
                    msg="Connected Successfully#server";
                    try { 
                        dos.writeUTF(msg); 
                    } catch (IOException e) { 
                        System.out.println("Error!!!");
                    }
               
            }
        });
        
        //To read message that are send to server (ServerClient)
        Thread readMessage = new Thread(new Runnable()  
        { 
            @Override
            public void run() { 
  
                while (true) { 
                    try { 
                         
                        String msg = dis.readUTF(); 
                        System.out.println(msg); 
                    } catch (IOException e) { 
  
                        e.printStackTrace(); 
                    } 
                } 
            } 
        });
        
        sendMessage.start(); 
        readMessage.start();
        
    }
    
    //Method to tell to client whether his/her request is successful or not
    public void confirmation(String msg)
    {
        
        Thread sendMessage = new Thread(new Runnable()  
        { 
            @Override
            public void run() {
                    
                    try { 
                        dost.writeUTF(msg); 
                    } catch (IOException e) { 
                        System.out.println("Error in Message!!!");
                    }
                
            }
        });
        sendMessage.start(); 
    }
}

