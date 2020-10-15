/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontPage;

/**
 *
 * @author ABHINAV ANAND
 */
import com.mysql.jdbc.PreparedStatement;
import static java.awt.image.ImageObserver.HEIGHT;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class logincontrol extends login {
    
    String uname, pass;
    
//    public logincontrol(String uname, String pass) {
//        this.uname = uname;
//        this.pass = pass;
//    }

    public static void main(String args[]) {
        
        try {
            Socket socket = new Socket("localhost", 5436);
            BufferedReader bufferedReader = new BufferedReader
                    (new InputStreamReader(System.in));
            System.out.println("Client created.");
            System.out.println("Enter name of client.");
            String uname, pass;
            login l = new login();
            uname = l.uname;
            pass = l.pass;
            
            new logincontrol().checkdb(socket, bufferedReader, uname, pass);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkdb
            (String uname, String pass)
            throws IOException {
//        ObjectOutputStream objectOutputStream =
//                new ObjectOutputStream(socket.getOutputStream());
        PreparedStatement ps;
        ResultSet rs;
        
        String query = "SELECT * FROM `user_details` WHERE `username` =? AND `password` =?";
        try {
            ps = (PreparedStatement) myConnection.getConnection().prepareStatement(query);
            
            ps.setString(1, uname);
            ps.setString(2, pass);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                
                Home_Screen hs = new Home_Screen(uname);
                hs.setVisible(true);
                hs.pack();
                hs.setLocationRelativeTo(null);
//                hs.username.setText("Welcome < "+uname+ " >");
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Incorrect Username or Password", "Login Failed!", HEIGHT);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        String from = "Client - " + uname;
//        Message message = new Message(text, from, "Server");
//        objectOutputStream.writeObject(message);
//        objectOutputStream.flush();
        
    }
}