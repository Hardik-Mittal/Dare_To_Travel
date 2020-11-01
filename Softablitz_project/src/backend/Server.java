/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import static backend.Convert.getSHA;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.util.StringTokenizer;
import java.util.Vector;
import java.sql.SQLException;

/**
 *
 * @author Hardik
 */
public class Server {
    static Vector<ClientHandler> ar = new Vector<>(); //To store client connection details
    static int i = 0;
    
    public static void main(String[] args) throws IOException  
    { 
        //Constructing Server Socket
        ServerSocket ss = new ServerSocket(5436); 
          
        Socket s; 
        
        //Initialising ServerClient Class
        ServerClient sc = new ServerClient();
        ServerClient.main(null);
        
        //Connecting to Clinet through Socket
        while (true)  
        {
            s = ss.accept(); 
  
            System.out.println("New client request received : " + s); 
            
            DataInputStream dis = new DataInputStream(s.getInputStream()); 
            DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
              
            System.out.println("Creating a new handler for this client..."); 
  
            //As we initialised ServerClient with server, ServerClient connection details will add into vector
            if(i==0)
            {
                ClientHandler mtch = new ClientHandler(s,"server", dis, dos,sc);
                
                Thread t = new Thread(mtch); 
              
                System.out.println("Adding this server to active client list");
            
                ar.add(mtch);
                
                t.start();
            }
            
            //Adding Client details into vector
            else
            {
                ClientHandler mtch = new ClientHandler(s,"client " + i, dis, dos,sc);
                
                Thread t = new Thread(mtch); 
              
                System.out.println("Adding this client to active client list");
            
                ar.add(mtch);
                
                t.start();
            } 
            
            i++; 
        }
    } 
}

//ClientHandler to handle our connections
class ClientHandler implements Runnable  
{ 
    
    private String name; 
    final DataInputStream dis; 
    final DataOutputStream dos; 
    Socket s; 
    ServerClient sc;
    boolean isloggedin; 
    
    public ClientHandler(Socket s, String name, DataInputStream dis, DataOutputStream dos, ServerClient sc) { 
        this.dis = dis; 
        this.dos = dos; 
        this.name = name; 
        this.s = s; 
        this.sc=sc;
        this.isloggedin=true; 
    } 
    
    //Receiving Messages and sending it to other mentioned client/serverclient through socket
    @Override
    public void run() { 
        String received; 
        while (true)  
        { 
            try
            {
                received = dis.readUTF(); 
                  
                System.out.println(received); 
                
                StringTokenizer st = new StringTokenizer(received, "#"); 
                String action = st.nextToken();
                String sender = this.name;
                
                //If Login
                if(action.equals("Login"))
                {
                    //Table to decide which table to call from database
                    String table = st.nextToken();
                    String user = st.nextToken();
                    
                    String passweak = st.nextToken();
                    String pass = passweak;
                    
                    try{
                        pass = Convert.toHexString(getSHA(passweak));
                        System.out.println(pass);
                    }catch(NoSuchAlgorithmException e)
                    {
                        e.printStackTrace();
                    }
                    
                    String permission = "false#"+sender;
                    
                    if(pass.equals(passweak))
                    {
                        permission="false#"+sender;
                        
                        sc.confirmation(permission);
                        
                        return;
                    }
                    
                    //SQL Injection
                    try{
                        PreparedStatement ps;
                        ResultSet rs;
                        
                        String query = "SELECT * FROM `"+table+"` WHERE `username` =? AND `password` =?";
                        
                        try {
                            ps = (PreparedStatement) MyConnection.getConnection().prepareStatement(query);
            
                            ps.setString(1, user);
                            ps.setString(2, pass);
            
                            rs = ps.executeQuery();
                            
                            //String permission;
                            
                            //If username and password matches, we send true to user
                            if(rs.next()){
                                permission="true#"+sender;
                            }
                            //Else false
                            else{
                                permission="false#"+sender;
                            }
                            
                            //Sending to user via ServerClient
                            sc.confirmation(permission);
                            
                        }catch(SQLException se){
                            se.printStackTrace();
                            System.out.println("Error while fetching data from Database. Please Check the Connection.");
                        }
                    }catch(Exception e){
                        System.out.println("Can't fetch data from DataBase.");
                    }
                }
                
                //If for Registration, Mostly same as Login
                else if(action.equals("Registration"))
                {
                    String fName = st.nextToken();
                    String lName = st.nextToken();
                    String user = st.nextToken();
                    String passweak = st.nextToken(); 
                    String email = st.nextToken();
                    String contact = st.nextToken();
                    String gender = st.nextToken();
                    
                    String pass = passweak;
                    
                    try{
                        pass = Convert.toHexString(getSHA(passweak));
                        System.out.println(pass);
                    }catch(NoSuchAlgorithmException e)
                    {
                        e.printStackTrace();
                    }
                    
                    String permission = "false#"+sender;
                    
                    if(pass.equals(passweak))
                    {
                        permission="false#"+sender;
                        
                        sc.confirmation(permission);
                        
                        return;
                    }
                    
                    try{
                        
                        String query = "insert into user_details values(null,'"+fName+"','"+lName+"','"+user+"','"+pass+"','"+email+"','"+contact+"','"+gender+"')";
                        
                        Statement stat = (Statement) MyConnection.getConnection().createStatement();
                        
                        int x = stat.executeUpdate(query); 
                        
                        //String permission;
                        
                        //If data is stored successfully, then we get 1
                        if(x==1)
                        {
                            permission="true#"+sender;
                        }
                        else
                        {
                            permission="false#"+sender;
                        }
                                              
                        sc.confirmation(permission);
                        
                    }catch(Exception e)
                    {
                        System.out.println("Can't reach DataBase.");
                    }
                }
                
                //To check if Username or Email ID is already registred or not
                else if(action.equals("Check"))
                {
                    String variable = st.nextToken();
                    String value = st.nextToken();                    
                    
                    try{
                        PreparedStatement ps;
                        ResultSet rs;
                        
                        String query = "SELECT * FROM `user_details` WHERE `"+variable+"` =?";
                        
                        try {
                            ps = (PreparedStatement) MyConnection.getConnection().prepareStatement(query);
            
                            ps.setString(1, value);
            
                            rs = ps.executeQuery();
                            
                            String permission;
                            
                            if(rs.next()){
                                permission="true#"+sender;
                            }
                            else{
                                permission="false#"+sender;
                            }
                            
                            sc.confirmation(permission);
                            
                        }catch(SQLException se){
                            se.printStackTrace();
                            System.out.println("Error while fetching data from Database. Please Check the Connection.");
                        }
                    }catch(Exception e){
                        System.out.println("Can't fetch data from DataBase.");
                    }
                }
                
                /*else if(action.equals("TrainDetAdd"))
                {
                    String train_no = st.nextToken();
                    String train_name = st.nextToken();
        
                    String train_source = st.nextToken();
                    String train_dest = st.nextToken();
                    String train_route = st.nextToken();
                    
                    String departTime = st.nextToken();
                    String status = st.nextToken();
                    
                    String ac_II_S = st.nextToken();
                    String ac_II_P = st.nextToken();
        
                    String sleeper_S = st.nextToken();
                    String sleeper_P = st.nextToken();
      
                    String permission = "false#"+sender;
                    
                    try{
                        
                        String insertQuery = "insert into train_details values(null,'"+train_no+"','"+train_name+"','"+train_source+"','"+train_dest+"','"+train_route+"','"+departTime+"','"+status+"','"+ac_II_S+"','"+ac_II_P+"','"+sleeper_S+"','"+sleeper_P+"',null,'"+ac_II_S+"', '"+sleeper_S+"')";
                        
                        Statement stat = (Statement) MyConnection.getConnection().createStatement();
                        
                        int x = stat.executeUpdate(insertQuery); 
                       
                        //If data is stored successfully, then we get 1
                        if(x==1)
                        {
                            permission="true#"+sender;
                        }
                        else
                        {
                            permission="false#"+sender;
                        }
                                              
                        sc.confirmation(permission);
                        
                    }catch(Exception e)
                    {
                        System.out.println("Can't reach DataBase.");
                    }
                }*/
                
                else if(action.equals("EmpAdd"))
                {
                    String fName = st.nextToken();
                    String lName = st.nextToken();
                    String contact = st.nextToken();
                    String desg = st.nextToken();
                    
                    String permission = "false#"+sender;
                    
                    try{
                        
                        String insertQuery = "insert into emp_details values(null,'"+fName+"','"+lName+"','"+contact+"','"+desg+"')";
                        
                        Statement stat = (Statement) MyConnection.getConnection().createStatement();
                        
                        int x = stat.executeUpdate(insertQuery); 
                       
                        //If data is stored successfully, then we get 1
                        if(x==1)
                        {
                            permission="true#"+sender;
                        }
                        else
                        {
                            permission="false#"+sender;
                        }
                                              
                        sc.confirmation(permission);
                        
                    }catch(Exception e)
                    {
                        System.out.println("Can't reach DataBase.");
                    }
                }
                
                /*else if(action.equals("Station"))
                {
                    
                    String table = st.nextToken();
                    String station = "NA";
                    
                    try{
                        
                Statement stat = (Statement) MyConnection.getConnection().createStatement();
                String selectQuery = "select distinct "+table+" from train_details";
                ResultSet rs = stat.executeQuery(selectQuery);
                
                while(rs.next()){
                    
                   station=rs.getString("train_source");
                   
                   sc.confirmation(station+"#"+sender);
                   
                   station = "NA";
                    
                }
                        
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    
                }*/
                
                String recipient = st.nextToken();
                
                //Checking if Client is stored in the vector and is online
                for (ClientHandler mc : Server.ar)  
                {
                    if (mc.name.equals(recipient) && mc.isloggedin==true)  
                    { 
                        mc.dos.writeUTF(this.name+" : "+action); 
                        break; 
                    } 
                }
            }catch (IOException e) { 
                  System.out.println(this.s + " Disconnected");
                  try{
                  this.isloggedin=false; 
                  this.s.close();
                  }catch(IOException ex)
                  {
                      ex.printStackTrace();
                  }
                  finally{
                  break; 
                  }
                
            } 
        }
        
        //closing connection with client
        try
        { 
            this.dis.close(); 
            this.dos.close();
        }catch(IOException e){ 
            e.printStackTrace(); 
        } 
    }
}
